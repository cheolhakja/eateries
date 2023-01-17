package com.sobresalir.demo;

public class ParseCommentFromTextData {

    public static String parse(String text) {
        int cnt = 0;
        int startIndex = 0;
        int lastIndex = text.length();
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '\n') {
                cnt++;
                if(cnt == 6) {
                    startIndex = i;
                    break;
                }

            }

        }
        return text.substring(startIndex, lastIndex - 10);
    }

    public static String eliminateSuffixOfLikeNumber(String text) {
        int length = text.length();
        char c = text.charAt(length - 8); //8을 상수로 지정

        try {
            int i = Integer.parseInt(String.valueOf(c)); //함수로 만들기: validateInteger 이런식으로
        } catch(NumberFormatException e) {
            return text;
        }

        StringBuilder target = new StringBuilder(text);
        StringBuilder resultString = target.deleteCharAt(length - 8);
        StringBuilder resultString2 = target.deleteCharAt(length - 9);
        return resultString2.toString();
    }


}
