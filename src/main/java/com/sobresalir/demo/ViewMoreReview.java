package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class ViewMoreReview {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://place.map.kakao.com/14525727");
        Thread.sleep(1000);

        WebElement webElementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
        webElementReviewMore.sendKeys(Keys.ENTER);
    }
}
