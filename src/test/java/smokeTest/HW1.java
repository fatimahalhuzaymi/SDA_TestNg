package smokeTest;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW1 extends TestBase {
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By message = By.xpath("//*[contains(text(),'Congratulations')]");
    By logout = By.linkText("Log out");

    @Test
    public void test() {


        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(username).sendKeys("student");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(submit).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));
        String msucc = driver.findElement(message).getText();
        Assert.assertTrue(msucc.contains("successfully logged in"));
        WebElement lout = driver.findElement(logout);
        Assert.assertTrue(lout.isDisplayed());
    }
}