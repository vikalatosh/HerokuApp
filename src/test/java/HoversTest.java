import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoversTest extends BaseTest {

    public String getTextByJavascript(final WebElement element) {
        String script = "var element = arguments[0];"
                + "return element.textContent;"
                ;
        return (String) ((JavascriptExecutor)driver).executeScript(script, element);
    }

    @Test
    public void checkingAllUsers() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//div[@class='figure'][1]/img"));
        WebElement name1 = driver.findElement(By.xpath("//div[@class='figure'][1]/img//following::h5"));
        String userName1 = getTextByJavascript(name1);
        assertEquals(userName1, "name: user1", "Invalid name user1");
        actions.moveToElement(user1)
                .moveToElement(driver.findElement(By.xpath("//div[@class='figure'][1]/img//following::a")))
                .click()
                .build()
                .perform();
        String message = driver.findElement(By.xpath("//h1")).getText();
        assertEquals(message, "Not Found", "Error 403");
        driver.navigate().back();
        WebElement user2 = driver.findElement(By.xpath("//div[@class='figure'][2]/img"));
        WebElement name2 = driver.findElement(By.xpath("//div[@class='figure'][2]/img//following::h5"));
        String userName2 = getTextByJavascript(name2);
        assertEquals(userName2, "name: user2", "Invalid name user2");
        actions.moveToElement(user2)
                .moveToElement(driver.findElement(By.xpath("//div[@class='figure'][2]/img//following::a")))
                .click()
                .build()
                .perform();
        message = driver.findElement(By.xpath("//h1")).getText();
        assertEquals(message, "Not Found", "Error 403");
        driver.navigate().back();
        WebElement user3 = driver.findElement(By.xpath("//div[@class='figure'][3]/img"));
        WebElement name3 = driver.findElement(By.xpath("//div[@class='figure'][3]/img//following::h5"));
        String userName3 = getTextByJavascript(name3);
        assertEquals(userName3, "name: user3", "Invalid name user3");
        actions.moveToElement(user3)
                .moveToElement(driver.findElement(By.xpath("//div[@class='figure'][3]/img//following::a")))
                .click()
                .build()
                .perform();
        message = driver.findElement(By.xpath("//h1")).getText();
        assertEquals(message, "Not Found", "Error 403");
    }
}
