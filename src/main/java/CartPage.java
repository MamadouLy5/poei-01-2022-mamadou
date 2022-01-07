import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    By productPriceSelector = By.cssSelector("span.sc-product-price");
    By activeCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-activecart > span");
    By buyboxCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-buybox > span");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    /// Creer les fonctions qui retournent quelques choses
    public  String getProductPrice(int index){
        List<WebElement> listOfProductPrice = driver.findElements(productPriceSelector);
        return listOfProductPrice.get(index).getText();
    }

    public String getActiveCartSubtotal() {
        return driver.findElement(activeCartSubtotalSelector).getText();
    }

    public String getBuyboxCartSubtotal() {
        return driver.findElement(buyboxCartSubtotalSelector).getText();
    }


}
