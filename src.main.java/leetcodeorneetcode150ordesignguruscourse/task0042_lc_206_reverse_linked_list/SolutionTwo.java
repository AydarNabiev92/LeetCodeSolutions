package leetcodeorneetcode150ordesignguruscourse.task0042_lc_206_reverse_linked_list;

public class SolutionTwo {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/reverse-a-linkedlist-easy
        // https://leetcode.com/problems/reverse-linked-list/
        // Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the
        // reversed LinkedList.
        // Constraints:
        //    The number of nodes in the list is the range [0, 5000].
        //    -5000 <= Node.val <= 5000
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode head = n0;

        System.out.println(head);
        System.out.println(reverse(head)); // [5,4,3,2,1]
    }

    public static ListNode reverse(ListNode head) {
        // what I remember - reassigning everything and creating a new surrogate for proper reversal
        if (head == null || head.next == null) {
            return head;
        }

        // head starts with 1 -> 2 -> 3 -> 4 -> 5
        // prev starts with null
        // after step 1
        // head becomes 2 -> 3 -> 4 -> 5
        // prev becomes 1 -> null
        // and so on
        // so head must lose its nexts step by step and prev must inherit them, but in reverse
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    static class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
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
