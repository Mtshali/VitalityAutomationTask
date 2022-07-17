package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class utils {
    private static WebDriver driver = null;
    public static String File_Name = System.getProperty("user.dir") + "//ProjectData//config.properties";
    public static Properties properties = null;

    public static WebDriver openBrowser(int iTestCaseRow) throws Exception{
        String sBrowserName;
        try{
            sBrowserName="Edge";
            if (sBrowserName.equals("Edge")){
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver.get(Constant.Application_URL);
            }
            if (sBrowserName.equals("Mozilla")){
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(Constant.Application_URL);
            }
        }catch (Exception e){

        }
        return driver;
    }

    static {
        File f = new File(File_Name);
        properties = new Properties();
        FileInputStream in;
        try{
            in = new FileInputStream(f);
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String strKey){
        String strValue = null;
        try{
            File f = new File(File_Name);
            if(f.exists()){
                strValue=properties.getProperty(strKey);
            }else {
                System.out.println("File not found!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return strValue;
    }

    public static String getTestCaseName(String sTestCase) throws Exception{
        String value = sTestCase;
        try{
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        }catch (Exception e){
            throw (e);
        }
    }

}
