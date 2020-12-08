package com.study.practice.leetcode.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/25 10:02
 */
public class No139_medium {
    public static void main(String[] args) {
        No139_medium no139_medium = new No139_medium();
        System.out.println(no139_medium.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(no139_medium.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(no139_medium.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and","cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            int curLen = word.length();
            if (curLen < minLen) {
                minLen = curLen;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }
            wordSet.add(word);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            int step = minLen;
            while (step <= maxLen && i - step >= 0) {
                if (dp[i - step] && wordSet.contains(s.substring(i-step, i))) {
                    dp[i] = true;
                    break;
                }
                step++;
            }
        }

        return dp[s.length()];
    }
}
