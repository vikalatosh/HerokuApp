import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> elements = select.getOptions();
        for (int i = 0; i < elements.size(); i++) {
            String[] DropDown = {"Please select an option", "Option 1", "Option 2"};
            boolean check = (elements.get(i).getText()).equals(DropDown[i]);
            assertTrue(check, "Option is not found");
        }
        select.selectByVisibleText("Option 1");
        String option1 = select.getFirstSelectedOption().getText();
        assertEquals(option1, "Option 1", "Option 1 не выбрана");
        select.selectByVisibleText("Option 2");
        String option2 = select.getFirstSelectedOption().getText();
        assertEquals(option2, "Option 2", "Option 2 не выбрана");
    }
}
