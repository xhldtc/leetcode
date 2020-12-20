package com.problems.e;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeTinyURL {

    List<String> list = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return String.valueOf(list.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return list.get(Integer.parseInt(shortUrl));
    }
}
