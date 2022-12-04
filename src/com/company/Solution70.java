package com.company;

/*
2022-11-13：LeetCode70爬楼梯
递归和迭代两种方式解题》》重点：要考虑最低的取值范围，即出口
递归缺点：耗时长，两点
(1) 存在大量的重复计算》比如算5时需要计算4和3，算4的时候需要算3和2，算3时需要算2和1，因此需要重复计算2和3
(2) 递归是栈结构，存在压栈和出栈耗时》比如算5时需要计算4和3，所以把算5的任务先压栈，等待计算完4和3，再把5出栈
 */
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
 */
public class Solution70 {
    // 快速输出main方法方式：psvm
    public static void main(String[] args) {
        /*
        静态方法属于类，可以通过类直接调用，如类名.静态方法名
        非静态方法（即实例方法），只能通过具体的对象调用，对象通过new出来，如对象名.非静态方法名
        静态方法是公共方法，只能调用静态方法，不能调用非静态方法；但是非静态方法可以调用静态方法，因为是公共的
         */
        System.out.println(new Solution70().climbStairs(5)); //快速输出方式：sout
        System.out.println(new Solution70().climbStairs1(5)); //快速复制一行：command+D
        System.out.println(new Solution70().climbStairs2(5));
        System.out.println(new Solution70().climbStairs3(5));
    }

    public int climbStairs(int n) {
        /*
        递归（从上往下）解题思路：举例n=10，因【每次可以爬1或2个台阶】，所以可以先计算到第9个和第8个台阶的方法，依次递归（自己调自己）
        另：递归需要一个出口，即当n为最小或者最大时，递归结束
         */
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        /*
        迭代（从下往上）解题思路：思路同递归，只是一个从上往下且需要自己调自己；迭代是下往上，不需要自己调自己
         */
        int[] array = new int[n];
        // 坑1：需要考虑数组长度为1时的处理方式
        // 坑2：空间复杂度太高
        if (n == 1) {
            return 1;
        }
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

    public int climbStairs2(int n) {
        /*
        迭代：基于climbStairs1存在的坑1的优化思路》浪费一个array[0]空间
        坑2：空间复杂度太高
        空间复杂度o(n)：因为new了一个空间为n的数组
        时间复杂度o(n)：因为一重循环
        说明：并列循环仍是o(n),嵌套循环，嵌套几个就n的几次幂
         */
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public int climbStairs3(int n) {
        /*
        迭代：基于climbStairs2存在的坑2优化》通过定义变量，节省空间
        多个变量重命名快捷方式：选中某个变量，右键变量-refactor-rename替换
         */
        int prePre = 1;
        int pre = 1;
        int current = 1; // current为起始值，即考虑n=1的场景
        for (int i = 2; i <= n; i++) { // 注意for循环的判断条件是要计算到几，即与n判断
            current = prePre + pre;
            prePre = pre;
            pre = current;
        }
        return current;
    }
}
