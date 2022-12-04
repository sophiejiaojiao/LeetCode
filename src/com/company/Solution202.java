package com.company;

import java.util.ArrayList;
import java.util.HashSet;

/*
2022-11-20:LeetCode202快乐数
第一步：计算n的各个位置数之和
第二步：判断第一步的结果数是否为1，不为1则递归继续计算结束数的位置数之和
第三步【无限循环】：存在某些数永远不会为1，而是循环重复某些结果数，会死循环
》》因此需要增加集合去重判断，当集合中出现重复数，表明开始了新一轮循环，永远不会为1了，没必要继续执行
 */
public class Solution202 {
    HashSet<Object> set = new HashSet<>();

    public static void main(String[] args) {
        //System.out.println(new Solution202().isHappy(2));
        new Solution202().printNum(12345);
    }

    public void printNum(int n) {
        ArrayList<Object> arrList = new ArrayList<>();
        while (n != 0) {
            int num = n % 10;
            System.out.print(num + "\t");
            arrList.add(num);
            n = n / 10;
        }
        System.out.println();
        for (int i = arrList.size() - 1; i >= 0; i--) {
            System.out.print(arrList.get(i) + "\t");
        }
    }

    public boolean isHappy(int n) {
        int result = testSum(n);
        if (set.contains(result)) {
            return false;
        } else {
            set.add(result);
        }
        if (result == 1) {
            return true;
        }
        return isHappy(result);
    }

    public int testSum(int n) {
        int result = 0;
        while (n != 0) {
            result = result + (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}
