package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTests {

	@Test
	public void passtest1() {

		System.out.println("pass test1");
		Assert.assertTrue(true);
		// throw new Exception("Intentional1");
	}

	@Test(dependsOnMethods = "passtest1")
	public void failtest1() {

		System.out.println("fail test1");
		Assert.assertTrue(false);
		// throw new Exception("Intentional1");
	}

	@Test
	public void failtest2() {

		System.out.println("fail test2");
		Assert.assertTrue(false);
		// throw new Exception("Intentional2");
	}

}
