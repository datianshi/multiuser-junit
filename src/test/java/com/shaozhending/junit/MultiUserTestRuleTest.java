package com.shaozhending.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class MultiUserTestRuleTest {
	/**
	 * The thread pool size is 10
	 * There are 5 users run the tests
	 */
	@Rule
	public TestRule rule = new MultiUserTestRule(10, 5);
	
	@Test
	public void test(){
		System.out.println(Thread.currentThread().getName() + " is running the test");
	}
}
