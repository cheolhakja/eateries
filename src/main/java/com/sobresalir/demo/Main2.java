package com.sobresalir.demo;

import com.sobresalir.demo.store.Store;
import com.sobresalir.demo.store.StoreList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://place.map.kakao.com/2039472007"; //호남식당
        String url2 = "https://place.map.kakao.com/730072757"; //가재울순대
        String url3 = "https://place.map.kakao.com/20943170"; //풍년순대
        String url4 = "https://place.map.kakao.com/385184723"; //김둘레순대 상암2호점
        String url5 = "https://place.map.kakao.com/12435075"; //상암순대 기사식당

        new StoreList(new Store("호남식당", "2039472007"),
                new Store("가재울순대", "730072757"),
                new Store("풍년순대", "20943170"),
                new Store("김둘레순대 상암2호점", "385184723"),
                new Store("상암순대 기사식당", "12435075"),
                new Store("소문난순대국왕족발", "19011122"),
                new Store("24시가마솥순대", "9654229"));

        List<RatingReviewData> scrap = FinalVerCommentRateTogether.scrap(url5);

        String storeName = Main2.getStoreName(url5);
        String storeId = Main2.parseUrl(url5);

        for (int i = 0; i < scrap.size(); i++) {
            String review = scrap.get(i).getReview();
            String result = ParseCommentFromTextData.doAll(review);
            scrap.get(i).setReview(result);
        }

        Main2.serialize(scrap, storeName + "-" + storeId);
    }

    public static void serialize(List<RatingReviewData> list, String storeName) {
        JSONObject obj = new JSONObject();
        int i;

        for (i = 0; i < list.size(); i++) {
            JSONArray listJSON = new JSONArray();
            String key1 = "rating" + (i + 1); //이펙티브 자바 문자열?
            String key2 = "review" + (i + 1);
            RatingReviewData ratingReviewData = list.get(i);
            listJSON.add(ratingReviewData.getRating());
            listJSON.add(ratingReviewData.getReview());
            obj.put(key2, listJSON);

        }
        obj.put("number", (i));
        try {
            String fileName = "output-final" + "-" + storeName;
            FileWriter file = new FileWriter("C:\\Users\\IBK\\Desktop\\나만의-우테코\\kakaomap-data-scrap\\reviewdata\\second-trial\\" + fileName);
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+obj);
    }

    public static void serializeTestingData(List<RatingReviewData> list, String storeName) {
        JSONObject obj = new JSONObject();
        int i;

        for (i = 0; i < list.size(); i++) {
            JSONArray listJSON = new JSONArray();
            String key1 = "rating" + (i + 1); //이펙티브 자바 문자열?
            String key2 = "review" + (i + 1);
            RatingReviewData ratingReviewData = list.get(i);
            listJSON.add(ratingReviewData.getRating());
            listJSON.add(ratingReviewData.getReview());
            obj.put(key2, listJSON);

        }
        obj.put("number", (i));
        try {
            String fileName = "output-final" + "-" + storeName;
            FileWriter file = new FileWriter("C:\\Users\\IBK\\Desktop\\나만의-우테코\\kakaomap-data-scrap\\reviewdata\\testing\\" + fileName);
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+obj);
    }

    public static String getStoreName(String url) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get(url);
        Thread.sleep(1000);

        WebElement elementStoreName = driver.findElement(By.xpath("//div[@class = 'inner_place']/h2[@class = 'tit_location']"));
        return elementStoreName.getText();
    }

    public static String parseUrl(String url) {
        int length = url.length();
        int cnt = 0;
        int index = 0;
        for (int i = 5; i < length; i++) {
            if(url.charAt(i) == 'm' && url.charAt(i-1) == 'o' && url.charAt(i-2) == 'c') {
                index = i;
                break;
            }
        }
        String storeId = url.substring(index + 2, url.length());
        return storeId;
    }
}
