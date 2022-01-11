package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IphonePage {
    WebDriver driver;

    int timeoutSidebar = 3;

    By selectIphon13pro = By.cssSelector(".chapternav-item-iphone-13-pro");
    //By selectBouttonBuy = By.cssSelector(".ac-ln-button");

    public IphonePage(WebDriver driver) {
        this.driver = driver;
    }



    public void openIphone13ProPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(selectIphon13pro));
        driver.findElement(selectIphon13pro).click();
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(selectBouttonBuy));*/
    }

}
