package day15;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



    public class HW1 extends TestBase {
        /*
 Test Case1: Positive Login Test

 Open page https://practicetestautomation.com/practice-test-login/

 Type username student into Username field
 Type password Password123 into Password field
 Click Submit button.
 Verify new page URL contains practicetestautomation.com/logged-in-successfully/
 Verify new page contains expected text ('Congratulations' or 'successfully logged in')
 Verify button Log out is displayed on the new page.
      */
        By username = By.id("username");
        By password = By.id("password");
        By submit = By.id("submit");
        By message = By.xpath("//*[contains(text(),'Congratulations')]");
        By logout = By.linkText("Log out");

        @Test
        public void harsAssertion() {



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

        @Test
        public void softAssertion() {

            driver.get("https://practicetestautomation.com/practice-test-login/");
            SoftAssert sa = new SoftAssert();

            driver.findElement(username).sendKeys("student");
            driver.findElement(password).sendKeys("Password123");
            driver.findElement(submit).click();

            String url = driver.getCurrentUrl();
            sa.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));
            String msucc = driver.findElement(message).getText();
            sa.assertTrue(msucc.contains("successfully logged in"));
            WebElement lout = driver.findElement(logout);
            sa.assertTrue(lout.isDisplayed());
            sa.assertAll();
        }
    }
