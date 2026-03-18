//234.回文链表
//简单
//先找中点，再反转，后判断

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
    public boolean isPalindrome(ListNode head) {
        //链表为空
        if(head == null){
            return true;
        }

        //找中间
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //此时pre为最后一个元素

        ListNode left = head;
        ListNode right = pre;
        while(right != null){
            if(left.val == right.val){
                left = left.next;
                right = right.next;
            }else return false;
        }

        return true;
    }
}