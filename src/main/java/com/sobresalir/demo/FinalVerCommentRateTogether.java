package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FinalVerCommentRateTogether {
    public static void main(String[] args) throws InterruptedException { //예외 throw는 아는데 throws는 뭐지? 메인에서 throws하면 어디로 가냐
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://place.map.kakao.com/2039472007");
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
        Thread.sleep(1000);

        /*System.out.println("ratingSorted.size() = " + ratingSorted.size());
        Thread.sleep(1000);*/


        /*for (int i = 0; i < 10; i++) {
            System.out.println("elements" + i + " = " +  ratingSorted.get(i).getAttribute("style"));
            Thread.sleep(1000);

        }*/

        List<String> answerForRatings = new ArrayList<>(); //맨날 ArrayList만 쓰나
        for (int i = 0 + 2; i < ratingSorted.size() - 1; i++) { //+2와 -1을 알아보기 쉽게 refactor하기

            answerForRatings.add(ratingSorted.get(i).getAttribute("style"));
            Thread.sleep(1000);

        } //진짜로 필요한 것

        //comment

        List<WebElement> elementTextReview = driver.findElements(By.xpath("//ul[@class = 'list_evaluation']/li"));

        Thread.sleep(1000);

        List<String> answerForReviews = new ArrayList<>();
        for (int i = 0; i < answerForReviews.size(); i++) {

            answerForReviews.add(elementTextReview.get(i).getText());
            Thread.sleep(1000);
        }

        //문자열 출력
        String text1 = elementTextReview.get(21).getText();
        String text2 = elementTextReview.get(22).getText();
        for (int i = 0; i < text1.length(); i++) {
            if(text1.charAt(i) == '\n') {
                System.out.print(i + " = " + text1.charAt(i));
            } else {
                System.out.println(i + " = " + text1.charAt(i));
            }
        }

        System.out.println();
        for (int i = 0; i < text2.length(); i++) {
            if(text2.charAt(i) == '\n') {
                System.out.print(i + " = " + text2.charAt(i));
            } else {
                System.out.println(i + " = " + text2.charAt(i));
            }
        }


        //문자열 분석
        int cnt = 0;
        int startIndex = 0;
        int lastIndex = text2.length();
        System.out.println("text2.length() = " + lastIndex);
        System.out.println("text2.charAt(lastIndex - 10) = " + text2.charAt(lastIndex - 10));
        //substring은 lastIndex - 10을 인수로 넣어야됨. 나를 믿어
        for (int i = 0; i < text2.length(); i++) {
            if(text2.charAt(i) == '\n') {
                cnt++;
                if(cnt == 6) {
                    startIndex = i;
                    break;
                }

            }
            
        }
        String substring = text2.substring(startIndex, lastIndex - 10);
        System.out.println("substring of text2 = " + substring);

        System.out.println();

        int cnt2 = 0;
        int startIndex2 = 0;
        int lastIndex2 = text1.length();
        System.out.println("text1.length() = " + lastIndex2);
        System.out.println("text1.charAt(lastIndex - 10) = " + text1.charAt(lastIndex2 - 10));
        //substring은 lastIndex - 10을 인수로 넣어야됨. 나를 믿어
        for (int i = 0; i < text1.length(); i++) {
            if(text1.charAt(i) == '\n') {
                cnt2++;
                if(cnt2 == 6) {
                    startIndex2 = i;
                    break;
                }

            }

        }
        String substring2 = text1.substring(startIndex2, lastIndex2 - 10);
        System.out.println("substring of text1 = " + substring2);
        //리스트에 추가 및 JSON직렬화
       /* List<RatingReviewData> list = new ArrayList<>();
        //elementTextReview ratingSorted
        for (int i = 0; i < elementTextReview.size(); i++) {

        }*/
        System.out.println(elementTextReview.get(22).getText());
    }

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
