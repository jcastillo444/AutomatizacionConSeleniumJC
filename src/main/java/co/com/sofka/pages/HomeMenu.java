package co.com.sofka.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;

public class HomeMenu {

    WebDriver driver;

    public HomeMenu(WebDriver driver) {
        this.driver = driver;
    }

    @FindBys( @FindBy(className = "btn btn_primary btn_small btn_inventory"))

    List<WebElement> addProducts;

    @FindBy(id="checkout")
    WebElement btnCheck;

    @FindBy(className = "shopping_cart_link")
    WebElement addCart;

    public void check(){
        btnCheck.isDisplayed();
    }

    public void cart(){
        addCart.click();
    }

    public List<WebElement> addProducts(){
        return addProducts;
    }

}