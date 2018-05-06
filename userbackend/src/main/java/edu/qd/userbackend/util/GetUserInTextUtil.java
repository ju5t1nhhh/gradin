package edu.qd.userbackend.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GetUserInTextUtil {

    public static List<String> getAtedUsers(String text, char c) {
        char[] str = text.toCharArray();
        List<String> strings = new LinkedList<>();
        int i = 0;
        while ( i < str.length ) {
            if ( str[i] != c ) {
                i++;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                i++;
                while ( str[i] != ' ' )
                    sb.append(str[i++]);
                strings.add(sb.toString());
            }
        }
        return strings;
    }

}
