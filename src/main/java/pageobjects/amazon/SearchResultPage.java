package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;

    By SearchResultSelector = By.cssSelector("[data-component-type='s-search-result']"); // Selector qui donne les résultats de recherche du produit

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    // Ouvrir un produit de la page de résultat de recherche
    public void openResult(int index){
        List<WebElement> listOfResults = driver.findElements(SearchResultSelector); // Liste de tous les résultats recherchés
        listOfResults.get(index).click(); // Prendre un index qui donne un produit
    }
}
