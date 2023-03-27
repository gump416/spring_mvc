package ezen.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class SpringMvcApplication { //스프링부트어플리케이션

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args); //리플렉션
	}

}
