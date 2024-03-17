package day16;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HW1 extends TestBase {
    /*
 HW01:
Go to URL: https://www.google.com
Search words: Java, Selenium
Assert get text result est that the result text contains the searched Word.
Run tests from XML file.
  */
    By search= By.className("SDkEP");
    By Java = By.className("Java");

    By selenium= By.name("description");
    @Test
    @Parameters("word")
    public void test(String kword) {
        driver.get("https://www.google.com");
        WebElement ssearch = driver.findElement(search);
        ssearch.sendKeys(kword + Keys.ENTER);
        WebElement jjava = driver.findElement(Java);
        Assert.assertTrue(jjava.isDisplayed());

        WebElement sselenium = driver.findElement(selenium);
        Assert.assertTrue(sselenium.getText().contains("selenium"));
    }
}
