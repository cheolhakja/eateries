package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://map.kakao.com/");
        Thread.sleep(1000);

        WebElement webElementKeyWord = driver.findElement(By.id("search.keyword.query"));
        webElementKeyWord.sendKeys("명동 순대국");
        WebElement webElementSubmit = driver.findElement(By.id("search.keyword.submit"));
        webElementSubmit.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement webElementStoreMore = driver.findElement(By.id("info.search.place.more"));
        webElementStoreMore.sendKeys(Keys.ENTER);

    }
}
