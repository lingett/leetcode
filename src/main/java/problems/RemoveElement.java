package problems;

import common.BaseProblem;

import java.util.Arrays;

/**
 * Created by gelin on 14/10/31.
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class c extends BaseProblem {
    @Override
    protected void execute() {
        int n = 10;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        for(int value : a) {
            System.out.print(value + ",");
        }
        System.out.println();

        System.out.println(removeElement(a, 1));

        for(int value : a) {
            System.out.print(value + ",");
        }
        System.out.println();
    }

    public int removeElement(int[] A, int elem) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[index++] = A[i];
            }
        }
        return index;
    }

    public static void main(String... args) {
        BaseProblem removeElement = new RemoveElement();
        removeElement.process();
    }

}
