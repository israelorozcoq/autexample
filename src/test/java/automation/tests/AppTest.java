package automation.tests;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import java.lang.reflect.Method;



/**
 * Unit test for simple App.
 */
public class AppTest implements ITest
{

    private ThreadLocal<String> testName = new ThreadLocal<>();

    @DataProvider(name = "role")
    public static Object[][] roles() {
        return new Object[][] {{"Developer"},{"Team Lead"},{"QA"},{"Business Analyst"},{"DevOps Eng"},{"PMO"} };
    }



    @BeforeMethod
    public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
        if (testData.length > 0) {
            testName.set(method.getName() + "*-_-*" + testData[0]);
            ctx.setAttribute("testName", testName.get());
        } else
            ctx.setAttribute("testName", method.getName());
    }

    @Override
    public String getTestName() {
        return testName.get();
    }

    /**
     * Rigorous Test :-)
     */
    @Test (dataProvider = "role")
    public void MA(String role)
    {System.out.println(""+role);
        //assertTrue( true );
    }
}
