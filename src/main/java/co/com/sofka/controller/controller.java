package co.com.sofka.controller;

import co.com.sofka.pages.HomeMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class controller {

    private WebDriver driver;
    List<Integer> addList = new ArrayList<Integer>();

    public void calculo (){

        HomeMenu homeMenu = PageFactory.initElements(driver,HomeMenu.class);

        int n=0;
        List<Integer> numeros = new ArrayList<Integer>();
        for (int j = 1; j <= 6; j++)
            numeros.add(j);

        System.out.println(numeros);

        int numArticulos = (int) (Math.random() * 6);
        System.out.println("El numero de articulos a aderir al carro es: " + (numArticulos+1));
        addList.add((0), (numArticulos+1));
        for (int i = 0; i <= numArticulos; i++) {
            int numAleatorio = (int) (Math.random() * (5-n));
            System.out.println("El numero aleatorio del producto "+(i+1)+" obtenido es: " + numAleatorio);
            int num=numeros.get(numAleatorio);
            numeros.remove(numAleatorio);
            n=(n+1);
            System.out.println("estado del random: "+(5-n));
            addList.add((i+1), (num));
            System.out.println("lo que le llega al switch: "+num);


            switch (num) {
                case 0:
                    homeMenu.addProducts().get(0).click();break;
                case 1:
                    homeMenu.addProducts().get(1).click();break;
                case 2:
                    homeMenu.addProducts().get(2).click();break;
                case 3:
                    homeMenu.addProducts().get(3).click();break;
                case 4:
                    homeMenu.addProducts().get(4).click();break;
                default :
                    homeMenu.addProducts().get(5).click();break;
        }
            /*switch (num) {
                case 0: //WebElement addCartItem0 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")));
                    //addCartItem0.click();break;
                case 1: WebElement addCartItem1 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")));
                    addCartItem1.click();break;
                case 2: WebElement addCartItem2 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']")));
                    addCartItem2.click();break;
                case 3: WebElement addCartItem3 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")));
                    addCartItem3.click();break;
                case 4: WebElement addCartItem4 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")));
                    addCartItem4.click();break;
                case 5: WebElement addCartItem5 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")));
                    addCartItem5.click();break;
                default :
                    homeMenu.addProducts().get(5).click();break;
            }*/
    }
        System.out.println("Los campos de array son: "+ addList);
}
}