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
}
