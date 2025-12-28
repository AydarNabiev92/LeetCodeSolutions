package leetcodeorneetcode150ordesignguruscourse.task0039_lc_234_palindrome_linked_list;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-1-palindrome-linkedlist-medium
        // https://leetcode.com/problems/palindrome-linked-list/description/
        // Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
        // Example 1:
        // Input: head = [1,2,2,1]
        //Output: true
        //Example 2:
        // Input: head = [1,2]
        //Output: false
        //Constraints:
        //The number of nodes in the list is in the range [1, 105].
        //0 <= Node.val <= 9
        //Follow up: Could you do it in O(n) time and O(1) space?

        ListNode n00 = new ListNode(1);
        ListNode n01 = new ListNode(2);
        ListNode n02 = new ListNode(2);
        ListNode n03 = new ListNode(1);

        n00.next = n01;
        n01.next = n02;
        n02.next = n03;
        n03.next = null;

        ListNode head0 = n00;

        System.out.println(isPalindrome(head0)); // true


        ListNode n10 = new ListNode(1);
        ListNode n11 = new ListNode(2);

        n10.next = n11;
        n11.next = null;

        ListNode head1 = n10;

        System.out.println(isPalindrome(head1)); // false
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // first step - we find middle by using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
//        while (fast.next != null && fast.next.next != null) { // this doesn't reach half for slow pointer - overshoot
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // after finding middle we must reverse first or second half so we can go backwards
        // seems like second half is more right
        ListNode secondHalfReversed = reverse(slow);
        ListNode reverseItLaterToReturnListNodeToOriginalForm = secondHalfReversed;

        boolean result = true;
        // now let's compare left part and reversed right half
        while (secondHalfReversed != null) {
            if (secondHalfReversed.val != head.val) {
                result = false;
                break;
            }
            secondHalfReversed = secondHalfReversed.next;
            head = head.next;
        }

        reverse(reverseItLaterToReturnListNodeToOriginalForm);

        // demonstration
        /*System.out.println(head);
        ListNode firstHalf = reverse(head);
        System.out.println(firstHalf);*/

        return result;
    }

    private static ListNode reverse(ListNode listNode) {
        // [1, 2, 2, 1, null] -> [null, 1, 2, 2, 1]
        ListNode prev = null;
        while (listNode != null) {
            // swap 4 elements
            ListNode temp = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = temp;
        }

        return prev;
    }

    /*public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // how to apply slow and fast pointer tho?

        // let's do the first basic version of using list
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
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
