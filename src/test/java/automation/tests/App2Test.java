package automation.tests;

import automation.base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class App2Test extends TestBase {

    @Test
    public void testss(){
        System.setProperty("org.uncommons.reportng.escape-output","false");
        driver.findElement(By.cssSelector(other.getProperty("learnmore"))).click();
       // Thread.sleep(3000);



        Assert.assertTrue(false);
    }

    @AfterMethod
    public void After(){
        driver.quit();
    }

}
