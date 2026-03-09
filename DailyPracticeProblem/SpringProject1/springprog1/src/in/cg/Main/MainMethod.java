package in.cg.Main;
import org.springframework.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;


public class MainMethod {
	public static void main(String[] args) {
		String config_loc = "in/cg/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);
		
		Student std = (Student) context.getBean("StdId");
		std.display();
	}

}