import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.*;

import java.net.MalformedURLException;
import java.net.URL;


public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        EdgeOptions chromeOptions = new EdgeOptions(); // Si on veut lancer sur chrome on utilise ChromeOptions;
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);

        // On doit remplacer ChromeDriver par Remote
        //driver = new ChromeDriver(); // Instantation pour ouvrir google


        driver.get("https://www.amazon.fr"); // Ouvrir la page google.com
        driver.manage().window().maximize(); // Maximiser la taille de l'écran

        // fermer cookies
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    // Page objet nous permet de réorganisé notre code afin de pouvoir faire plusieurs en changeant que la variable "productName"
    @Test
    public void laptopAddToCartPriceTest(){

        // Arrange
        String productName = "HP Chromebook x360 14a-ca0000sf"; // On définit la variable à recherche
        String expectedPrice = "369,00 €";

        // Act
        //// pageobjects.amazon.MainPage
        MainPage mainPage = new MainPage(driver); // On instancie ici la variable driver qui est la page d'amazon
        mainPage.searchProduct(productName); // Il recupére la productName et la recherche dans Amazon

        /// Seach
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openResult(0);

        /// Ajout Panier
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.noCoverage();

        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCart();

        CartPage cartPage = new CartPage(driver);
        String productPrice = cartPage.getProductPrice(0);
        String activeCartSubtotal = cartPage.getActiveCartSubtotal();
        String buyboxCartSubtotal = cartPage.getBuyboxCartSubtotal();

        // Assert
        /*Assert.assertEquals(productPrice, expectedPrice);
        Assert.assertEquals(activeCartSubtotal, expectedPrice);
        Assert.assertEquals(buyboxCartSubtotal, expectedPrice);*/


    }
    @Test
    public void machineRacletteTest(){

        // Arrange
        String productName = "Machine a raclette";

        // Act
        MainPage mainPage = new MainPage(driver); // On instancie ici la variable driver qui est la page d'amazon
        mainPage.searchProduct(productName); // Il recupére la productName et la recherche dans Amazon

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openResult(5);

        // Assert


    }
}
