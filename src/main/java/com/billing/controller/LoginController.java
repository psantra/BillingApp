package com.billing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.billing.model.LoginModel;

@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("Inside Get Method");
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "loginValidate", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginModel loginModel) {

		System.out.println("Inside post method.....");
		if (loginModel != null && loginModel.getUserName() != null & loginModel.getPassword() != null) {
			if (loginModel.getUserName().equals("admin") && loginModel.getPassword().equals("admin")) {
				model.addAttribute("msg", loginModel.getUserName());
				return "fileUpload";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
