package accelerators;

import org.junit.Assert;
import org.openqa.selenium.By;
import utility.utils;

import javax.swing.*;

public class ActionsClass  extends Base{

    public static String browserName;
    public static boolean bResult;
    public static int Wait_Fast;
    public static Action builder;
    public static String sTestCaseName;
    public static final String TestDataPath = System.getProperty("user.dir")+ utils.getProperty("testdatapath");

//       Function to launch a browser
    public static void launchAnApplication(String url){
        try{
            driver.get(url);
        }catch (Exception e){

        }
    }

    //    Function to click an element
    public static boolean clickOnElement(By object, String elementName){
        boolean bFlag = false;
        try{
            if (driver.findElement(object).isDisplayed()){
                driver.findElement(object).click();
            }else  {
                Assert.fail("Failed to click on" + elementName);
            }
        }catch (Exception e){
            Assert.fail("Failed to click on" + elementName);
        }
        return bFlag;
    }


    //    Function to type in the text box
    public static void typeInTextBox(By object, String data, String elementName){
        try{
            if(driver.findElement(object).isDisplayed()){
                driver.findElement(object).clear();
                driver.findElement(object).sendKeys(data);
            }else {
                Assert.fail("Failed to enter data in");
            }
        }catch (Exception e){
            Assert.fail("Failed to enter data in");
        }
    }

    //    Function to verify that the element is displayed
    public static boolean isElementVisible(By object, String elementName) throws Throwable{
        boolean bFlag = false;
        try{
            if(driver.findElement(object).isDisplayed()){
                bFlag = true;
            }else {
                Assert.fail("Failed, element is not visible on screen");
            }
        }catch (Exception e){
            Assert.fail("Failed, element is not visible on screen");
        }
        return bFlag;
    }

    // Function to get Text
    public static String getElementText(By object, String elementName) {
        String sText = "";
        try{
            if(driver.findElement(object).isDisplayed()){
                sText=driver.findElement(object).getText();
            }else {
                Assert.fail("Failed to get text");
            }
        }catch (Exception e){

        }
        return sText;
    }

}
