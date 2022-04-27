package com.cts.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

	@GetMapping("/")
	public String home()
	{
		return "index";	//let the  prefix and suffix be applied 
	}
	
	//when i submit the form 
	@GetMapping("/add")
	public String addNumbers(@RequestParam("no1") int no1, @RequestParam("no2") int no2, ModelMap model)
	{
		int sum=no1+no2;
		System.out.println(sum);
		model.addAttribute("sum", sum);
		return "result";
	}
	
	
}
