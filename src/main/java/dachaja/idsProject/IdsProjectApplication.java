package dachaja.idsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //spring security 기능 꺼두기
public class IdsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdsProjectApplication.class, args);
	}

}
