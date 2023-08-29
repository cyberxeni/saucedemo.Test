package loginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class VerifayLoginWithStandardUser {
    public static void main (String[]args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yildiz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

    }

}
