package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	
	@Bean
	public Student Stdid() {
		Student s1=new Student();
		s1.setId(12214640);
		s1.setName("Siddhant");
		s1.setEmail("siddhantsingh8485.gmail.com");
		
		return s1;
	}
		
		@Bean("Stdobj2")
		public Student createStudentObject() {
			Student s1=new Student();
			s1.setId(12224421);
			s1.setName("Rahul");
			s1.setEmail("rahul.gmail.com");
			
			return s1;
		
	}

}
