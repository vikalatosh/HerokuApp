import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementTest extends BaseTest {

    @Test
    public void elementCanBeAddedAndRemoved() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtons.size(), 2, "Количество кнопок на странице не совпадает");
        deleteButtons.get(1).click();
        deleteButtons = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtons.size(), 1, "Количество кнопок на странице не совпадает");
    }
}
