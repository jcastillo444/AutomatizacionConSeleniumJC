package co.com.sofka.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class MainLogin {

    WebDriver driver;

    public MainLogin(WebDriver driver) {
        this.driver = driver;
    }
    private File screenshotPath;
    private File finalPathOfScreenshot;

    @FindBy(id = "user-name")
    WebElement txtUserName;

    @FindBy(id = "password")
    WebElement txtUserPassword;

    @FindBy(id = "login-button")
    WebElement btnSubmitCreate;

    public void sendUserName (String userName) {
        txtUserName.sendKeys(userName);
        screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        finalPathOfScreenshot = new File("src/main/resources/screenshots/MainLogin/fillOutTxtEmailCreate.png");

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
    }

    public void sendPassword(String password) {
        txtUserPassword.sendKeys(password);
    }

    public void clickBtnSubmitCreate() {
        btnSubmitCreate.click();
        screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        finalPathOfScreenshot = new File("src/main/resources/screenshots/MainLogin/clickBtnSubmitCreate.png");

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
    }
}
