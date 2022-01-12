import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AmazonTest {

    WebDriver driver;
    Logger log = LogManager.getLogger(AmazonTest.class);

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

        //log.info("Mamadou was here");
        //log.trace("Trace");
        log.debug("Chrome has started");
        //log.fatal("Fatal");
        //log.error("Error");
        //log.warn("Warning");

        //Fatal > Error > Warn > Info > Debug > Trace


        driver.get("https://www.amazon.fr"); // Ouvrir la page google.com
        log.info("Amazon home page are opened");
        driver.manage().window().maximize(); // Maximiser la taille de l'écran
        log.trace("The window is maximised");

        // fermer cookies
        driver.findElement(By.id("sp-cc-accept")).click();
        log.info("Closed cookies window");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        log.debug("Chrome has closed");
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
    @Test
    public void hoverTest(){
        By buttonSelector = By.id("nav-link-accountList");
        By myAccountLinkSelector = By.cssSelector("#nav-al-your-account .nav-title + a");
        
        WebElement button = driver.findElement(buttonSelector);
        log.debug("The button was found");

        Actions hover = new Actions(driver);
        hover.moveToElement(button);
        hover.perform(); // execute l'action de déplacement de la souris
        log.info("Mouse hover button");

        // try-catch : gestion de exeptions
        /*try {
            Thread.sleep(4000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        /// bloquer la page pour trouver le selector qui se trouve sur un survol : inspecter l'élément + ensuite mettre en pause avec F8 +
        // revenir sur la partie survol + cliquer sur le carrée avec une fléche
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement myAccountButton = wait.until(ExpectedConditions.elementToBeClickable(myAccountLinkSelector));
        log.info("The account button was found");
        myAccountButton.click();
        log.info("The account button was clicked");


        //driver.findElement((myAccountLinkSelector)).click();
        try {
            Thread.sleep(4000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
