package com.dhlee.logging.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import static ch.qos.logback.classic.ClassicConstants.FINALIZE_SESSION_MARKER;

public class LogThread implements Runnable {

	static Logger logger = LoggerFactory.getLogger(LogThread.class);

	private String name;
	
	@Override
	public void run() {
		System.out.println("run-"+getName());
		MDC.put("logFileName", getName());
		logger.debug("hello");
		
		// will cause the nested appender reach end-of-life. It will
	    // linger for a few seconds.
		logger.info(FINALIZE_SESSION_MARKER, "About to end the job");
		
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
