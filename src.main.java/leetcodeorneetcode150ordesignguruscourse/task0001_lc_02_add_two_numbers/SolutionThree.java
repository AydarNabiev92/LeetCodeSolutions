package leetcodeorneetcode150ordesignguruscourse.task0001_lc_02_add_two_numbers;

import java.math.BigInteger;

public class SolutionThree {
    // https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        // Explanation: 342 + 465 = 807.

//        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
//        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        System.out.println("ListNode 1 - " + listNode1);
        System.out.println("ListNode 2 - " + listNode2);
        System.out.println("Resulting ListNode" + addTwoNumbers(listNode1, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Create multi-digit number 1 from the list 1 instead of working with list 1.
        String numberOneStr = getInvertedNumberFromListNode(l1, new StringBuilder("")).reverse().toString();
        System.out.println("Multidigit number 1 - " + numberOneStr);

        // 2. Create multi-digit number 2 from the list 2 instead of working with list 2.
        String numberTwoStr = getInvertedNumberFromListNode(l2, new StringBuilder("")).reverse().toString();
        System.out.println("Multidigit number 2 - " + numberTwoStr);

        // 3. Add them using a + operator.
        // I have to use BigInteger (max 9 223 372 036 854 775 807) for the number limitation of Integer/Long
        BigInteger sum = new BigInteger(numberOneStr).add(new BigInteger(numberTwoStr));
        System.out.println("Resulting sum (needs to be inverted) - " + sum);

        // 4 Create ListNode from the resulting multi-digit number of the sum.
        // Building the resulting ListNode - f.e. from  807 to ListNodeListNode{val=7, next=ListNode{val=0, next=ListNode{val=8, next=null}}}
        String sumStr = new StringBuilder(String.valueOf(sum)).reverse().toString();
        ListNode previousNode = null;
        ListNode sumNode = null;
        for (int i = sumStr.length() - 1; i >= 0; i--) {
            Character character = sumStr.charAt(i);
            Integer integer = Integer.valueOf(character.toString());
            ListNode currentListNode = new ListNode(integer, previousNode);

            if (i == 0) {
                sumNode = currentListNode;
            }
            previousNode = currentListNode;

        }

        return sumNode;
    }

    public static StringBuilder getInvertedNumberFromListNode(ListNode listNode, StringBuilder result) {
        // Add contents of current node
        result.append(listNode.val);
        if (listNode.next != null) {
            // Add content of following nodes (recursion)
            result = getInvertedNumberFromListNode(listNode.next, result);
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
