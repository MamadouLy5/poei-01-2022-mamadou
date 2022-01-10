package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPageApple {

    WebDriver driver;

    By productName = By.cssSelector("[data-autom='bag-item-name']");
    By titleCart = By.cssSelector("[data-autom='bag-header']");
    By productPriceSelector = By.cssSelector("div.rs-iteminfo-price");
    By activeCartSubtotalSelector = By.cssSelector(".rs-summary-value[data-autom='bagrs-summary-subtotalvalue']");
    By buyboxCartSubtotalSelector = By.cssSelector(".rs-summary-value[data-autom='bagtotalvalue']");

    public CartPageApple(WebDriver driver) {
        this.driver = driver;
    }


    public String getProductName(int index) {

        List<WebElement> listOfProductName = driver.findElements(productName);
        return listOfProductName.get(index).getText();
    }

    public String getCartTitle() {
        WebElement cartTitleResult = driver.findElement(titleCart);
        return cartTitleResult.getText();
    }

    public String getProductPrice(int index) {
        List<WebElement> listOfProductPrice = driver.findElements(productPriceSelector);
        return listOfProductPrice.get(index).getText();
    }

    public String getAppleSubTotal() {
        return driver.findElement(activeCartSubtotalSelector).getText();
    }

    public String getAppleTotal() {
        return driver.findElement(buyboxCartSubtotalSelector).getText();
    }

}
