package testNG;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4JTest {
	
	static final Logger logger = Logger.getLogger(Log4JTest.class);
	
	@Test
	public void test1()
	{
		logger.info("in test1");
	}
	
	@Test
	public void test2()
	{
		logger.info("in test2");
		
		try {
			
			int test2 = 3/0;
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
	}


}
