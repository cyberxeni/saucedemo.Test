package ProductTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;






    public class PriceTotal {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\yildiz\\Downloads\\chromedriver_win32\\chromedriver.exe");


            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            //dodavanje vise proizvoda u korpu
            String[] products = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Onesie"};
            //nisam znala drugacije postaviti for petlju
            for (String product : products)  {
                WebElement productLink = driver.findElement(By.linkText(product));
                productLink.click();
                WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));
                addToCartButton.click();
                WebElement backButton = driver.findElement(By.cssSelector(".inventory_details_back_button"));
                backButton.click();
            }
            // checkout informacije
            WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
            cartIcon.click();
            WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
            checkoutButton.click();
            driver.findElement(By.id("first-name")).sendKeys("ksenija");
            driver.findElement(By.id("last-name")).sendKeys("vasilijevic");
            driver.findElement(By.id("postal-code")).sendKeys("11000");
            //klik na continue dugme
            driver.findElement(By.id("continue")).click();

            // Verifikacija Price Total
            WebElement priceTotal = driver.findElement(By.className("summary_total_label"));
            String totalPrice = priceTotal.getText();
            System.out.println("Total Price: " + totalPrice);

        }
    }


