package com.acs.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job processJob;
	
	//http://localhost:8080/invokeJob
	@RequestMapping("/invokeJob")
	public String handle() throws Exception {
		JobParameters jobParameter = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
			.toJobParameters();
		
		jobLauncher.run(processJob, jobParameter);
		
		return "Batch job has been invoked";
	}

}
