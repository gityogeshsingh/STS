package com.server.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.server.model.Employee;
import com.server.service.IEmployeeService;

@Controller
public class EmployeeOperationController {
@Autowired
private IEmployeeService service;

@GetMapping("/")
public String showHome() {
	return "home";
}

@GetMapping("/getemployee")
public String getAllEmployee(Map<String, Object> model) {
	model.put("allEmpList",service.getAllEmployee());
	return "employee_records";
}

@GetMapping("/emp_add")
public String addNewEmployee(@ModelAttribute("emp") Employee emp) {
	return "add_employee_records";
}

//@PostMapping("/emp_add")
//public String registerNewEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
//	map.put("result", service.registerEmployee(emp));
////	map.put("allEmpList", service.getAllEmployee());
//	//return "employee_records";
//	return "redirect:getemployee";
//}

//@PostMapping("/emp_add")
//public String registerNewEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map,RedirectAttributes attrs) {
//	attrs.addFlashAttribute("result", service.registerEmployee(emp));
////	map.put("allEmpList", service.getAllEmployee());
//	//return "employee_records";
//	return "redirect:getemployee";
//}

@PostMapping("/emp_add")
public String registerNewEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map,HttpSession session) {
	session.setAttribute("result", service.registerEmployee(emp));
	return "redirect:getemployee";
}

@GetMapping("/emp_edit")
public String editEmployee(@ModelAttribute("emp") Employee emp,@RequestParam("eno") int eid) {
	Employee emp1=service.findEmployeeById(eid);
	BeanUtils.copyProperties(emp1, emp);
	return "update";
}

@PostMapping("/emp_edit")
public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attr) {
	String result=service.updateEmployee(emp);
	attr.addFlashAttribute("result",result);
	return "redirect:getemployee";
}

@GetMapping("/emp_delete")
public String editEmployee(@RequestParam("eno") int eid,RedirectAttributes attrs) {
	String result=service.deleteEmployeeById(eid);
	attrs.addFlashAttribute("result",result);
	return "redirect:getemployee";
}
}
