package com.m24.learn_springboot_springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m24.learn_springboot_springmvc.service.DemoService;

@RestController
public class MyRestController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value="/testRest", produces="text/plain;charset=UTF-8")
	public String testRest() {
		return demoService.saySomthing();
	}
}
