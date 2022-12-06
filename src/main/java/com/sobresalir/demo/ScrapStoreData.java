package com.sobresalir.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScrapStoreData {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://map.kakao.com/");
        Thread.sleep(1000);

        WebElement webElementKeyWord = driver.findElement(By.id("search.keyword.query"));
        webElementKeyWord.sendKeys("경복궁 맥도날드");
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


    }

}
