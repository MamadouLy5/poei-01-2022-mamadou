package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    // On définit ici les variables : produits sélectionnés
    By productPriceSelector = By.cssSelector("span.sc-product-price");
    By activeCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-activecart > span");
    By buyboxCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-buybox > span");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    /// Creer les fonctions qui retournent quelques choses
    public  String getProductPrice(int index){ // Ici on regarde le prix de chaque produit dans le panier
        List<WebElement> listOfProductPrice = driver.findElements(productPriceSelector);
        return listOfProductPrice.get(index).getText();
    }

    public String getActiveCartSubtotal() {  // C'est le prix de tous les produits affichés en bas
        return driver.findElement(activeCartSubtotalSelector).getText();
    }

    public String getBuyboxCartSubtotal() {  // C'est le prix de tous les produits affichés en haut à droite
        return driver.findElement(buyboxCartSubtotalSelector).getText();
    }


}
