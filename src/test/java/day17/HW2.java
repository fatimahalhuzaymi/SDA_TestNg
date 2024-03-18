package day17;

import day17.utilities.ParameterBrowserTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HW2 extends ParameterBrowserTestBase {
 /*
    Go to URL: https://vziad3.github.io/todo-app/todo-app.html
Checking Box todo-4 and Checking Box todo-5
If both clicks worked, then the following List should be have length 2.
Assert that this is correct
Assert that the todo we added is present in the list
Archiving old todos
If our archive link worked, then the following list should have length 4.
Assert that this is true as well
Doing Cross Browser Testing.
     */

    By todo = By.tagName("Todo App");

By checkbox= By.xpath("//*[@type='checkbox']");
By checkboxdone =By.name("todo-1");
By addbutton= By.id("addbutton");

@Test
    public void test() {
    driver.get("https://vziad3.github.io/todo-app/todo-app.html");

    List<WebElement> checkBox  = driver.findElements(checkboxdone);
    checkBox.get(3);
    checkBox.get(4);

    List<WebElement> checkboxxdone = driver.findElements(checkboxdone);
    Assert.assertEquals(checkboxxdone.size(),2);

    WebElement todoo = driver.findElement(todo);
    todoo.sendKeys("done");

    WebElement addbuttonn = driver.findElement(addbutton);
    addbuttonn.click();

    checkBox=driver.findElements(checkbox);
    Assert.assertEquals(checkBox.size(),7);
    Assert.assertTrue(checkBox.get(5).isDisplayed());


}

}
