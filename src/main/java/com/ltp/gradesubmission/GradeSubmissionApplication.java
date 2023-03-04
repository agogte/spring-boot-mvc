package com.ltp.gradesubmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GradeSubmissionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(GradeSubmissionApplication.class);
	}

}
