package com.sobresalir.demo;

import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        List<RatingReviewData> scrap = FinalVerCommentRateTogether.scrap();
        int num = scrap.size();
        RatingReviewData ratingReviewData = scrap.get(num - 1);
        String review = ratingReviewData.getReview();

        RatingReviewData ratingReviewData2 = scrap.get(num - 7);
        String review2 = ratingReviewData2.getReview();

        System.out.println("review = " + review);
        System.out.println();
        System.out.println("review2 = " + review2);
        System.out.println();
        String s = ParseCommentFromTextData.doAll(review);
        System.out.println("s = " + s);
        
    }
}
