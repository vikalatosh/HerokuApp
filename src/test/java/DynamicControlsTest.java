import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        boolean isDisplayed = checkbox.isDisplayed();
        assertTrue(isDisplayed, "Checkbox is not found");
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        WebElement checkboxMessage = driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.visibilityOf(checkboxMessage));
        assertEquals(checkboxMessage.getText(), "It's gone!", "Invalid message after removing Checkbox");
        try {
            isDisplayed = checkbox.isDisplayed();
        } catch (StaleElementReferenceException exception) {
            isDisplayed = false;
        }
        assertFalse(isDisplayed, "Checkbox is displayed");
        WebElement elementInput = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        boolean isDisabled;
        try {
            elementInput.getAttribute("disabled");
            isDisabled = true;
        } catch (StaleElementReferenceException exception) {
            isDisabled = false;
        }
        assertTrue(isDisabled, "Input is not disabled");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        WebElement inputMessage = driver.findElement(By.xpath("//*[@id='input-example']/p"));
        wait.until(ExpectedConditions.visibilityOf(inputMessage));
        assertEquals(inputMessage.getText(), "It's enabled!", "Invalid message after enabling Input");
        try {
            elementInput.sendKeys("123456789");
            isDisabled = false;
        } catch (StaleElementReferenceException exception) {
            isDisabled = true;
        }
        assertFalse(isDisabled, "Input is disabled");
    }
}
