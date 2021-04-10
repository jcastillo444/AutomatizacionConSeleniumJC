package co.com.sofka.stepdefinitions;

import co.com.sofka.controller.controller;
import co.com.sofka.pages.HomeMenu;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import static co.com.sofka.stepdefinitions.Hooks.driver;

public class StepAddProducts {


    @When("the desired products are selected that are added to the shopping cart")
    public void theDesiredProductsAreSelectedThatAreAddedToTheShoppingCart() {
        controller controller = PageFactory.initElements(driver,controller.class);
        controller.calculo();
    }
    @Then("Inside the shopping cart are the previously selected products")
    public void insideTheShoppingCartAreThePreviouslySelectedProducts() {
        HomeMenu homeMenu = PageFactory.initElements(driver,HomeMenu.class);
        homeMenu.cart();
        homeMenu.check();
    }
}
