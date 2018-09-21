package com.bongpive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bongpive.domain.BoardVO;
import com.bongpive.persistence.BoardDAO;

@Controller
//@RequestMapping("board/")
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	
	@RequestMapping("list")
	public String list(BoardVO vo, Model model) {
		List<BoardVO> list = dao.list();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("register")
	public String register() {
		return "board/register";
	}
}
