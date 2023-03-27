package ezen.springmvc.web.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberFormControllerV1{
	
	@RequestMapping("/springmvc/members/register-form")
	public ModelAndView	process() {
		return new ModelAndView("member/register-form");
	}
}

