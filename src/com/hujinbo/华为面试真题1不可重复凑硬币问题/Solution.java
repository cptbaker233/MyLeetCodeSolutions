package com.hujinbo.华为面试真题1不可重复凑硬币问题;

//有面值为[1,2,3,4,5,6,7,8,9,10]的硬币, 凑成17的所有组合数


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int amount = 17;
        System.out.println(count(amount, arr));
    }
    //给定硬币数组, 求凑成指定金额的组合数, 每个面值硬币只有一个
    //使用动态规划, 假设f[n][m]表示为使用数组的0~n索引的硬币, 凑成金额为m的金钱的组合数量
    //则f[n][m]分为最后一个硬币选了和最后一个硬币没有选择两种情况
    //如果选了最后一个硬币,相当于从0-n-1范围选取硬币来凑m减去n硬币的面额arr[n]之后的金额
    //如果没选最后一个硬币,相当于从0-n-1范围选取硬币来凑m
    //f[n][m] = f[n - 1][m - arr[n]] + f[n - 1][m]
    public static int count(int amount, int[] arr) {
        if (amount == 0) {  //特殊情况处理
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        int[][] f = new int[arr.length][amount + 1];
        //最低层条件, 用arr的0~0部分来凑0, 为1种组合, 用硬币1凑0,就是一个硬币不凑一种情况
        f[0][0] = 1;
        //二维数组第一列情况,分别用arr的0~i部分来凑0, 类似于f[0][0], 用什么来凑0都是一个硬币都不凑一种
        for (int i = 0; i < arr.length; i ++) {
            f[i][0] = 1;
        }
        //二维数组第一行情况,用arr的0~0部分也就是1来凑面值0~m的情况数, 如果arr[0]和m相等就是1种,不然凑不出
        for (int i = 1; i < arr.length; i ++) {
            f[0][i] = arr[0] == i ? 1 : 0;
        }
        //迭代填满二维数组
        for (int i = 1; i < arr.length; i ++) {
            for (int j = 1; j < amount + 1; j ++) {
                if (j - arr[i] < 0) {
                    f[i][j] = f[i - 1][j];
                    continue;
                }
                f[i][j] = f[i - 1][j - arr[i]] + f[i - 1][j];
            }
        }
        return f[arr.length - 1][amount];
    }

    //打印二维数组
    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
