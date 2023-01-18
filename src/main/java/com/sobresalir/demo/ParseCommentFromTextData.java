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

    public static String removePrefix(String text) {
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
        if(cnt == 6) {
            return text.substring(startIndex + 1, lastIndex);
        } else if(cnt == 5) {
            return "";
        } else {
            return "";
        }
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

    public static String eliminateSuffixOfViewMore(String text) {
        int length = text.length();
        String substring = text.substring(length - 14, length - 10);
        if(substring.equals("더보기\n")) {
            StringBuilder target = new StringBuilder(text);
            StringBuilder resultString1 = target.deleteCharAt(length - 14);
            StringBuilder resultString2 = target.deleteCharAt(length - 14);
            StringBuilder resultString3 = target.deleteCharAt(length - 14);
            StringBuilder resultString4 = target.deleteCharAt(length - 14);
            return resultString4.toString();
        }
        return text;
    }

    public static String eliminateRestAllSuffix(String text) {
        int length = text.length();
        return text.substring(0, length - 11);
    }

    public static String removeSuffix(String text) {
        String likeNumberRemovedString = ParseCommentFromTextData.eliminateSuffixOfLikeNumber(text);
        String viewMoreRemovedString = ParseCommentFromTextData.eliminateSuffixOfViewMore(likeNumberRemovedString);
        String resultString = ParseCommentFromTextData.eliminateRestAllSuffix(viewMoreRemovedString);
        return resultString;
    }

    public static String doAll(String text) {
        String s = ParseCommentFromTextData.removeSuffix(text);
        return ParseCommentFromTextData.removePrefix(s);

    }
}
