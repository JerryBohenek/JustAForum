package com.jaf.justaforum.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {

    public static boolean regexCheck(String regex, String stringToCheck) {
        Pattern regexPattern = Pattern.compile(regex);
        Matcher regexMatcher = regexPattern.matcher(stringToCheck);

        return regexMatcher.matches();
    }
}
