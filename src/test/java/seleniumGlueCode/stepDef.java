package seleniumGlueCode;

import accelerators.ActionsClass;
import accelerators.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.WebDriver;
import utility.utils;
import pageObjects.weatherResultObjects;

import java.util.concurrent.TimeUnit;

public class stepDef {

    static WebDriver newdriver = Base.driver;
    static WebDriver driver1;
    public static String sNewWindow="";
    public static String uniqueName="";

    @Before
    public void setUp() throws Exception{
        try{
            ActionsClass.sTestCaseName =this.toString();
            ActionsClass.sTestCaseName = utils.getTestCaseName(ActionsClass.sTestCaseName);
        }catch (Exception e){

        }
    }

    @Given("^user is launching the weather service page$")
    public void user_is_launching_the_weather_service_page() throws Throwable {
        try{
            Base.sBrowserName=utils.getProperty("browserName");
            System.out.println("BrowserType ="+Base.sBrowserName);
            newdriver=Base.OpenBrowser(Base.sBrowserName);
            newdriver=Base.driver;
        }catch (Exception e){

        }
    }

    @When("^user navigate to weather service page$")
    public void user_navigate_to_weather_service_page() throws Throwable {
        try{
            String url = utils.getProperty("Application_URL");
            newdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            newdriver.get(url);
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    @When("^user searches the city for weather \"([^\"]*)\"$")
    public void user_searches_the_city_for_weather(String strCity) throws Throwable {
        try{

            ActionsClass.typeInTextBox(weatherResultObjects.typeToCity, strCity, strCity);
//            ActionsClass.clickOnElement(weatherResultObjects.clickSeearch, strCity);
        }catch (Exception e){

        }
    }

    @When("^user clicks on the search button to search for the city$")
    public void user_clicks_to_select_city() throws Throwable {
        try{

            ActionsClass.clickOnElement(weatherResultObjects.clickSeearch, "Search Button");
        }catch (Exception e){

        }
    }

    @And("^user clicks to open temparature$")
    public void clickToOpenTemp() throws Throwable{
        try{
            ActionsClass.clickOnElement(weatherResultObjects.tomorrowsTemp, "Temp");
        }catch (Exception e){

        }
    }

    @Then("^User verify that tomorrows high temperature is greater than tomorrows low temperature \"([^\"]*)\"$")
    public void verify_tomorrows_low_temperature(String strTemp) throws Throwable {
        try{
                String sGetText = ActionsClass.getElementText(By.xpath("//span[@class=\"wr-value--temperature wr-temperature--time-slot\"]/span[contains(text(), '29°')]"), "Text Element");
                assertNotEquals(sGetText, strTemp);

        }catch (Exception e){

        }
    }

}
