package com.xb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xb.mapper")
public class EasyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyblogApplication.class, args);
	}

}
