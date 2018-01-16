/*
题目：
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

分析：
    时间复杂度：O(n)
    链表操作，注意第一次时，链表头会变化，所以需要改变头。
    可以在头结点前新建一个节点，则首次操作时不需要改变头结点，返回新节点的下一节点即可。
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null && current.next != null) {
            next = current.next;
            // change head at first
            if (pre == null) {
                head = next;
            }
            else {
                pre.next = next;
            }
            //swap
            current.next = next.next;
            next.next = current;

            // change index
            pre = current;
            current = current.next;
        }

        return head;
    }
}
