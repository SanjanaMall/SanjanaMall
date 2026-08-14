/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            // First and second nodes
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }
}