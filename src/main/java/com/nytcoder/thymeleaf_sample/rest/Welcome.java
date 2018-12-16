package com.nytcoder.thymeleaf_sample.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Welcome {
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	@RequestMapping("/choice")
	public String choice(@RequestParam("option") Long option) {
		if(option.equals(1l))
			return "first";
		else if(option.equals(2l))
			return "second";
		else
			return "index";
	}
}
