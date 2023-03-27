package ezen.springmvc.web.controller.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

@Controller
public class MemberRegisterControllerV1{
	
	@RequestMapping("/springmvc/members/register")
	public ModelAndView	process(HttpServletRequest request, HttpServletResponse response) { //내부적으로reflection으로 먼저 분석,좋은방법은아님, 쉬운방법있음
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		// 서비스 객체를 이용한 회원 등록
		// memberService.registerMember(member);
		
		ModelAndView mav = new ModelAndView("member/register-result");
		mav.addObject("member", member);
		return mav;
	}
}

