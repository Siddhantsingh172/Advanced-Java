package in.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Person;

@Configuration
public class AppConfig {

    @Bean
    public Person personBean() {

        return new Person(
                "Model Town",
                "Jalandhar",
                144411
        );

    }

}