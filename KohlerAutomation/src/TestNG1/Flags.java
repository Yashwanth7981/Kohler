package TestNG1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Flags {
@Test(priority=1,enabled=false)
public void cost() {
	Reporter.log("Run",true);
}
@Test(priority=2,enabled=false)
public void bun() {
	Reporter.log("Bun",true);
}
@Test(priority=3,enabled=true)
public void gun() {
	Reporter.log("Gun",true);
}

}
