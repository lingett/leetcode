package problems;

import common.BaseProblem;

/**
 * Created by gelin on 14/11/1.
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne extends BaseProblem {
    @Override
    protected void execute() {
        int digits[] = new int[]{9, 9, 8};

        for (int value : digits) {
            System.out.print(value + ",");
        }
        System.out.println();

        int result[] = plusOne(digits);

        for (int value : result) {
            System.out.print(value + ",");
        }
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        } else {
            return digits;
        }
    }

    public static void main(String... args) {
        BaseProblem plusOne = new PlusOne();
        plusOne.process();
    }
}
