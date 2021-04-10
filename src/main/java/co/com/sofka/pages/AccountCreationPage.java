package co.com.sofka.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.time.Duration;

public class AccountCreationPage {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    WebElement h1CreateAnAccount;

    public String getH1CreateAnAccountText() {

        File screenshotPath;
        File finalPathOfScreenshot;

        h1CreateAnAccount = wait.until(webDriver -> driver.findElement(By.xpath("//*[@class=\"title\"]")));

        screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        finalPathOfScreenshot = new File("src/main/resources/screenshots/account_creation_page/" +
                "getH1CreateAnAccountText.png");

        try {
            FileUtils.moveFile(screenshotPath, finalPathOfScreenshot);
        } catch (IOException exception) {
            try {
                Files.delete(FileSystems.getDefault().getPath(finalPathOfScreenshot.getPath()));
                FileUtils.moveFile(screenshotPath, finalPathOfScreenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return h1CreateAnAccount.getText();
    }
}
