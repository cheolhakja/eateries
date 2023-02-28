package com.sobresalir.demo.model_test;

import com.sobresalir.demo.FinalVerCommentRateTogether;
import com.sobresalir.demo.Main2;
import com.sobresalir.demo.ParseCommentFromTextData;
import com.sobresalir.demo.RatingReviewData;

import java.util.List;

public class ScrapModelTestData {
    public static void main(String[] args) throws InterruptedException {
        ScrapModelTestData.doAll("https://place.map.kakao.com/13499817");
    }

    public static void doAll(String url) throws InterruptedException {
        List<RatingReviewData> scrapedData = FinalVerCommentRateTogether.scrap(url);

        String storeName = Main2.getStoreName(url);
        String storeId = Main2.parseUrl(url);

        for (int i = 0; i < scrapedData.size(); i++) {
            String review = scrapedData.get(i).getReview();
            String result = ParseCommentFromTextData.doAll(review);
            scrapedData.get(i).setReview(result);
        }

        Main2.serializeTestingData(scrapedData, storeName + "-" + storeId);    }
}
