package com.company;

import java.util.List;

/*
2022-12-04LeetCode1796 从字符串中查找第二大的数字
https://leetcode.cn/problems/second-largest-digit-in-a-string/
 */
public class Solution1796 {
    public static void main(String[] args) {
        String s = "dfa1111";
        System.out.println(new Solution1796().secondHighest(s));
    }

    public int secondHighest(String s) {
        int max = -1;
        int secondMax = -1;
        char[] c = s.toCharArray();
        for (char value : c) {
            if (Character.isDigit(value)) {
                int num = value - '0';// 字符转数字，ASCII计算
                if (num > max) {
                    secondMax = max;
                    max = num;
                } else if (num > secondMax && num < max) { // 注意避免num=max的情况
                    secondMax = num;
                }
            }
        }
        return secondMax;
    }
}
