package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class CartPricePage {

    private WebDriver driver;

    public CartPricePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPriceTotal(String expectedTotal) {
        WebElement priceTotal = driver.findElement(By.className("summary_total_label"));
        Assert.assertEquals(priceTotal.getText(), expectedTotal);
    }

    public void finishCheckout() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }
}

