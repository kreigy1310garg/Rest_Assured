package Spring.Rest;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class HooksTest {

	
	@Before
	public void before()
	{
		System.out.println("I will run before every scenario.");
	}
	
	@After
	public void after()
	{
		System.out.println("I will run after after every scenario.");
	}
}
