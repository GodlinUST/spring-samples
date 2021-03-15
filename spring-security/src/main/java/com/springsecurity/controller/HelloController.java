package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Exited to have Spring security here";
	}
	

	@GetMapping("/bye")
	public String bye()
	{
		return "Get Lost";
	}

}
