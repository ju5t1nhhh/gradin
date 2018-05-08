package edu.qd.adminbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@MapperScan("edu.qd.adminbackend.dao")
public class AdminbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminbackendApplication.class, args);
	}
}
