package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FinalVerCommentRateTogether {
    public static void main(String[] args) throws InterruptedException { //예외 throw는 아는데 throws는 뭐지? 메인에서 throws하면 어디로 가냐
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://place.map.kakao.com/10346328");
        Thread.sleep(1000);

        while(true) {
            try {
                WebElement elementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
                elementReviewMore.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            } catch(org.openqa.selenium.NoSuchElementException e) {
                System.out.println("후기를 전부 펼쳤습니다");
                break;
            }
        }

        List<WebElement> starsSortedInOrder =driver.findElements(By.xpath("//span[@class = 'ico_star star_rate']/span"));
        Thread.sleep(1000);

        System.out.println("starsSortedInOrder.size() = " + starsSortedInOrder.size());
        Thread.sleep(1000);


        for (int i = 0; i < 10; i++) {
            System.out.println("elements" + i + " = " +  starsSortedInOrder.get(i).getAttribute("style"));
            Thread.sleep(1000);

        }

        for (int i = 0 + 2; i < 10 - 1; i++) { //+2와 -1을 알아보기 쉽게 refactor하기
            System.out.println("elements" + i + " = " +  starsSortedInOrder.get(i).getAttribute("style"));
            Thread.sleep(1000);

        }

        //comment

        List<WebElement> elementTextReview = driver.findElements(By.xpath("//ul[@class = 'list_evaluation']/li"));

        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            System.out.println("리뷰 = " + elementTextReview.get(i).getText());
            Thread.sleep(1000);

        }


    }
}
