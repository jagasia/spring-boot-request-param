package com.cts.hrms.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.hrms.entity.Employee;

@Controller
public class MyController {
	ArrayList<Employee> employees=new ArrayList<>();
	
	public MyController()
	{

		employees.add(new Employee(1, "Ram", "Kumar", 121212.0));
		employees.add(new Employee(2, "Abdul", "Raheem", 787878.0));
		employees.add(new Employee(3, "Zaheer", "Khan", 3838383.0));
		employees.add(new Employee(4, "Bhubaneshwar", "Kumar", 938473.0));
		employees.add(new Employee(5, "Sathish", "Kumar", 121212.0));
		
	}
	
	@GetMapping("/")
	public String home()
	{
		return "index";	//let the  prefix and suffix be applied 
	}
	
	//when i submit the form 
	@GetMapping("/add")
	@ResponseBody
	public String addNumbers(@RequestParam("no1") int no1, @RequestParam("no2") int no2, ModelMap model)
	{
		int sum=no1+no2;
		System.out.println(sum);
		model.addAttribute("sum", sum);
		return "The result is "+sum;
	}
	
	@ModelAttribute("employees")
	public ArrayList<Employee> getEmployees()
	{
		
		return employees;
	}
	
	//to show employee.jsp
	
	@RequestMapping(method = RequestMethod.GET, value = "/show")
	public ModelAndView showEmployeeForm()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("employee");
		
//		mv.addObject("employees",getEmployees());
		mv.addObject("employee", new Employee());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add", params = "add")
	
	public ModelAndView addEmployee(@Valid Employee employee, BindingResult br)
	{
		ModelAndView mv=new ModelAndView();
		if(br.hasErrors())
		{
			System.out.println("There are validation failures");
			mv.setViewName("employee");
			mv.addObject("employee", employee);
			return mv;
		}
		ArrayList<Employee> employees = getEmployees();
		employees.add(employee);
		return showEmployeeForm();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add", params = "update")
	@ResponseBody
	public String updateEmployee(Employee employee)
	{
		return "Updating";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add", params = "delete")
	@ResponseBody
	public String deleteEmployee(Employee employee)
	{
		return "Deleting";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/select/{id}")
	@ResponseBody
	public ModelAndView select(@PathVariable("id") Integer id)
	{
		ArrayList<Employee> employees = getEmployees();
		Employee employee=new Employee();
		for(Employee e:employees)
		{
			if(e.getId().equals(id))
			{
				employee=e;
			}
		}
		ModelAndView mv=new ModelAndView("employee");
		mv.addObject("employee", employee);
		return mv;
	}
}
