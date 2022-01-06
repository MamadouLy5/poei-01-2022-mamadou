import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class uberEatsTests {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver(); // instantation pour ouvrir google
        // Temps d'attente de 2sec ici
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.ubereats.com/fr"); // ouvrir la page google.com
        driver.manage().window().maximize();// maximiser la taille de l'écran
        //Fermer le cookies
        WebElement buttonCookies = driver.findElement(By.cssSelector("#cookie-banner button.bj"));
        //button[class='b8 b9 ba bb bc bd eo ah bf bg b0 bh bi bj bk bl ep bn bo bx eq']
        buttonCookies.click();
    }
    /*@AfterMethod
    public void teardown(){
        driver.quit(); // fermer google
    }*/
    /// Saisir "La Defense" dans le champ text Adresse et simuler la touche "Enter"
    @Test
    public void addToBurgerToCard(){
        //// Arrange

        // Explicit wait méthode qu'il faut utiliser pour cliquer sur un onglet aprés un temps d'attente
        String keyword = "La defense";
        By searchBarSelector = By.cssSelector("#location-typeahead-home-input");
        //int timeoutSearchLoad = 10;
        By rechercheBurger = By.cssSelector("div[tabindex='0']");
        By restoSelector = By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
        By firstBurger = By.cssSelector("[alt='Le Marcel Jackson']");
        By addPanierBurger = By.cssSelector(".spacer._24 + button.b8");
        By panierBurger = By.cssSelector("button[aria-label='checkout'] > div");
        String nombreElementPanier = "1";

        //// Actions
        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys( keyword );
        try {
            Thread.sleep(3000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barreRecherche.sendKeys(Keys.ENTER);
        // Rechercher "Burgers dans la barre de recherche
        //Chronométre qui va attendre 10sec

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[tabindex='0']")));
        driver.findElement(rechercheBurger).click();


        /// 2.Ensuite cliquer le premier résultat du recherche

        wait.until(ExpectedConditions.elementToBeClickable(restoSelector));
        driver.findElement(restoSelector).click();
        /*try {
            Thread.sleep(5000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*WebElement selectBurgMarcel = driver.findElement(By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3"));

        selectBurgMarcel.click();*/

        /// Cliquer sur le premier burger

        wait.until(ExpectedConditions.elementToBeClickable(firstBurger));

        WebElement searchMarcelJacksonSelector = driver.findElement(firstBurger);

        searchMarcelJacksonSelector.click();

        // 3.Aprés cliquer sur le bouton ajouter au panier

        wait.until(ExpectedConditions.elementToBeClickable(addPanierBurger));

        WebElement ajoutPanier = driver.findElement(addPanierBurger);
        ajoutPanier.click();
        //driver.findElements(By.cssSelector(".b8.b9.ba.bb.bc.bd")).get(0).click();

        //// Assert
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addPanierBurger));

        WebElement cart = driver.findElement(panierBurger);

        Assert.assertTrue(cart.getText().contains(nombreElementPanier), "The cart does not contain 1 item");
    }
    @AfterMethod
    public void teardown(){
        driver.quit(); // fermer google
    }


}
