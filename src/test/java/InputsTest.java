import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputsTest extends BaseTest {

    @Test
    public void inputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("123");
        assertEquals(element.getAttribute("value"), "123", "Input invalid data");
        element.sendKeys(Keys.ARROW_UP);
        assertEquals(element.getAttribute("value"), "124", "Input invalid data");
        element.sendKeys(Keys.ARROW_DOWN);
        assertEquals(element.getAttribute("value"), "123", "Input invalid data");
    }
}
