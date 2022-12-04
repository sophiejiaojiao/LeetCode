package com.company;

import java.sql.Array;
import java.util.ArrayList;

/*
2022-11-27 LeetCode345
 */
public class Solution345 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution345().reverseVowels(s));
    }

    public boolean isYuanyin(char c) {
        String str = c + "";
        return str.equalsIgnoreCase("a")
                || str.equalsIgnoreCase("e")
                || str.equalsIgnoreCase("i")
                || str.equalsIgnoreCase("o")
                || str.equalsIgnoreCase("u");
    }

    public String reverseVowels(String s) {
        char[] result = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (isYuanyin(s.charAt(left))) {
                if (isYuanyin(s.charAt(right))) {
                    char temp = s.charAt(left);
                    result[left] = s.charAt(right);
                    result[right] = temp;
                    left++;
                }
                right--;
            } else {
                left++;
            }
        }
        return new String(result);
    }
}
