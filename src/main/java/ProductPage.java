import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    int timeOutSidebar = 5;
    int timeOutConfirmation = 7;
    By addToCartButtonSelector = By.id("add-to-cart-button");
    By addCoverageButtonSelector = By.cssSelector("#attachSiAddCoverage input");
    By noToCartButtonSelector = By.cssSelector("#attachSiNoCoverage input");
    By confirmationImageSelector = By.id("add-to-cart-confirmation-image");


    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
// Retourne la meme page
    public void addToCart(){
        driver.findElement(addToCartButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(addCoverageButtonSelector));
    }

    public void noCoverage(){
        driver.findElement(noToCartButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutConfirmation));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationImageSelector));
    }

}
