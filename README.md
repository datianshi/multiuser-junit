Multiuser-junit
===============

This application demos how to use Junit @TestRule to support multiple thread testing of junit.

How to use
----------
The MultiUserTestRule will be applied if annotated with @Rule and configured with appropriate value of numOfUsers and thread pool size 

```java
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

```

Result of the Run
-----------------

pool-1-thread-3 is running the test <br/>
pool-1-thread-4 is running the test <br/>
pool-1-thread-2 is running the test <br/>
pool-1-thread-1 is running the test <br/>
pool-1-thread-5 is running the test
