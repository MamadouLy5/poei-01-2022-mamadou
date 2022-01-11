package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageApple {
    WebDriver driver;
    int timeOutSearch = 5; // temps d'attente
    By choiceIphone = By.cssSelector(".ac-gn-iphone");


    public MainPageApple(WebDriver driver){
        this.driver = driver;
    }

    public void openIphonePage(){
        driver.findElement(choiceIphone).click();


    }

}
