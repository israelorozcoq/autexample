package automation;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseTestMethod;
import org.testng.internal.TestResult;
import java.lang.reflect.*;
import java.util.Set;
import org.testng.Reporter;

public class Listener  implements ITestListener  {

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        //
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //screenshot
        if (result.getParameters().length != 0) {

            String params = null;
            final String NL = System.getProperty("line.separator");

            for (Object parameter : result.getParameters()) {

                params += (NL+" "+parameter.toString() + ",") ;

            }

            Reporter.log(NL+"## Test Method had the following parameters : " + params, true);
        }

    }

    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult cb) {


    }

}
