package com.acs.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


//@Component
public class DannyProcessor implements ItemProcessor<String, String> {
	
	public DannyProcessor() {
		System.out.println("in DannyProcessor constructor");
	}
	
	@Override
	public String process(String data) throws Exception{
		System.out.println("in DannyProcessor.process() data: "+data);
		return data.toUpperCase();
	}

}
