package com.bongpive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

	@RequestMapping("portfolio")
	public String contents() {
		return "portfolio/contents";
	}
	
	
	
}
