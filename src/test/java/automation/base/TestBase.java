package automation.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.ExtentManager;

import java.io.FileInputStream;
import java.util.Properties;


public class TestBase {

    public  static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties other = new Properties();
    public static FileInputStream fileinput;
    public static FileInputStream fileinputCss;
    public static Logger log =  Logger.getLogger("BaseClass");
    public final String mydir =System.getProperty("user.dir");
    public static WebDriverWait wait;
    public ExtentReports extRepor = ExtentManager.getInstance();
    public static ExtentTest test;

    @BeforeSuite
    public void setUp() throws Exception{


        if(null== driver){
             fileinput = new
                    FileInputStream(mydir+"\\src\\test\\resources\\properties\\cfg.properties");

             fileinputCss = new
                    FileInputStream(mydir+"\\src\\test\\resources\\properties\\other.properties");
            config.load(fileinput);
        }
            log.debug("load config values");
        other.load(fileinputCss);
            log.debug("load ss values");

        if(config.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    mydir+"\\src\\test\\resources\\drivers\\Chromedriver74.exe");

                driver = new ChromeDriver();
            log.debug("chrome launhed");
            }

            driver.get(config.getProperty("testUrl"));
        log.debug("test URL launched");
            driver.manage().window().maximize();


        }



    @AfterSuite
    public void tearDown(){
        log.debug("test execution completed");
    }

}
