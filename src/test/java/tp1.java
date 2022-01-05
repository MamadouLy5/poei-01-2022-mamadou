import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tp1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver(); // instantation pour ouvrir google
        driver.get("https://www.amazon.fr"); // ouvrir la page google.com
        driver.manage().window().maximize();// maximiser la taille de l'écran
        //Fermer le cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }

    @Test
    public void test1(){

        try {
            Thread.sleep(1000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Sur la page d'amazon on teste les éléments de la page
        // "*[@id="twotabsearchtextbox"]" //pour copy xpath
        // "/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input" //pour copy fullxpath


        // autocomplétion "Ctrl+espace"



        // Rechercher dans la barre de recherche "machine a raclette"
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.cssSelector(""));
        //driver.findElement(By.xpath("//*@id='twotabsearchtextbox'"));
        //driver.findElement(By.xpath("//*@name='field-keywords'"));

        driver.quit(); // fermer amazon
    }
    @Test
    public void test2(){

        // Rechercher dans la barre de recherche "machine a raclette"
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //Temps d'attente pour charger la page
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cliquer premier resultat
        WebElement premierElement = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        premierElement.click();

        // Cliquer sur le bouton ajouter au panier
        //Fermer le cookies
        WebElement ajoutPanier = driver.findElement(By.id("add-to-cart-button"));
        ajoutPanier.click();

        driver.quit(); // fermer amazon

    }
}
