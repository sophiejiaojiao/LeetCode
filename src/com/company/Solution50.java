package com.company;
/*
2022-11-27 LeetCode50
 */

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new Solution50().firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
