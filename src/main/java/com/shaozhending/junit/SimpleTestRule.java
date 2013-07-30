package com.shaozhending.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Simple Test Rule to demo how the Test rule works
 * 
 * @author Shaozhen Ding
 *
 */
public class SimpleTestRule implements TestRule{
	
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
			//Before test execution
			System.out.println("Before Test Running");
			//Test execution
			base.evaluate();
			//After test execution
			System.out.println("After Test Running");
			
		}
		
	}
}
