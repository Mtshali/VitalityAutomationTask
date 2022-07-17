package pageObjects;

import org.openqa.selenium.By;

public class weatherResultObjects {

    public static final By typeToCity = By.xpath("//input[@id=\"ls-c-search__input-label\"]");
    public static final By clickSeearch = By.xpath("//input[@type=\"submit\"]");
    public static final By tomorrowsTemp = By.xpath("//li/a[@id=\"daylink-1\"]");

}
