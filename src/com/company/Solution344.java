package com.company;

/*
2022-11-27 LeetCode344
 */
public class Solution344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l' };
        new Solution344().reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }

    // while方法
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) { // 考虑奇数left=right时不用交换、偶数场景left>right不用交换
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // for循环方法
    public void reverseString1(char[] s) {
        int middle = s.length / 2;
        for (int left = 0; left < middle; left++) {
            int right = s.length - 1 - left;
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
