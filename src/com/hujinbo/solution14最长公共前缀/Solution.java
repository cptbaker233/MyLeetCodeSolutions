package com.hujinbo.solution14最长公共前缀;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower","flow","flight"};
        String[] strs2 = new String[]{"dog","racecar","car"};
        System.out.println(longestPrefix(strs1));
        System.out.println(longestPrefix(strs2));
    }

    public static String longestPrefix(String[] arr) {
        /* 1.准备一个char数组用于存放前缀 */
        char[] resCharArr = new char[200];
        int index = -1;     //前缀索引指针
        boolean found = false;
        /* 2.遍历数组找公共前缀 */
        for (int j = 0; j < arr[0].length() && !found; j ++) {
            index ++;
            char targetChar = arr[0].charAt(index);
            for (int i = 0; i < arr.length; i ++) {
                /* 获取目标字符 */
                if (index < arr[i].length() && arr[i].charAt(index) == targetChar) {
                    if (i == arr.length - 1) {
                        resCharArr[index] = targetChar;
                    }
                    continue;
                } else {
                    found = true;
                    break;
                }
            }
        }
        return new String(resCharArr).trim();
    }

}