import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest{

    @Test
    public void openIFrame() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.cssSelector("[href*='iframe']")).click();
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        String iFrameText = driver.findElement(By.id("tinymce")).getText();
        assertEquals(iFrameText, "Your content goes here.", "");
    }
}
