package listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import automation.base.TestBase;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import org.testng.log4testng.Logger;
import  util.TestUtil;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
/*
import com.w2a.base.TestBase;

import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.TestUtil;
*/
public class CustomListeners extends TestBase implements ITestListener,ISuiteListener
 {
  private final String mydir =System.getProperty("user.dir");
    public 	String messageBody;


    public void onFinish(ITestContext arg0) {

    }

    public void onStart(ITestContext arg0) {
     //testWatcher.set(extent.createTest(iTestResult.getTestContext().getAttribute("testName").toString()));

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    public void onTestFailure(ITestResult arg0) {

        System.setProperty("org.uncommons.reportng.escape-output","false");
         try {
            TestUtil.captureScreenshot();
        }catch(IOException ioe){
            ioe.printStackTrace();
            //log.debug("load config values");
            Reporter.log("fail"+ ioe.toString() );
        }
        test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));


     Reporter.log("fail");

     Reporter.log("Click to see Screenshot");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
        extRepor.endTest(test);
        extRepor.flush();

    }

    public void onTestSkipped(ITestResult arg0) {

/*
        test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
*/
    }


    public void onTestStart(ITestResult arg0) {

        test = extRepor.startTest(arg0.getName().toUpperCase());

    }

    public void onTestSuccess(ITestResult arg0) {

       // TestBase.
        test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
        extRepor.endTest(test);
        extRepor.flush();

    }

    public void onFinish(ISuite arg0) {

        // MonitoringMail mail = new MonitoringMail();
/*
        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/

    }

    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub

    }

}

