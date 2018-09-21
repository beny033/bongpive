package com.bongpive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfferController {

	@RequestMapping("offer")
	public String offer() {
		return "offer/offer";
	}
}
