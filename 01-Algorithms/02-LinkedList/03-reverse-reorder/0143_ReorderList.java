//143.重排链表
//中等

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
    public void reorderList(ListNode head) {
        //找中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }

        //中点为slow
        //开始反转
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //开始重新排列
        ListNode p1 = head;
        ListNode p2 = pre;
        while(p2.next != null){
            ListNode p11 = p1.next;
            ListNode p22 = p2.next;

            p1.next = p2;
            p2.next = p11;

            p1 = p11;
            p2 = p22;
        }
    }
}