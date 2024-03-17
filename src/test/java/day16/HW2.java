package day16;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HW2 extends TestBase {

    /*
    Test Case2: Parametrizes Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
You should execute this test with xml file
     */
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");

    @Test
    @Parameters({"username","password"})
    public void test(String name, String passwordd){
        driver.get("https://practicetestautomation.com/practice-test-login/");


        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(passwordd);
        driver.findElement(submit).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));




    }
}
