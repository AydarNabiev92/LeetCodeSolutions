package leetcodeorneetcode150ordesignguruscourse.task0042_lc_206_reverse_linked_list;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/reverse-linked-list/
        // Given the head of a singly linked list, reverse the list, and return the reversed list.
        //Example 1:
        // Input: head = [1,2,3,4,5]
        //Output: [5,4,3,2,1]
        //Example 2:
        // Input: head = [1,2]
        //Output: [2,1]
        //Example 3:
        //Input: head = []
        //Output: []
        // Constraints:
        //The number of nodes in the list is the range [0, 5000].
        //-5000 <= Node.val <= 5000
        //Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
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

        System.out.println(reverseList(head)); // [5,4,3,2,1]
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next; // the rest that must go on
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    static class ListNode {
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
