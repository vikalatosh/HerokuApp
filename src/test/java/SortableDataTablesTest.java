import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void checkingTableValues() {
        driver.get("http://the-internet.herokuapp.com/tables");
        String firstValue = driver.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        assertEquals(firstValue, "jsmith@gmail.com", "Invalid value of Email");
        String secondValue = driver.findElement(By.xpath("//table//tr[4]//td[1]")).getText();
        assertEquals(secondValue, "Conway", "Invalid value of Last Name");
        String thirdValue = driver.findElement(By.xpath("//table//tr[4]//td[5]")).getText();
        assertEquals(thirdValue, "http://www.timconway.com", "Invalid value of Web Site");
        String fourthValue = driver.findElement(By.xpath("//table//tr[3]//td[4]")).getText();
        assertEquals(fourthValue, "$100.00", "Invalid value of Due");
        String fifthValue = driver.findElement(By.xpath("//tr[3]//td[@class='first-name']")).getText();
        assertEquals(fifthValue, "Jason", "Invalid value of First Name");
    }
}
