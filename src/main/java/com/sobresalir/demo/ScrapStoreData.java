package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;


public class ScrapStoreData {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://map.kakao.com/");
        Thread.sleep(1000);

        WebElement webElementKeyWord = driver.findElement(By.id("search.keyword.query"));
        webElementKeyWord.sendKeys("명동 칼국수");
        WebElement webElementSubmit = driver.findElement(By.id("search.keyword.submit"));
        webElementSubmit.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement webElementNumberOfStores = driver.findElement(By.xpath("//em[@id = 'info.search.place.cnt']"));
        int numberOfStores = 0;
        try{
            numberOfStores = Integer.parseInt(webElementNumberOfStores.getText());
        }
        catch (NumberFormatException ex){
            System.out.println("텍스트를 정수로 변환 불가");
            //업체수가 0이거나 잘못된 검색어를 입력해서 태그를 못찾는 경우
        }


        List<WebElement> sortMethods = driver.findElements(By.xpath("//ol[@id = 'info.search.place.sort']/li/a"));
        System.out.println("sortMethods.size() = " + sortMethods.size());
        sortMethods.get(1).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //----------

        if(numberOfStores <= 15) {
            //한 페이지에 모든 정보가 다 들어있는 경우
            List<WebElement> elementsViewMore = driver.findElements(By.xpath("//ul[@class='placelist']/li[@class = 'PlaceItem clickArea']/div[@class = 'info_item']/div[@class = 'contact clickArea']/a[@data-id = 'moreview']"));
            System.out.println("elementsViewMore.size() = " + elementsViewMore.size());
        } else {
            //WebElement webElementStoreMore = driver.findElement(By.id("info.search.place.more"));
            //webElementStoreMore.sendKeys(Keys.ENTER);
            //Thread.sleep(1000);

            //driver.findElement(By.xpath("//div[@class= 'pageWrap']/a[@id='info.search.page.no1']")).sendKeys(Keys.ENTER);
            //Thread.sleep(1000);

            List<WebElement> viewMoreAboutStore = driver.findElements(By.xpath("//ul[@id = 'info.search.place.list']/li[@class = 'PlaceItem clickArea']/div[@class = 'info_item']/div[@class = 'contact clickArea']/a[@class = 'moreview']"));
            Thread.sleep(1000);

            System.out.println("viewMoreAboutStore = " + viewMoreAboutStore.size());

            //numberOfStores에 따른 페이지 넘기기 횟수 조절
            Thread.sleep(1000);

            viewMoreAboutStore.get(0).sendKeys(Keys.ENTER);
            viewMoreAboutStore.get(1).sendKeys(Keys.ENTER);
            viewMoreAboutStore.get(2).sendKeys(Keys.ENTER);
            viewMoreAboutStore.get(3).sendKeys(Keys.ENTER);
            viewMoreAboutStore.get(4).sendKeys(Keys.ENTER);

            /*
            for (int i = 0; i < 5; i++) {
                viewMoreAboutStore.get(i).sendKeys(Keys.ENTER);
                Thread.sleep(1000);
                String windowHandle = driver.getWindowHandle();
                driver.switchTo().window(windowHandle);
                Thread.sleep(1000);
                WebElement webElementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']/span[@class = 'txt_more']"));
                webElementReviewMore.sendKeys(Keys.ENTER);
                //후기가 적은 경우 예외처리
                Thread.sleep(1000);
            }

             */
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowHandleList = windowHandles.stream().toList();
            driver.switchTo().window(windowHandleList.get(1));
            Thread.sleep(3000);
            WebElement element = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
            element.sendKeys(Keys.ENTER);
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

            List<WebElement> firstStoreComments = driver.findElements(By.xpath("//div[@class='comment_info']/p[@class='txt_comment']/span"));
            System.out.println(1 + " : reviewsBefore.size() = " + firstStoreComments.size());

            Thread.sleep(1000);
            for (int j = 0; j < 2; j++) {
                System.out.println(firstStoreComments.get(j).getText());
                Thread.sleep(1000);
            }


            //두번째 업체 댓글 추출
            driver.switchTo().window(windowHandleList.get(2));
            Thread.sleep(3000);
            WebElement element2 = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
            element2.sendKeys(Keys.ENTER);
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
            List<WebElement> secondStoreComments = driver.findElements(By.xpath("//div[@class='comment_info']/p[@class='txt_comment']/span"));
            System.out.println(2 + ": reviewsBefore.size() = " + secondStoreComments.size());



        }


    }

}
