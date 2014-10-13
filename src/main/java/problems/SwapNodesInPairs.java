package problems;

import common.BaseProblem;
import common.ListNode;

/**
 * Created by gelin on 14-10-12.
 * <p/>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs extends BaseProblem {
    private static final int SPACE = 2;

    @Override
    protected void execute() {
        int count = SPACE * 4;
        ListNode head = new ListNode(1);
        ListNode currentNode = head;
        for (int i = 2; i <= count; i++) {
            ListNode newNode = new ListNode(i);
            currentNode.setNext(newNode);
            currentNode = newNode;
        }

        currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getVal() + ",");
            currentNode = currentNode.getNext();
        }
        System.out.println();

        ListNode result = swapInSpace(head);
        currentNode = result;
        while (currentNode != null) {
            System.out.print(currentNode.getVal() + ",");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static ListNode swapInSpace(ListNode head) {
        ListNode resultHead = null;
        ListNode resultTail = head;
        ListNode currentNode = head;
        head = head.getNext();

        int spaceIndex = 1;
        ListNode nodeCacheHead = null;
        ListNode nodeCacheTail = currentNode;

        while (currentNode != null) {
            if (currentNode != nodeCacheHead) {
                currentNode.setNext(nodeCacheHead);
                nodeCacheHead = currentNode;
            }

            currentNode = head;
            head = head == null ? null : head.getNext();

            if (spaceIndex == SPACE) {
                if (resultHead == null) {
                    resultHead = nodeCacheHead;
                } else {
                    nodeCacheTail.setNext(resultTail.getNext());
                    resultTail.setNext(nodeCacheHead);
                    resultTail = nodeCacheTail;
                }
                nodeCacheHead = currentNode;
                nodeCacheTail = currentNode;
                spaceIndex = 0;
            }

            spaceIndex++;
        }

        return resultHead;
    }

    public static void main(String[] args) {
        BaseProblem target = new SwapNodesInPairs();
        target.process();
    }

}
