package ezen.springmvc.web.controller.v4;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

@Controller //bean으로 등록하기 위해서 필수
@RequestMapping("/springmvc/v4/members") //중복 경로 선언
public class MemberControllerV4{
	
	@GetMapping("/register-form")
	public String registerForm(Model model) { //어댑터한테 string타입으로 리턴, 그럼어댑터가 모델을 생성해서 디스패쳐한테 전달 
		model.addAttribute("", model); //모델은 데이터담아주는 역할 map 구조,어댑터가 모델을 전달해주면 데이터만 담아서 주면됨
		return "member/register-form";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String name, @RequestParam int age, Model model) { //형변환도 다해줌 @RequestParam("age") -> @RequestParam생략가능, @RequestParam()이것도 생략가능하지만 명시적으로 써주는거 권장
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		// 서비스 객체를 이용한 회원 등록
		// memberService.registerMember(member);
		
		model.addAttribute("member", member);
		return "member/register-result";
	}
	
	//@RequestMapping
	@GetMapping
	public String members(Model model) {
		// 서비스 객체를 이용한 회원 목록
		// List<Member> members = memberService.getMembers();
		List<Member> members = new ArrayList<>();
		members.add(new Member("홍길동1", 10));
		members.add(new Member("홍길동2", 20));
		members.add(new Member("홍길동3", 30));
		
		model.addAttribute("members", members);
		return "member/list";
	}
}

