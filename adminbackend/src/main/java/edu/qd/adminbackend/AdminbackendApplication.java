package edu.qd.adminbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("edu.qd.adminbackend.dao")
public class AdminbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminbackendApplication.class, args);
	}
}
