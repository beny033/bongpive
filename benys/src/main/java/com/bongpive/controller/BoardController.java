package com.bongpive.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bongpive.domain.BoardVO;
import com.bongpive.domain.PagingProcess;
import com.bongpive.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping("list")
	public String list(@RequestParam(value = "curruntPage", defaultValue = "1") int curruntPage, BoardVO board, Model model) {

		PagingProcess paging = new PagingProcess();
		paging.setCurruntPage(curruntPage);
		paging.setTotalPosts(service.totalPosts());
		paging.setTotalPages(paging.getTotalPosts());

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("curruntPage", paging.getCurruntPage());
		map.put("pageShown", paging.getPageShown());

		List<BoardVO> list = service.list(map);

		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		return "board/list";
	}

	@RequestMapping("register")
	public String register() {
		return "board/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes redirect) {

		redirect.addFlashAttribute("msg", "SUCCESS");
		service.register(board);
		return "redirect:list";
	}

	@RequestMapping("read")
	public String read(@RequestParam Map<String, Object> map, BoardVO board, Model model) {

		int cp = (Integer.parseInt((String) map.get("curruntPage")) / 10) + 1;

		model.addAttribute("board", service.read(Integer.parseInt((String) map.get("seq"))));
		model.addAttribute("curruntPage", cp);
		return "board/read";
	}

	@RequestMapping("selfCheck")
	public String selfCheck() {
		return "board/selfCheck";
	}

	@RequestMapping(value = "compare", method = RequestMethod.POST)
	public String compare(@RequestParam Map<String, Object> map, RedirectAttributes redirect) {
		String request = (String) map.get("request");
		int seq = Integer.parseInt((String) map.get("seq"));
		int password = Integer.parseInt((String) map.get("password"));
		int cp = Integer.parseInt((String) map.get("curruntPage"));

		if (service.getPassword(seq) == password) {
			if (request.equals("modify")) {
				return "redirect:modify?seq=" + seq + "&curruntPage=" + cp;
			} else if (request.equals("remove")) {
				service.remove(seq);
				redirect.addFlashAttribute("msg", "SUCCESS");
				return "redirect:list?curruntPage=" + cp;
			} else {
				return null;
			}
		} else {
			return "board/passwordError";
		}
	}

	@RequestMapping("modify")
	public String modify(@RequestParam("seq") int seq, Model model) {
		model.addAttribute("board", service.read(seq));
		return "board/modify";
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@RequestParam("curruntPage") int curruntPage, BoardVO board, RedirectAttributes redirect) {

		service.modify(board);

		redirect.addFlashAttribute("msg", "SUCCESS");

		return "redirect:list?curruntPage=" + curruntPage;
	}

}
