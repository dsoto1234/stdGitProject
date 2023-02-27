package com.acs.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.stereotype.Component;

//@Component
public class DannyReader implements ItemReader<String>{
	
	private String[] arr = {"first line", "second line", "third line"};
	private int count = 0;
	
	public DannyReader() {
		System.out.println("in DannyReader constructor");
	}
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("in DannyReader.read() count:"+count);
		if (count < arr.length) {
			return arr[count++];
		} else
			count = 0;
		
		return null;
	}

}
