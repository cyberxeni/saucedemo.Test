package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    public void addProductToCartByName(String productName) {


        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        for (int i = 0; i < products.size(); i++) {
            WebElement productTitle = products.get(i).findElement(By.className("inventory_item_name"));

            if (productTitle.getText().equals(productName)) {
                WebElement addToCartButton = products.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;

            }

        }
    }

    public void openCart() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_container"));
        cartIcon.click();
    }


    public void verifyProductDetails(String productName, String price, String description) {


        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

        for (int i = 0; i < cartItems.size(); i++) {
            WebElement cartItem = cartItems.get(i);
            WebElement itemTitle = cartItem.findElement(By.className("inventory_item_name"));
            if (itemTitle.getText().equals(productName)) {
                WebElement cartItemPrice = cartItem.findElement(By.className("inventory_item_price"));
                WebElement cartItemDescription = cartItem.findElement(By.className("inventory_item_desc"));

                Assert.assertEquals(cartItemPrice.getText(), price);
                Assert.assertEquals(cartItemDescription.getText(), description);

                break;

            }
        }
    }


    public void clickCheckoutButton() {

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }
}
























