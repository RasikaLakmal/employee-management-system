package net.rasikalakmal.employeemanagementsystembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(WebSecurityConfig.class)
@SpringBootApplication
public class EmployeeManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemBackendApplication.class, args);
	}

}
