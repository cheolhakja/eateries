package com.sobresalir.demo;

class RatingReviewData {

    //public 삭제
    private String rating;
    private String review;

    public RatingReviewData(String rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingReviewData{" +
                "rating='" + rating + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
