import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://www.thinkbroadband.com/download");
        WebElement file;
        file = driver.findElement(By.xpath("//div[text()='Extra Small File (5MB)']//following::p/a[text()='80']"));
        file.click();
        driver.navigate().refresh();
        file = driver.findElement(By.xpath("//div[text()='Extra Small File (5MB)']//following::p/a[text()='80']"));
        file.click();
        Thread.sleep(15000);
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("5MB.zip" )) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}
