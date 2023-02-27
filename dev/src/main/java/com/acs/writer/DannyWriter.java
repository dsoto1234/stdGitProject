package com.acs.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

//@Component
public class DannyWriter implements ItemWriter<String>{
	
	public DannyWriter() {
		System.out.println("in DannyWriter constructor");
	}
	
	@Override
	public void write (List<? extends String> messages) throws Exception {
		System.out.println("in DannyWriter.write() messages.size(): "+messages.size());
		for(String msg : messages) {
			System.out.println("Writing the data: "+msg);
		}
	}

	
}
