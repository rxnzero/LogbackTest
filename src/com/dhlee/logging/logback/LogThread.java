package com.dhlee.logging.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LogThread implements Runnable {

	static Logger logger = LoggerFactory.getLogger(LogThread.class);

	private String name;
	
	@Override
	public void run() {
		System.out.println("run-"+getName());
		MDC.put("logFileName", getName());
		logger.debug("hello");
		//remember remove this
		MDC.remove("logFileName");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
