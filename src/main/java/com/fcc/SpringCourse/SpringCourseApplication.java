package com.fcc.SpringCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringCourseApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(SpringCourseApplication.class, args);

//		FirstClass f1=ctx.getBean(FirstClass.class);
		//FirstClass f1=new FirstClass();
//		System.out.println(f1.sayHello());
//		FirstService f2=ctx.getBean(FirstService.class);
//		System.out.println(f2.tellaStory());
//		System.out.println(f2.getJavaVersion());
//		System.out.println(f2.getCustomprop());
//	}
	}

}
