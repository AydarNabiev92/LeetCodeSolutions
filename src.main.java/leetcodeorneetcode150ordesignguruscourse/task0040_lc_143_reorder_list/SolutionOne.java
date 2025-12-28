package leetcodeorneetcode150ordesignguruscourse.task0040_lc_143_reorder_list;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2-rearrange-a-linkedlist-medium
        // https://leetcode.com/problems/reorder-list/description/
        // You are given the head of a singly linked-list. The list can be represented as:
        //L0 → L1 → … → Ln - 1 → Ln
        //Reorder the list to be on the following form:
        //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        //You may not modify the values in the list's nodes. Only nodes themselves may be changed.
        // Example 1
        // Input: head = [1,2,3,4]
        //Output: [1,4,2,3]
        // Example 2
        // Input: head = [1,2,3,4,5]
        //Output: [1,5,2,4,3]
        // Constraints:
        //    The number of nodes in the list is in the range [1, 5 * 104].
        //    1 <= Node.val <= 1000
        // Example 3:
        //Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
        //Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
        // Example 2:
        //Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
        //Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
        ListNode n00 = new ListNode(1);
        ListNode n01 = new ListNode(2);
        ListNode n02 = new ListNode(3);
        ListNode n03 = new ListNode(4);

        n00.next = n01;
        n01.next = n02;
        n02.next = n03;
        n03.next = null;

        ListNode head0 = n00;

        System.out.println(head0);
        reorderList(head0);
        System.out.println(head0); // [1,4,2,3]



        ListNode n10 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(3);
        ListNode n13 = new ListNode(4);
        ListNode n14 = new ListNode(5);

        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = null;

        ListNode head1 = n10;

        System.out.println(head1);
        reorderList(head1);
        System.out.println(head1); // [1,5,2,4,3]

        ListNode n20 = new ListNode(2);
        ListNode n21 = new ListNode(4);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(8);
        ListNode n24 = new ListNode(10);
        ListNode n25 = new ListNode(12);

        n20.next = n21;
        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        n25.next = null;

        ListNode head2 = n20;

        System.out.println(head2);
        reorderList(head2);
        System.out.println(head2); // [2,12,4,10,6,8]
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // we need to reverse the second half
        // then we move from the head and replace links to make them fit between
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);
        ListNode traversal = head;
        // now we must correctly change our links
//        while (head.next != null && reversed.next != null) {
        while (reversed != null && reversed.next != null) {
            // heads next must be taken from reversed, reversed must also advance as well as head
            ListNode reversedToInsert = reversed;
            reversed = reversed.next;
            ListNode realHeadNext = traversal.next;
            traversal.next = reversedToInsert;
            reversedToInsert.next = realHeadNext;
            traversal = traversal.next.next;
        }
    }

    private static ListNode reverse(ListNode listNode) {
        ListNode prev = null;
        while (listNode != null) {
            ListNode temp = listNode.next; // because otherwise we will lose our sequence
            listNode.next = prev; // starting of reversal
            prev = listNode;
            listNode = temp; // this is where the remainder to reverse will go
        }

        return prev;
    }

    public ListNode reorder(ListNode head) {
        // designgurus version
        if (head == null || head.next == null) {
            return head;
        }

        // we need to reverse the second half
        // then we move from the head and replace links to make them fit between
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);
        ListNode traversal = head;
        // now we must correctly change our links
//        while (head.next != null && reversed.next != null) {
        while (reversed != null && reversed.next != null) {
            // heads next must be taken from reversed, reversed must also advance as well as head
            ListNode reversedToInsert = reversed;
            reversed = reversed.next;
            ListNode realHeadNext = traversal.next;
            traversal.next = reversedToInsert;
            reversedToInsert.next = realHeadNext;
            traversal = traversal.next.next;
        }

        return head;
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

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
