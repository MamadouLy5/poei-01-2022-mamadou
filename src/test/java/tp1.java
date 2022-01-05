import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver(); // instantation pour ouvrir google
        // Temps d'attente de 2sec ici
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.amazon.fr"); // ouvrir la page google.com
        driver.manage().window().maximize();// maximiser la taille de l'écran
        //Fermer le cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit(); // fermer amazon
    }

    @Test
    public void test1(){

        /*try {
            Thread.sleep(1000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // autocomplétion "Ctrl+espace"

        // Rechercher dans la barre de recherche "machine a raclette"
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.cssSelector(""));
        //driver.findElement(By.xpath("//*@id='twotabsearchtextbox'"));
        //driver.findElement(By.xpath("//*@name='field-keywords'"));

    }
    @Test
    public void test2(){

        // Rechercher dans la barre de recherche "machine a raclette"
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //Temps d'attente pour charger la page et ne l'utiliser que localement pas sur github
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //

        // Cliquer premier resultat
        WebElement premierElement = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        premierElement.click();
        // Cliquer sur le bouton ajouter au panier
        //Fermer le cookies
        WebElement ajoutPanier = driver.findElement(By.id("add-to-cart-button"));
        ajoutPanier.click();
          

    }
    @Test
    public void testLivres(){
        driver.findElement(By.id("nav-hamburger-menu")).click();
        //Chronométre qui va attendre 10sec
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Explicit wait méthode qu'il faut utiliser pour cliquer sur un onglet aprés un temps d'attente
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hmenu-item[data-menu-id='10']")));
        driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='10']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hmenu-item[data-menu-id='10']")));
        driver.findElement(By.cssSelector("ul.hmenu-visible > li:nth-child(3)")).click();
        /*try {
            Thread.sleep(3000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
