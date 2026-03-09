package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class Main {
	public static void main(String[] args) {
		String config_loc = "in/cg/resources/ApplicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);
		
		//Student std = (Student) context.getBean("StdId");
		//std.display();
		Student s1=(Student) context.getBean("student");
		s1.display();
		
		
	}

}
