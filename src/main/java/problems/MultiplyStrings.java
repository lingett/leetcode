package problems;

import common.BaseProblem;

/**
 * Created with IntelliJ IDEA.
 * User: ge.lin
 * Date: 14-10-27
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings extends BaseProblem {
    @Override
    protected void execute() {
        String s1 = "672";
        String s2 = "8";
        System.out.println(multiply(s1, s2));
    }

    public static String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int multiplyArr[][] = new int[num2.length()][num1.length() + num2.length() + 1];

        int multiply;
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                multiply = getIntValue(num2.charAt(i)) * getIntValue(num1.charAt(j)) + carry;
                multiplyArr[num2.length() - i - 1][(num1.length() - j) + (num2.length() - i) - 2] = multiply % 10;
                carry = multiply / 10;
            }
            if (carry > 0) {
                multiplyArr[num2.length() - i - 1][num1.length() + (num2.length() - i) - 1] = carry;
                carry = 0;
            }
        }

        int sum;
        carry = 0;
        for (int i = 1; i < num2.length(); i++) {
            for (int j = 0; j <= num1.length() + num2.length(); j++) {
                sum = multiplyArr[i][j] + multiplyArr[i - 1][j];
                multiplyArr[i][j] = sum % 10 + carry;
                carry = sum / 10;
            }
        }

        boolean isHeadZero = true;
        for (int i = num1.length() + num2.length(); i >= 0; i--) {
            if (isHeadZero && multiplyArr[num2.length() - 1][i] == 0) {
                continue;
            }
            if (isHeadZero && multiplyArr[num2.length() - 1][i] > 0) {
                isHeadZero = false;
            }
            result.append(multiplyArr[num2.length() - 1][i]);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    private static int getIntValue(char c) {
        return c - '0';
    }

    private static char getCharValue(int i) {
        return (char) ('0' + i);
    }

    public static void main(String... args) {
        BaseProblem multiplyStrings = new MultiplyStrings();
        multiplyStrings.process();
    }
}
