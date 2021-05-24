package com.spring.mvc.demo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.demo.pojo.User;

@Controller
public class FormCtrl {

	@RequestMapping(value= "/init", method= RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("userform", new User());
		return "loginForm";
	}

	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("userform") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "loginForm";
		}

		return "success";
	}
}