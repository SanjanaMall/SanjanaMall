
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        // Dummy node
        ListNode newList = new ListNode(0);
        ListNode head = newList;

        // Merge while both lists have nodes
        while (temp1 != null && temp2 != null) {

            if (temp1.val <= temp2.val) {
                newList.next = temp1;
                temp1 = temp1.next;
            } 
            else {
                newList.next = temp2;
                temp2 = temp2.next;
            }

            newList = newList.next;
        }

        // Add remaining nodes from list1
        while (temp1 != null) {
            newList.next = temp1;
            temp1 = temp1.next;
            newList = newList.next;
        }

        // Add remaining nodes from list2
        while (temp2 != null) {
            newList.next = temp2;
            temp2 = temp2.next;
            newList = newList.next;
        }

        return head.next;
    }
}

