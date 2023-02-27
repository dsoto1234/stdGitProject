package com.acs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StdGitHubProjectApplication {

	public static void main(String[] args) {
		System.out.println("in StdGitHubProjectApplication.main()");
		
		SpringApplication.run(StdGitHubProjectApplication.class, args);
		
		System.out.println("out StdGitHubProjectApplication.main()");
	}

}
