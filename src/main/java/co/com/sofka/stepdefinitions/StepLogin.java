package co.com.sofka.stepdefinitions;

import co.com.sofka.data.User;
import co.com.sofka.data.UserDTO;
import co.com.sofka.pages.AccountCreationPage;
import co.com.sofka.pages.HomeMenu;
import co.com.sofka.pages.MainLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static co.com.sofka.stepdefinitions.Hooks.driver;

public class StepLogin {

    Map<Integer, User> userMap = new UserDTO().getUsers();

    @Given("The page is accessed and the credentials are known")
    public void thePageIsAccessedAndTheCredentialsAreKnown() {
        String title = driver.getTitle();
        System.out.println("El titulo de la pagina es : " + title);
        Assertions.assertEquals("Swag Labs", title, "El titulo no es el mismo");
    }

    @When("the access data is entered and the enter button is pressed")
    public void theAccessDataIsEnteredAndTheEnterButtonIsPressed() {
        MainLogin mainLogin = PageFactory.initElements(driver, MainLogin.class);
        mainLogin.sendUserName(userMap.get(1).getUserName());
        mainLogin.sendPassword(userMap.get(1).getPassword());
        mainLogin.clickBtnSubmitCreate();
    }

    @Then("the main menu of the shopping page appears")
    public void theMainMenuOfTheShoppingPageAppears() {

        AccountCreationPage accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        final String EXPECTED_TEXT = "PRODUCTS";

        String currentText = accountCreationPage.getH1CreateAnAccountText();
        System.out.println("pruebaaaa"+currentText);
        Assertions.assertEquals(EXPECTED_TEXT, currentText);

    }






}
