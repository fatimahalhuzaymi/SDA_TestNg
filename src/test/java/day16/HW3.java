package day16;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW3 extends TestBase {
    /*
    Test Case3: Parametrized Negative Test
Open page https://practicetestautomation.com/practice-test-login/
Try to login with correct user name and wrong password
And wrong user name and correct password
And wrong user name and wrong password
And empty user name correct password
Verify error message is displayed.
     */
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");

    @Test
    @Parameters({"username", "password"})

    public void test(String name, String passwordd) {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(passwordd);
        driver.findElement(submit).click();

        WebElement erro = driver.findElement(error);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(erro));
        Assert.assertTrue(erro.isDisplayed());
    }

}


