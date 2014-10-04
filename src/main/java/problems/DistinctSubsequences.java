package problems;

import common.BaseProblem;

/**
 * Created by gelin on 14-10-4.
 */
public class DistinctSubsequences extends BaseProblem {
    @Override
    protected void execute() {
        String S = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
        String T = "bddabdcae";
        System.out.println(numDistinct(S, T));
    }

    int numDistinct(String S, String T) {
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
                result += numDistinct(S.substring(index + 1, sLength), T.substring(1, tLength));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BaseProblem target = new DistinctSubsequences();
        target.process();
    }
}
