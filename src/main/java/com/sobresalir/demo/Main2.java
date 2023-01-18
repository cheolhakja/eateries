package com.sobresalir.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        List<RatingReviewData> scrap = FinalVerCommentRateTogether.scrap();

        for (int i = 0; i < scrap.size(); i++) {
            String review = scrap.get(i).getReview();
            String result = ParseCommentFromTextData.doAll(review);
            scrap.get(i).setReview(result);
        }

        Main2.serialize(scrap);
    }

    private static void serialize(List<RatingReviewData> list) {
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
            String fileName = "output-final";
            FileWriter file = new FileWriter("C:\\Users\\IBK\\Desktop\\나만의-우테코\\kakaomap-data-scrap\\reviewdata\\second-trial\\" + fileName);
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+obj);
    }
}
