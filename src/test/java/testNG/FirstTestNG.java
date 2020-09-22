package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.AnnotationTest;
import listeners.RetryTest;


@Listeners(AnnotationTest.class)
public class FirstTestNG {
  @Test
  public void testCase1() {
	  System.out.println("in testcase1 making changes");
	  Assert.assertFalse(true);
  }
  
  @Test
  public void testCase2() {
	  System.out.println("in testcase2 making changes");
	  Assert.assertFalse(true);
  }
}
