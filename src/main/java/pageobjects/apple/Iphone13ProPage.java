package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iphone13ProPage {
    WebDriver driver;

    //int timeoutSidebar = 3;

    By selectBouttonBuy = By.cssSelector(".ac-ln-button");

    public Iphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }

    public void buy() {
        driver.findElement(selectBouttonBuy).click();
    }
}
