package com.sobresalir.demo;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONSerialization {

    public static void serialize(List<WebElement> list) throws InterruptedException {
        JSONObject obj = new JSONObject();
        int i;

        for (i = 0; i < list.size(); i++) {
            String key = "review" + (i + 1); //이펙티브 자바 문자열?
            String value = list.get(i).getText();
            obj.put(key, value);
            Thread.sleep(1000);
        }
        obj.put("number", (i + 1));
        try {
            FileWriter file = new FileWriter("C:\\Users\\IBK\\Desktop\\나만의-우테코\\kakaomap-data-scrap\\reviewdata\\first-demo\\output.json");
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+obj);
    }


    public static void serialize() throws InterruptedException {
        JSONObject obj = new JSONObject();
        int i;

        List<String> list = List.of("hi", "good", "go");
        for (i = 0; i < list.size(); i++) {
            String key = "review" + (i + 1); //이펙티브 자바 문자열?
            String value = list.get(i);
            obj.put(key, value);
            Thread.sleep(1000);
        }
        obj.put("number", i + 1);
        try {
            FileWriter file = new FileWriter("C:\\Users\\IBK\\Desktop\\나만의-우테코\\kakaomap-data-scrap\\reviewdata\\first-demo\\output2.json");
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+obj);
    }



    public static void printReview(List<WebElement> list) throws InterruptedException {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "번째 : " + list.get(i).getText());
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
