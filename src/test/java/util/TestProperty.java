package util;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperty {

public static void main (String [] args) throws Exception{
    String a =System.getProperty("user.dir");
    Properties config = new Properties();
    Properties other = new Properties();

    FileInputStream fileinput = new
    FileInputStream(a+"\\src\\test\\resources\\properties\\cfg.properties");

    FileInputStream fileinputO = new
    FileInputStream(a+"\\src\\test\\resources\\properties\\other.properties");

    config.load(fileinput);
    other.load(fileinputO);

    System.out.println(config.getProperty("browser"));
    System.out.println(other.getProperty("learnmore"));
}

}
