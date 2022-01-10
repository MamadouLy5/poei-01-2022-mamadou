package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAppleAddToCartPage {
    WebDriver driver;

    //By nameProductPresent = By.cssSelector(".rf-summary-header-producttitle[data-autom='summaryHeaderTitle']");
    By viewCartApple = By.cssSelector(".button-super[data-autom='proceed']");
    //.button-super[data-autom="proceed"]

    public ConfirmationAppleAddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCartPage() {
        driver.findElement(viewCartApple).click();

    }
}
