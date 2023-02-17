package com.acs.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.JobCompletionListener;
import com.acs.processor.DannyProcessor;
import com.acs.reader.DannyReader;
import com.acs.writer.DannyWriter;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	Job processJob(@Qualifier("batchStep") Step qfreeBatchStep) {
		
		System.out.println("<<<<<< in BatchConfig2.processJob() >>>>>>>");
		
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(dannylistener())
				.flow(qfreeBatchStep)
				.end().build();
	}
	
	@Bean
	ItemReader<String> testReader()  {
		System.out.println("<<<<<<<  in BatchConfig2.testReader() >>>>>>>");
		return new DannyReader();
	}
	@Bean
	ItemWriter<String> testWriter() {
		System.out.println("<<<<<<<  in BatchConfig2.testWriter() >>>>>>>");
		
		return new DannyWriter();
	}
	
	@Bean
	ItemProcessor<String, String> testProcessor() {
		System.out.println("<<<<<<< in BatchConfig2.testProcessor() >>>>>>>");
		return new DannyProcessor();
	}
	
	@Bean
	Step batchStep( @Qualifier("testReader")  	ItemReader<String> readerRef,
					@Qualifier("testWriter") 	ItemWriter<String> writerRef,
					@Qualifier("testProcessor") ItemProcessor<String, String> processorRef
					) {
		
		System.out.println("<<<<<<< in BatchConfig2.batchStep() >>>>>>>");
		
		return stepBuilderFactory.get("QFreeBatchStep")
				.<String, String> chunk(1)
				.reader(readerRef)
				.processor(processorRef)
				.writer(writerRef)
				.build();
	}
	
	@Bean
	public JobExecutionListener dannylistener() {
		System.out.println("in BatchConfig2.dannylistener()");
		
		return new JobCompletionListener();
	}

}
