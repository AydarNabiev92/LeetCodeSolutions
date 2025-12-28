package leetcodeorneetcode150ordesignguruscourse.task0037_lc_142_linked_list_cycle_second;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/start-of-linkedlist-cycle-medium
        // https://leetcode.com/problems/linked-list-cycle-ii/description/
        // Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
        //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
        // following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
        // is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
        //Do not modify the linked list.
        // Input: head = [3,2,0,-4], pos = 1
        //Output: tail connects to node index 1
        //Explanation: There is a cycle in the linked list, where tail connects to the second node.
        ListNode n0 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;   // ← this creates the cycle (pos = 1)

        ListNode head = n0;

        detectCycle(head); // [2,0,-4,...] mustn't output it (cycle!)
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // now the coolest part - we confirmed that we have a cycle, how do we then find where the start of the
                // cycle is? first off, we need to find the length of the cycle. we keep our slow pointer but then
                // with another pointer measure how many steps it took us to find it again. then what? LinkedList if it's
                // cyclic consists of two key parts - 'a' elements until cycle start and 'b' elements after cycle starts then
                // it's 'b' elements infinitely. if we know 'b' size then we can move one pointer from the start of the list
                // and another pointer at the 'b' start of the list, they will have to travel 'a' distance to meet, that
                // will inevitably point us at the cycle start. genius
                ListNode looper = slow.next;
                int counter = 1;
                while (looper != slow) {
                    looper = looper.next;
                    counter++;
                }
                // we found our a, now need to initialize two new pointer
                ListNode a = head;
                ListNode b = head;
                while (counter > 0) {
                    b = b.next;
                    counter--;
                }
                // when they meet - we found our loop point
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }

                return a;
            }
        }

        return null;
    }

    /*public static ListNode detectCycle(ListNode head) {
        // my solution, which is bad in terms of space
        if (head == null) {
            return null;
        }
        // how can fast and slow pointer help me out here? i can detect if there is a cycle, but finding where the problem
        // begins, that's the problem
        // could a combination of fast and slow pointer and map help me? map where key is node and value is number of times
        // it is met. after fast and slow met each other we look at the map

        ListNode pointer = head;
        Set<ListNode> set = new HashSet<>();
        while (pointer.next != null) {
            if (set.contains(pointer)) {
                return pointer;
            }
            set.add(pointer);
            pointer = pointer.next;
        }

        return null;
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
