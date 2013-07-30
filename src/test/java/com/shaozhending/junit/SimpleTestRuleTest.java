package com.shaozhending.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class SimpleTestRuleTest {
	
	@Rule
	public TestRule rule = new SimpleTestRule();
	
	@Test
	public void test(){
		System.out.println("My test is running");
	}
}
