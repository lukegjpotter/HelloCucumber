package com.lukegjpotter.hellocucumber.isitfriday;

public class IsItFriday {

    public static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
