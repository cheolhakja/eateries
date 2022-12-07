package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


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
            System.out.println("viewMoreAboutStore.get(10). = " + viewMoreAboutStore.get(14));

            String domAttribute = viewMoreAboutStore.get(0).getDomAttribute("href");
            System.out.println("domAttribute = " + domAttribute);


             */
            //WebElement storeViewMoreButton = viewMoreAboutStore.get(0);
            //storeViewMoreButton.sendKeys(Keys.ENTER);

            //String winHandleBefore = driver.getWindowHandle();
            //driver.switchTo().window(winHandleBefore);

        }


    }

}
