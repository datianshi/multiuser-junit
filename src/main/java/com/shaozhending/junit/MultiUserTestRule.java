package com.shaozhending.junit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This class is to use multiple thread to execute the tests
 * 
 * @author Shaozhen Ding
 *
 */
public class MultiUserTestRule implements TestRule{
	
	private final int numOfUsers;
	private final ExecutorService executor;
	
	public MultiUserTestRule(int poolSize, int numOfUsers){
		this.numOfUsers = numOfUsers;
		executor = Executors.newFixedThreadPool(poolSize);
	}

	public Statement apply(Statement base, Description description) {
		return new CustomStatement(base);
	}
	
	private class CustomStatement extends Statement{
		
		private Statement base;
		
		public CustomStatement(Statement base) {
			this.base = base;
		}

		@Override
		public void evaluate() throws Throwable {
			for(int i=0; i< numOfUsers; i++){
				executor.execute(new Thread(new Runnable() {
					
					public void run() {
						try {
							base.evaluate();
						} catch (Throwable e) {
							throw new IllegalArgumentException(e);
						}
					}
				}));
			}
		}
		
	}

}
