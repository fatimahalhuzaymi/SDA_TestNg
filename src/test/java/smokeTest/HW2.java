package smokeTest;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HW2 extends TestBase {
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");

    @Test
    public void test() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SoftAssert sa = new SoftAssert();


        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(username).sendKeys("incorrectUser");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(submit).click();

        WebElement ero = driver.findElement(error);
        wait.until(ExpectedConditions.visibilityOf(ero));
        sa.assertTrue(ero.isDisplayed());

        String errorMessageText = ero.getText();
        sa.assertTrue(errorMessageText.contains("Your username is invalid!"));
        sa.assertAll();

    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"nma", "T9875*"},
                {"adam", "Pfddb"},
                {"opje", "l9832"},
                {"elke", "pp321"},
                {"eewr", "m9123"},
        };
    }
}