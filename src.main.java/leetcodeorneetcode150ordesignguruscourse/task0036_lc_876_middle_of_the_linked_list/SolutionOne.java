package leetcodeorneetcode150ordesignguruscourse.task0036_lc_876_middle_of_the_linked_list;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/middle-of-the-linkedlist-easy
        // https://leetcode.com/problems/middle-of-the-linked-list/description/
        // Given the head of a singly linked list, return the middle node of the linked list.
        //If there are two middle nodes, return the second middle node.
        // Example 1:
        // Input: head = [1,2,3,4,5]
        //Output: [3,4,5]
        //Explanation: The middle node of the list is node 3.
        // Example 2:
        // Input: head = [1,2,3,4,5,6]
        //Output: [4,5,6]
        //Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

        ListNode n00 = new ListNode(1);
        ListNode n01 = new ListNode(2);
        ListNode n02 = new ListNode(3);
        ListNode n03 = new ListNode(4);
        ListNode n04 = new ListNode(5);

        n00.next = n01;
        n01.next = n02;
        n02.next = n03;
        n03.next = n04;
        n04.next = null;

        ListNode head0 = n00;

        System.out.println(middleNode(head0)); // [3,4,5]


        ListNode n10 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(3);
        ListNode n13 = new ListNode(4);
        ListNode n14 = new ListNode(5);
        ListNode n15 = new ListNode(6);

        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = null;

        ListNode head1 = n10;

        System.out.println(middleNode(head1)); // [4,5,6]
    }

    public static ListNode middleNode(ListNode head) {
        // fast and slow pointer should work because their difference in speed is exactly 2 times. so for example the
        // whole linkedlist size is 6, then fast will reach the end by the time the slow one will reach the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // remember this
        return fast.next != null ? slow.next : slow;
    }

    /*public static ListNode middleNode(ListNode head) {
        // my 'first instinct' solution

        // again, fast and slow? seems weird honestly. for me personally it would make more sense to do it using hashmap or array or list
        // however, would it be space-problematic? there is another problem - otherwise I can't go back through. unless
        // of course I have another pointer that would go through using some sort of counter
        List<ListNode> list = new ArrayList<>();

        ListNode pointer = head;
        while (pointer.next != null) {
            list.add(pointer);
            pointer = pointer.next;
        }
        list.add(pointer);

        // now go get the middle
        int middle = list.size() / 2;

        return list.get(middle);
    }*/

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
