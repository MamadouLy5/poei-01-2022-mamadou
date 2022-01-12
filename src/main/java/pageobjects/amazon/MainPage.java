package pageobjects.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    Logger log = LogManager.getLogger(MainPage.class);


    int timeOutSearch = 5; // temps d'attente
    By searchBarSelector = By.id("twotabsearchtextbox"); // Barre de recherche d'amazon
    By SearchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String productName){

        // Trouver l'élément et interagir avec lui
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER); // Trouver la barre de recherche ensuite saisir la valeur de recherche et lancer la recherche

        // Attendre que l'action soit fini
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSearch));
        wait.until(ExpectedConditions.elementToBeClickable(SearchResultSelector));

    }



}
