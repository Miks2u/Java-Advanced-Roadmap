//203.移除链表元素
//简单

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
    public ListNode removeElements(ListNode head, int val) {
        //创建虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;

        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }

        }
        return dummy.next;
    }
}