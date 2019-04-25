package com.certiorem.workSelectorAlgoritm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.certiorem.workSelectorAlgoritm.model.Company;

@Controller
class MainController{
	
	@Autowired
	private CompanyController companyController;
	
	@RequestMapping("/")
	public String mensaje(Model model) {
		List<Company> companies = companyController.getAllCompanies();
		model.addAttribute("companies", companies);
		return "welcome";
	}
	
	@RequestMapping("/postman")
	public String masaje(Model model) {
		List<Company> companies = companyController.getAllCompanies();
		model.addAttribute("companies", companies);
		return "postman";
	}
	
	
	
}