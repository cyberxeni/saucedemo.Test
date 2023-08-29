package ProductTests;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.CartPage;
import pages.CartPricePage;

public class TotalPrice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yildiz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CartPricePage cartPricePage = new CartPricePage(driver);

        loginPage.login("standard_user", "secret_sauce");

        // Add products to the cart
        cartPage.addProductToCartByName("Sauce Labs Backpack");
        cartPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");

        // Open cart and proceed to checkout
        cartPage.openCart();
        cartPage.clickCheckoutButton();

        // Fill checkout information
        cartPage.fillCheckoutInformation("ksenija", "vasilijevic", "11000");
        cartPage.clickContinueButton();

        // Verify Price Total and finish checkout
        cartPricePage.verifyPriceTotal("$49.66");
        cartPricePage.finishCheckout();

        driver.quit();
    }
}

