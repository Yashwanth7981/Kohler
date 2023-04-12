package TestNG1;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Demo{
	@Test
	@AfterTest
	public void gun() {
Reporter.log("Demo",true);
}
}

