package com.sobresalir.demo.store;

public class Store {

    //모든 객체가 공용으로 사용한다. 한번 할당하면 재할당이 불가능하다(final)
    private static final String urlPrefix = "https://place.map.kakao.com/";
    private String name;
    private String url;

    public Store(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
