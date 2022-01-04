import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tp1 {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver(); // instantation pour ouvrir google
        driver.get("https://www.amazon.fr"); // ouvrir la page google.com
        /*try {
            Thread.sleep(1000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        driver.manage().window().maximize();// maximiser la taille de l'écran

        // Sur la page d'amazon on teste les éléments de la page
        // "*[@id="twotabsearchtextbox"]" //pour copy xpath
        // "/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input" //pour copy fullxpath


        // autocomplétion "Ctrl+espace"

        //Fermer le cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

        // Rechercher dans la barre de recherche "machine a raclette"
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.cssSelector(""));
        //driver.findElement(By.xpath("//*@id='twotabsearchtextbox'"));
        //driver.findElement(By.xpath("//*@name='field-keywords'"));

        //driver.quit(); // fermer google
    }
    @Test
    public void test2(){

    }
}
