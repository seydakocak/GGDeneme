package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


public class GGTest {

    public WebDriver driver;
    public WebDriverWait wait;
    protected static String url = "https://www.gittigidiyor.com/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\IdeaProjects\\untitled\\GGDeneme\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void correctOpen() {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
     /*  WebElement login =driver.findElement(By.className("gekhq4-5"));
       login.click(); */
        wait = new WebDriverWait(driver,2);


        WebElement searchData = driver.findElement(By.name("k"));
        searchData.sendKeys("bilgisayar");
        WebElement buttonSearch = driver.findElement(By.className("qjixn8-0"));
        buttonSearch.click();

        String actualtitle = driver.getTitle();
        String  expectedtitle = "Bilgisayar - GittiGidiyor";

        if(actualtitle.equalsIgnoreCase(expectedtitle))
        {
            System.out.println("arama-bilgisayar");
        }
        else
        {
            System.out.println("Test failed");
        }
         driver.findElement(By.id("product_id_658676255")).click();
        driver.findElement(By.className("basket-container")).click();
driver.findElement(By.className("btn-cart-login")).click();

       String actualUrl ="https://www.gittigidiyor.com/uye-girisi";
       String expectedUrl= driver.getCurrentUrl();
        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }

        WebElement username=driver.findElement(By.id("L-UserNameField"));
        WebElement password=driver.findElement(By.id("L-PasswordField"));
        WebElement login2=driver.findElement(By.id("gg-login-enter"));

        username.sendKeys("brainempty83@gmail.com");
        password.sendKeys("06150655seyda");
        login2.click();


        /*WebElement iFrame_checkbox = driver.findElement(By.className("recaptcha-checkbox-checkmark"));
        iFrame_checkbox.click(); */
       /*   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("recaptcha-checkbox-border"))).click();
        login2.click(); */

    }

    @After
    public void tearDown() { driver.quit();


    } }
