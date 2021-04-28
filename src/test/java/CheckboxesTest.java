import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTest {

    @Test
    public void checkingCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        //Checking first checkbox
        boolean check1 = checkboxes.get(0).isSelected();
        assertFalse(check1, "Checkbox checked");
        checkboxes.get(0).click();
        check1 = checkboxes.get(0).isSelected();
        assertTrue(check1, "Checkbox unchecked");
        //Checking second checkbox
        boolean check2 = checkboxes.get(1).isSelected();
        assertTrue(check2, "Checkbox checked");
        checkboxes.get(1).click();
        check2 = checkboxes.get(1).isSelected();
        assertFalse(check2, "Checkbox unchecked");
    }
}
