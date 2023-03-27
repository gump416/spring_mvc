package ezen.springmvc.web.controller.v1;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * 에노테이션 내부에 @Component 에노테이션이 포함되어 있어 컴포넌트 스캔 대상이 되며, 
 * 핸들러 매핑 객체가 메소드 레벨에 선언된 @RequestMapping 정보를 읽어 간다.
 * @Component + @RequestMapping
 */
public class HelloController{
	
//	@RequestMapping("/springmvc/hello.do") //rest api 스타일을 주로 쓰기때문에 확장자 스타일로 안씀
//	@RequestMapping("/springmvc/hello")
	@RequestMapping("/springmvc/*")
	// 에노테이션 기반으로 동작하기 때문에 메소드 이름은 임의로 작성하면 된다
	public ModelAndView	hello() { //viewResolver가 찾아서 Dispatcher Servlet에게 반환
		System.out.println("핸들러 어댑터에 의해서 호출됨...");
		String message = "안녕하세요. Spring MVC";
		// 뷰의 논리적 이름과 뷰가 사용할 데이터를 저장하여 반환
		ModelAndView mav = new ModelAndView("hello"); //hello는 논리적이름, jsp로 실행할지 타임리프로 실행할지  Dispatcher Servlet(지휘자)이 결정함 ,그래서 논리적 이름을 씀 어느 엔진이든 쓸 수 있도록?
										             //실행엔진이 jsp이면 view(실행엔진)가 hello.jsp로 실행, 물리적이름 직접경로 설정도 되지만 비권장
//		mav.setViewName("hello");	
		mav.addObject("message", message);
		return mav;
	}
	
	
	@RequestMapping("/springmvc/today")
	public ModelAndView	today() {
		Calendar today = Calendar.getInstance();
		String formatToday = String.format("%1$tF %1$tT", today);
		
		String message = "안녕하세요. Spring MVC";
		// 뷰의 논리적 이름과 뷰가 사용할 데이터를 저장하여 반환
		ModelAndView mav = new ModelAndView("today"); 
//		mav.setViewName("hello");	
		mav.addObject("today", formatToday);
		return mav;
	}
}


