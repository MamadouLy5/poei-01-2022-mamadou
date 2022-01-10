import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.CartPage;
import pageobjects.amazon.MainPage;
import pageobjects.apple.*;
//import pageobjects.apple.*;


public class AppleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // Instantation pour ouvrir google
        driver.get("https://www.apple.com/fr/"); // Ouvrir la page google.com
        driver.manage().window().maximize(); // Maximiser la taille de l'écran

        // fermer cookies
        //driver.findElement(By.id("sp-cc-accept")).click();
    }

    /*@AfterMethod
    public void teardown() {
        driver.quit();
    }*/

    // Page objet nous permet de réorganisé notre code afin de pouvoir faire plusieurs en changeant que la variable "productName"

    @Test
    public void Iphone(){

        // Arrange
        String productName = "iPhone 13 Pro"; // On définit la variable à recherche
        String productPageTitle = "1 379,00";
        String productPrice = "1 379,00";
        String activeCartSubtotal = "1 379,00";
        String CartTotal = "1 379,00";

        MainPageApple mainPageApple = new MainPageApple(driver); // On instancie ici la variable driver qui est la page d'apple
        mainPageApple.openIphonePage();

        IphonePage iphonePage = new IphonePage(driver); // On instancie ici la variable driver qui est la page d'apple
        iphonePage.openIphone13ProPage();

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        iphone13ProPage.buy();

        BuyIphone13ProPage buyIphone13ProPage =new BuyIphone13ProPage(driver);
        buyIphone13ProPage.selectphone13ProMax();
        try {
            Thread.sleep(2000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buyIphone13ProPage.selectBlueAlpin();
        try {
            Thread.sleep(2000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buyIphone13ProPage.select256Go();
        try {
            Thread.sleep(2000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buyIphone13ProPage.noAppleTradeIn();
        try {
            Thread.sleep(2000); // Pour instancier un temps d'attente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buyIphone13ProPage.addToCart();

        ConfirmationAppleAddToCartPage confirmationAppleAddToCartPage = new ConfirmationAppleAddToCartPage(driver);
        confirmationAppleAddToCartPage.openCartPage();

        CartPageApple cartPageApple = new CartPageApple(driver);
        String productNameCompare = cartPageApple.getProductName(0);
        String productPageTitleCompare = cartPageApple.getCartTitle();
        String productPriceCompare = cartPageApple.getProductPrice(0);
        String activeCartSubtotalCompare = cartPageApple.getAppleSubTotal();
        String CartTotalCompare = cartPageApple.getAppleTotal();

        // Assert
        //Assert.assertEquals(productNameCompare, productName);
        /*Assert.assertTrue(productNameCompare.contains(productName), "The name of cart does not contain in th result");
        
        //Assert.assertEquals(productPageTitleCompare, productPageTitle);
        Assert.assertTrue(productPageTitleCompare.contains(productPageTitle), "The name of product does not contain in th result");
        */
        //Assert.assertEquals(productPriceCompare, productPrice);
        Assert.assertTrue(productPriceCompare.contains(productPrice), "The price of product does not contain in th result");

        //Assert.assertEquals(activeCartSubtotalCompare, activeCartSubtotal);
        Assert.assertTrue(activeCartSubtotalCompare.contains(activeCartSubtotal), "The price of subtotal does not contain in th result");

        //Assert.assertEquals(CartTotalCompare, CartTotal);
        Assert.assertTrue(CartTotalCompare.contains(CartTotal), "The price of cartTotal does not contain in th result");


    }
    @AfterMethod
    public void teardown(){
        driver.quit(); // fermer google
    }


}