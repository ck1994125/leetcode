/*
题目：
83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

分析：
    时间复杂度：O(n)
    空间复杂度：O(1)
    注意删除节点即可。
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if( head==null || head.next==null )return head;
        ListNode pre=head;
        ListNode cur=pre.next;
        while( cur!=null ){
            if( pre.val == cur.val ){
                pre.next=cur.next;
                cur.next=null; // 注意删除的节点
                cur=pre.next;
            }
            else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
