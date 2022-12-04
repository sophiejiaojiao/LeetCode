package com.company;

import java.util.*;
/*
2022-11-27集合练习
 */

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 5, 5, 9, 3, 4, 4, 1, 8};
        System.out.println(new Test().test(array));
    }

    public int test(int[] array) {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (linkedHashMap.containsKey(array[i])) {
                linkedHashMap.put(array[i], linkedHashMap.get(array[i]) + 1);
            } else {
                linkedHashMap.put(array[i], 1);
            }
        }
        // 方法一：遍历集合
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
            if (entry.getValue() == 1) {
                result = entry.getKey(); // 输出最后一个count为1的值；如果输出第一个，则直接return
            }
        }
        System.out.println();
        // 方法二：直接通过数组查询count=1的数
        for (int i = array.length - 1; i >= 0; i++) {
            if (linkedHashMap.get(array[i]) == 1) {
                return array[i];
            }
        }
        System.out.println();
        return result;
    }
}
