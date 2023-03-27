package ezen.springmvc.web.controller.v2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

@Controller
public class MemberControllerV2{
	
	@RequestMapping("/springmvc/v2/members/register-form")
	public ModelAndView	registerForm() {
		return new ModelAndView("member/register-form");
	}
	
	@RequestMapping("/springmvc/v2/members/register")
	public ModelAndView	register(HttpServletRequest request, HttpServletResponse response) {
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
	
	@RequestMapping("/springmvc/v2/members")
	public ModelAndView	members() {
		// 서비스 객체를 이용한 회원 목록
		// List<Member> members = memberService.getMembers();
		List<Member> members = new ArrayList<>();
		members.add(new Member("홍길동1", 10));
		members.add(new Member("홍길동2", 20));
		members.add(new Member("홍길동3", 30));
		
		ModelAndView mav = new ModelAndView("member/list");
		mav.addObject("members", members);
		return mav;
	}
}

