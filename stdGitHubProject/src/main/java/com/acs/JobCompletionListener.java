package com.acs;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport{
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("in JobCompletionListener.afterJob");
		
		if(jobExecution.getStatus() == BatchStatus.COMPLETED)
			System.out.println("Batch job completed successfully");
		
		System.out.println("out JobCompletionListener.afterJob");
	}

}
