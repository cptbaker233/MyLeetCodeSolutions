package com.hujinbo.solution213打家劫舍Ⅱ;

/** 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

        给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

        示例 1:

        输入: [2,3,2]
        输出: 3
        解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        示例 2:

        输入: [1,2,3,1]
        输出: 4
        解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
             偷窃到的最高金额 = 1 + 3 = 4 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/house-robber-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {2,3,2};
        int[] arr2 = {1,2,3,1};
        System.out.println(rob(arr2));
    }
    //dp[n]表示考虑循环选出的最大值
    //ndp[n]表示0-n不考虑循环选出的最大值
    //cdp[n]表示不选第一个,剩余的元素最大值
    //如果nums[n]没被选中, 则结果为ndp[n - 1]
    //如果nums[n]确定选中, 则结果为nums[n] + cdp[n - 2]
    public static int rob(int[] nums) {
        //特殊情况处理
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //一般情况
        int[] ndp = new int[nums.length];
        int[] cdp = new int[nums.length];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        ndp[0] = nums[0];
        ndp[1] = Math.max(nums[0], nums[1]);
        cdp[0] = 0;
        cdp[1] = nums[1];
        for (int i = 2; i < nums.length; i ++) {
            ndp[i] = Math.max(ndp[i - 2] + nums[i], ndp[i - 1]);
            cdp[i] = Math.max(cdp[i - 2] + nums[i], cdp[i - 1]);
            dp[i] = Math.max(cdp[i - 2] + nums[i], ndp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
