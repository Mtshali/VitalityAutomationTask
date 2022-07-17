package accelerators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static boolean bResult;
    public static String sBrowserName;
    public static String sBrowserVersion;
    public static String Tdata;

    public static WebDriver OpenBrowser(String sBrowser){

        try{
            if(sBrowserName.equalsIgnoreCase("Chrome")){
                ChromeOptions options = new ChromeOptions();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                sBrowserVersion = capabilities.getBrowserVersion();
                options.addArguments("--incognito");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                sBrowserVersion=(String) capabilities.getCapability("version");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
//                Log.info("Chrome driver initialezed");
            }else if (sBrowserName.equalsIgnoreCase("Firefox")){
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }else if (sBrowserName.equalsIgnoreCase("IE")){
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

}
