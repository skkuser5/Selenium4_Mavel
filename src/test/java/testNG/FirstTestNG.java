package testNG;

import org.testng.annotations.Test;

public class FirstTestNG {
  @Test
  public void testCase1() {
	  System.out.println("in testcase1 making changes");
  }
  
  @Test(enabled = false)
  public void testCase2() {
	  System.out.println("in testcase2 making changes");
  }
}
