import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String p = driver.findElement(By.tagName("p")).getText();
        boolean typo = p.equals("Sometimes you'll see a typo, other times you won't.");
        if (typo) {
            assertEquals(p, "Sometimes you'll see a typo, other times you won't.", "you see a typo");
        } else{
            assertEquals(p, "This example demonstrates a typo being introduced. " +
                    "It does it randomly on each page load.", "you don't see a typo");
        }
    }
}
