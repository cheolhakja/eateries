package com.sobresalir.demo.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreList {
    /*
    클래스 생성 이유: Main함수 안에서 가게 이름을 추가하고 관리하면 코드가 너무 장황해지고 Main함수의 역할에도 안맞는다고 생각해서
    객체로 그룹화해서 보기에 깔끔하게 만듦
     */
    private List<Store> storeList;

    public StoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public StoreList(Store... stores) {
        this.storeList = Arrays.asList(stores);
    }

}
