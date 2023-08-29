package ProductTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CheckoutTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    private CartPage cartPage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yildiz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        cartPage = new CartPage(driver);

    }

    @Test
    public void testSuccessfulCheckout() {
        driver.get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");
        cartPage.addProductToCartByName("Sauce Labs Backpack");
        cartPage.openCart();

    }

    @Test(priority =1)
    public void positiveCheckoutTest() {
        driver.get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");
        cartPage.addProductToCartByName("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.clickCheckoutButton();


        cartPage.fillCheckoutInformation("ksenija","vasilijevic","11000");
        cartPage.clickContinueButton();
        // ovde mozemo dodati asertaciju za proveru sledece stranice nakon uspesnog checkout-a
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two.html"));
    }
    @Test(priority = 2)
    public void negativeCheckoutTest() {
        driver.get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");
        cartPage.addProductToCartByName("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.clickCheckoutButton();

        cartPage.fillCheckoutInformation("", "vasilijevic", "11000");
        cartPage.clickContinueButton();

        // Proveriti da li je prikazana poruka o grešci
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), "Error: First Name is required");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}