package edu.qd.userbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("edu.qd.userbackend.dao")
public class UserbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserbackendApplication.class, args);
	}
}