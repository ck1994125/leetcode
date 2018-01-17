/*
题目：
19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

分析：
    时间复杂度：O(n)
    去掉倒数第n个数，则要求指针遍历到倒数第n-1个数的位置，然后在进行删除操作，即为正数第m-n，假设m为总数；
    那么第一个指针先从头遍历n+1个数，然后第二个指针从头开始遍历，直到第一个指针遍历到结尾
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode first = start, second = start;

        for ( int i = 0; i <= n; i++ ) {
            first = first.next;
        }

        while ( first != null ) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return start.next;
    }
}
