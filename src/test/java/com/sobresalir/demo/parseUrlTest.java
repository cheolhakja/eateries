package com.sobresalir.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class parseUrlTest {

    @Test
    public void test() {
        String url = "https://place.map.kakao.com/2039472007";
        String s = Main2.parseUrl(url);
        Assertions.assertThat(s).isEqualTo("2039472007");
    }
}
