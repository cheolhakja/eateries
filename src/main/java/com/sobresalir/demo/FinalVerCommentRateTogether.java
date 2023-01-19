package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FinalVerCommentRateTogether {
    public static List<RatingReviewData> scrap() throws InterruptedException {
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

        List<WebElement> ratingSorted =driver.findElements(By.xpath("//span[@class = 'ico_star star_rate']/span"));
        Thread.sleep(3000);
        List<WebElement> elementTextReview = driver.findElements(By.xpath("//ul[@class = 'list_evaluation']/li"));
        Thread.sleep(3000);

        List<String> answerForRatings = new ArrayList<>(); //맨날 ArrayList만 쓰나
        List<String> answerForReviews = new ArrayList<>();

        for (int i = 0 + 2; i < ratingSorted.size() - 1; i++) { //+2와 -1을 알아보기 쉽게 refactor하기
            String s1 = ratingSorted.get(i).getAttribute("style");
            Thread.sleep(1000);

            answerForRatings.add(s1);
            //Thread.sleep(1000);
        }

        for (int i = 0; i < elementTextReview.size(); i++) {
            String s2 = elementTextReview.get(i).getText();
            Thread.sleep(1000);

            answerForReviews.add(s2);
            //Thread.sleep(1000);
        }

        List<RatingReviewData> answer = new ArrayList<>();
        for (int i = 0; i < answerForReviews.size(); i++) {
            answer.add(new RatingReviewData(answerForRatings.get(i), answerForReviews.get(i)));
        }

        return answer;
    }
}
