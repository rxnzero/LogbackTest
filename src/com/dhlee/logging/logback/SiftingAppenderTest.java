package com.dhlee.logging.logback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SiftingAppenderTest {

	public SiftingAppenderTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int count = 1;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		try {
			while(count<=10){
				LogThread logThread = new LogThread();
				logThread.setName("logThread-" + count);
				executorService.execute(logThread);
				count++;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			executorService.shutdown();
		}
	}

}
