package com.sobresalir.demo;

import org.junit.jupiter.api.Test;

public class ParseCommentFromTextDataTest {
    @Test
    public void test() {
        String s = "피스힐\n후기\n106\n별점평균\n2.9\n2021.09.18.\n머릿고기가 맛있구요 내장은 냄새가 나서 좀 그렇습니다\n순대국엔 깻잎이 들어가고 다소 평범합니다\n좋아요\n메뉴 더보기";
        String parse = ParseCommentFromTextData.parse(s);
        System.out.println("parse = " + parse);
    }
}
