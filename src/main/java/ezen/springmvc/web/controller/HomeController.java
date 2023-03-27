package ezen.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/") //요청파일없을때 홈화면 실행
	public String home(Model model) {
		String message = "Spring @MVC";
		model.addAttribute("message", message); //model은 생성할필요없이 담아주기만 하면된다
		return "index";
	}
	

}
