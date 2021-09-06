package org.alex.util;

import org.alex.data.Advertisement;

public class HtmlParser {

    public static Advertisement createAdvertisement(String content){
        String url=getURL(content);
        return new Advertisement(url);
    }

    private static String getURL(String content){
        int start=content.indexOf("\"position\":0");
        int end=content.indexOf("\"position\":1");
        String substring = content.substring(start, end);
        substring="https://willhaben.at"+substring.substring(20, substring.indexOf("\"}"));
        return substring;
    }
}
