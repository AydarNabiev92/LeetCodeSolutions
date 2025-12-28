package leetcodeorneetcode150ordesignguruscourse.task0035_lc_141_linked_list_cycle;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/linkedlist-cycle-easy
        // https://leetcode.com/problems/linked-list-cycle/description/
        // Given head, the head of a linked list, determine if the linked list has a cycle in it.
        //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
        // following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
        // is connected to. Note that pos is not passed as a parameter.
        //Return true if there is a cycle in the linked list. Otherwise, return false.
        // Example 1:
        // Input: head = [3,2,0,-4], pos = 1
        //Output: true
        //Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
        // Example 2:
        // Input: head = [1,2], pos = 0
        //Output: true
        //Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
        // Example 3:
        // Input: head = [1], pos = -1
        //Output: false
        //Explanation: There is no cycle in the linked list.
        ListNode n0 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;   // ← this creates the cycle (pos = 1)

        ListNode head = n0;

        System.out.println(hasCycle(head)); // true
    }

    public static boolean hasCycle(ListNode head) {
        // my solution tweaked by chatpt
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*public static boolean hasCycle(ListNode head) {
        // my accepted solution
        if (head == null || head.next == null) {
            return false;
        }
        // slow and fast pointers

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }*/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
