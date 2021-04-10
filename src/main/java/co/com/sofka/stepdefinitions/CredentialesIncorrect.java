package co.com.sofka.stepdefinitions;

import co.com.sofka.pages.MainLogin;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.sofka.stepdefinitions.Hooks.driver;

public class CredentialesIncorrect {
    @Given("Login required")
    public void loginRequired() {
        String title = driver.getTitle();
        System.out.println("El titulo de la pagina es : " + title);
        Assertions.assertEquals("Swag Labs", title, "El titulo no es el mismo");

    }

    @When("Wrong username and password were entered")
    public void wrongUsernameAndPasswordWereEntered() {
        Faker faker = new Faker();

        MainLogin MainLogin = PageFactory.initElements(driver, MainLogin.class);
        MainLogin.sendUserName(faker.name().firstName());
        MainLogin.sendPassword(faker.name().lastName());
        MainLogin.clickBtnSubmitCreate();
    }

    @Then("An invalid username and password message is displayed.")
    public void anInvalidUsernameAndPasswordMessageIsDisplayed() {
        WebElement elementName = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'')]")));
        String textName = elementName.getText();
        System.out.println("El mensaje obtenido es: " + textName);
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", textName, "El mensaje entregado no es el mismo");
    }
}
