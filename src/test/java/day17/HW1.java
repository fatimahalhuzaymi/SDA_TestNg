package day17;

import day15.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW1 extends TestBase {
  /*
    Open the site: http://opencart.abstracta.us/index.php?route=account/login
    Login with that credentials
    Email: clarusway@gmail.com
    Password: 123456789
    Using the Search function do it with Data Provider for Mac, iPad and Samsung.
     */

    By Email = By.name("email");
By Password = By.name("password");
By Login = By.className("btn btn-primary");
By searchh  =By.name("search");
    @Test(dataProvider = "search")
    public void test(String kword) {
    driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    driver.findElement(Email).sendKeys("clarusway@gmail.com");
    driver.findElement(Password).sendKeys("123456789");
    driver.findElement(Login).click();

        WebElement searchBox = driver.findElement(searchh);
        searchBox.sendKeys(kword, Keys.ENTER);

    }


    @DataProvider(name ="search")
    public Object[][] getData() {
        Object[][] data =
                {{"Mac"}, {"ipad"}, {"Samsung"}};
        return data;
    }
}