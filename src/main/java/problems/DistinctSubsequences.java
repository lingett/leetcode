package problems;

import common.BaseProblem;

/**
 * Created by gelin on 14-10-4.
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequences extends BaseProblem {
    @Override
    protected void execute() {
        String S = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
        String T = "bddabdcae";
//        String S = "rabibbit";
//        String T = "rabbit";
//        System.out.println(numDistinct_byRecursion(S, T));
        System.out.println(numDistinct_byDynamicProgramming(S, T));
    }

    /**
     * 通过递归方法实现
     * 【递归策略】：当前S中T的子串个数，可看作S从左向右截取子串后包含T的子串和
     * 【递归出口】：当前T的长度 = 0
     * T在S中子串的个数，即是求当前
     */
    private static int numDistinct_byRecursion(String S, String T) {
        int result = 0;
        int sLength = S.length();
        int tLength = T.length();
        if (tLength == 0) {
            return 1;
        }
        for (int index = 0; index < sLength; index++) {
            if (sLength - index < tLength) {
                break;
            }
            if (S.charAt(index) == T.charAt(0)) {
                result += numDistinct_byRecursion(S.substring(index + 1, sLength), T.substring(1, tLength));
            }
        }
        return result;
    }

    /**
     * 通过DP算法实现
     * 【DP策略】：假设T的长度为i，S的长度为j，用数组dp[i][j]标志T在S中出现的次数
     * 假设i、j是T、S的最后一位
     * 如果T[i]！=S[j]，dp[i][j]=dp[i][j-1]
     * 如果T[i]=S[j]，dp[i][j]=dp[i][j-1]+dp[i-1][j-1]
     */
    private static int numDistinct_byDynamicProgramming(String S, String T) {
        int tLength = T.length();
        int sLength = S.length();
        int dp[][] = new int[tLength + 1][sLength + 1];
        for (int j = 0; j <= sLength; j++) {
            dp[0][j] = 1;
        }
        for (int j = 1; j <= sLength; j++) {
            for (int i = 1; i <= tLength; i++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLength][sLength];
    }

    public static void main(String[] args) {
        BaseProblem target = new DistinctSubsequences();
        target.process();
    }
}
