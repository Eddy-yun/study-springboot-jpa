package com.eddystation.study.springbootjpa.web.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping( "/hello" )
	public String hello() {
		return "hello";
	}

}

