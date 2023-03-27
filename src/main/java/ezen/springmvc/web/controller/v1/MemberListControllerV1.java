package ezen.springmvc.web.controller.v1;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

@Controller
public class MemberListControllerV1{
	
	@RequestMapping("/springmvc/members")
	public ModelAndView	process() {
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

