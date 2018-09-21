package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral2jari";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name","KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam( value ="a", required = false, defaultValue = "0") String value1, @RequestParam(value = "b", required = false, defaultValue = "0" ) String value2, @RequestParam( value ="answer", required = false) String answer, @RequestParam( value ="answer1", required = false) String answer1, Model model){
		model.addAttribute("value1", value1);
		model.addAttribute("value2", value2);
		String temp = "hm";
		
		if(value1.contentEquals("0") && value2.contentEquals("0")) {
			model.addAttribute("answer","hm");
		}
		else {
			for(int i=1; i<Integer.parseInt(value1);i++) {
				temp += "m";
			}
			String kalimat = "";
			for(int j=0; j<Integer.parseInt(value2); j++) {
				kalimat += temp +" ";
			}
			model.addAttribute("answer", kalimat);
		}
		return "generator";
	}
}
