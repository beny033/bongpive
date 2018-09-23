package com.bongpive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bongpive.domain.BoardVO;
import com.bongpive.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
	public String list(BoardVO board, Model model) {
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		
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
	public String read(@RequestParam("seq") int seq, BoardVO board, Model model) {
		
		model.addAttribute("board", service.read(seq));
		
		return "board/read";
	}
}
