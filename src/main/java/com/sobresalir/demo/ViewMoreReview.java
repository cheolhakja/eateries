package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ViewMoreReview {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://place.map.kakao.com/14525727");
        Thread.sleep(1000);

        WebElement webElementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
        webElementReviewMore.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> reviewsBefore = driver.findElements(By.xpath("//div[@class='comment_info']/p[@class='txt_comment']/span"));
        List<WebElement> reviewsAfter = driver.findElements(By.xpath("//div[@class='comment_info']/p[@class='txt_comment txt_fold']/span"));

        System.out.println("reviewsBefore.size() = " + reviewsBefore.size()); //리뷰들
        System.out.println("reviewsAfter.size() = " + reviewsAfter.size()); //마지막 리뷰
        Thread.sleep(1000);

        //리뷰를 출력해본다
        for (int j = 0; j < reviewsBefore.size(); j++) {
            System.out.println(reviewsBefore.get(j).getText());
            Thread.sleep(1000);
            System.out.println();
        }

        Thread.sleep(1000);
        for (int j = 0; j < reviewsAfter.size(); j++) {
            System.out.println(reviewsAfter.get(j).getText());
            Thread.sleep(1000);
            System.out.println();
        }

        //주의: 수많은 .JSON파일을 생성할 수 있으므로 딱 한번만 실행하도록 한다.
        //이미 있으면 덮어 쓰는게 어떻겠나?

        Thread.sleep(1000);
        JSONSerialization.serialize(reviewsBefore);

    }
}
