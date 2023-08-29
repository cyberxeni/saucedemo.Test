package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    public Object login;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void login (String username, String password){
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.clear();
        inputUserName.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
    }

    public void login (List<String> username, String password){
        for(int i =0; i <username.size(); i++){
            WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
            inputUserName.clear();
            inputUserName.sendKeys(username.get(i));

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.clear();
            inputPassword.sendKeys("password");

            WebElement buttonLogin = driver.findElement(By.id("login-button"));
            buttonLogin.click();
        }
    }



}
