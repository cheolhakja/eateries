package com.sobresalir.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParseCommentFromTextDataTest {
    @Test
    public void test() {
        String s = "피스힐\n후기\n106\n별점평균\n2.9\n2021.09.18.\n머릿고기가 맛있구요 내장은 냄새가 나서 좀 그렇습니다\n순대국엔 깻잎이 들어가고 다소 평범합니다\n좋아요\n메뉴 더보기";
        String parse = ParseCommentFromTextData.parse(s);
        System.out.println("parse = " + parse);
    }

    @Test
    public void 리뷰가_없고_별점만_남겼을때도_정상적으로_추출되는지_테스트() {
        String s = "f1\n후기\n14\n별점평균\n3.9\n2022.11.19.\n좋아요\n메뉴 더보기";
        String parse = ParseCommentFromTextData.parse(s);
        System.out.println("parse = " + parse);
    }

    @Test
    @DisplayName("getText() 뒷부분 파싱")
    public void 좋아요_더보기_같이있는경우() {
        String s = "관록이 느껴져..\n더보기\n좋아요 2\n메뉴 더보기";
        String s1 = ParseCommentFromTextData.eliminateSuffixOfLikeNumber(s);
        Assertions.assertThat(s1).isEqualTo("관록이 느껴져..\n더보기\n좋아요\n메뉴 더보기");
    }


}
