package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphone13ProPage {

    WebDriver driver;

    int timeoutSidebar = 10;

    By chooseIphon13proMax = By.cssSelector("[data-autom='dimensionScreensize6_7inch'] +label");
    By chooseBlueColor = By.cssSelector("[data-autom='dimensionColorsierrablue'] + label");
    By choose256go = By.cssSelector("[data-autom='dimensionCapacity256gb'] + label");
    By IphoneTrade = By.cssSelector("[data-autom='choose-noTradeIn'] + label");
    By addToCartApple13 = By.cssSelector("[data-autom='add-to-cart']");

    public BuyIphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectphone13ProMax() {
        driver.findElement(chooseIphon13proMax).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(chooseBlueColor));
    }

    public void selectBlueAlpin() {
        driver.findElement(chooseBlueColor).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(choose256go));
    }
    public void select256Go() {
        driver.findElement(choose256go).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(IphoneTrade));
    }
    public void noAppleTradeIn() {
        driver.findElement(IphoneTrade).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartApple13));
    }
    public void addToCart() {
        driver.findElement(addToCartApple13).click();

    }

}
