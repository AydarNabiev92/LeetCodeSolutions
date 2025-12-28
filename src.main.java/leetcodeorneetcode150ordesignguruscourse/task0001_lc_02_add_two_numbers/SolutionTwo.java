package leetcodeorneetcode150ordesignguruscourse.task0001_lc_02_add_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    // https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        // Explanation: 342 + 465 = 807.

        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        System.out.println("ListNode 1 - " + listNode1);
        System.out.println("ListNode 2 - " + listNode2);
        System.out.println("Resulting ListNode" + addTwoNumbers(listNode1, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Take the first element from each listnode and get the sum, put it into the result, then go to the next one, etc
        List<Integer> listNodeContents = new ArrayList<>();
        boolean weCanGoOn = true;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int remainsFromPreviousIteration = 0;

        while (weCanGoOn) {
            // Get the addition digits
            int l1CurrentNumber = l1Current != null ? l1Current.val : 0;
            int l2CurrentNumber = l2Current != null ? l2Current.val : 0;
            int sum = l1CurrentNumber + l2CurrentNumber + remainsFromPreviousIteration;

            // Decide if we can continue
            weCanGoOn = (l1Current != null && l1Current.next != null) || (l2Current != null && l2Current.next != null);

            // Get the next digits
            l1Current = (l1Current != null && l1Current.next != null) ? l1Current.next : null;
            l2Current = (l2Current != null && l2Current.next != null) ? l2Current.next : null;

            // Get the remains of current addition
            remainsFromPreviousIteration = sum >= 10 ? 1 : 0;
            listNodeContents.add(sum >= 10 ? sum - 10 : sum);
        }

        // Don't forget about the last addition results
        if (remainsFromPreviousIteration == 1) {
            listNodeContents.add(remainsFromPreviousIteration);
        }

        // Create resulting ListNode
        ListNode result = null;
        for (int i = listNodeContents.size() - 1; i >= 0; i--) {
            result = new ListNode(listNodeContents.get(i), result);
        }

        return result;
    }



    // LISTNODE STRUCTURE GIVEN BY LEETCODE
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
