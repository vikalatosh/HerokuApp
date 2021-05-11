import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void notificationMessages() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//*[@id='content']//descendant::a")).click();
        String[] notifications = {"Action successful", "Action unsuccessful, please try again"};
        String message = driver.findElement(By.id("flash")).getText();
        boolean checkout = false;
        for (String s : notifications) {
            if (message.contains(s)) {
                checkout = true;
            }
        }
        assertTrue(checkout, "Invalid notification message");
    }
}
