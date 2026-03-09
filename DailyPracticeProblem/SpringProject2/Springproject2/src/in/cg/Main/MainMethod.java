package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class MainMethod {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
				
		
	   //Student s1=(Student) context.getBean(Student.class);
	   
	   Student s1=(Student) context.getBean("Stdid",Student.class);
	   Student s2=(Student) context.getBean("Stdobj2",Student.class);
	  //Student s1=(Student) context.getBean("Stdid");
	  //Student s2=(Student) context.getBean("Stdobj2");
		s1.display();
		//s2.display();
	
	}

}
