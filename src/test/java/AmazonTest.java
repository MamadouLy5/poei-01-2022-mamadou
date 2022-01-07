import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // Instantation pour ouvrir google
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
        String productName = "ordinateur portable"; // On définit la variable à recherche

        // Act
        //// MainPage
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

        // Assert

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
