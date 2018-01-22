/*
题目：
92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

分析：
    时间复杂度：O(n)
    pre和head两个指针分别记录本组k个节点的前一个节点，当前k个节点翻转后的尾部。
    pre.next指向本组k个节点的头结点，head.next指向下一组节点。
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode pre = start;

        for (int i = 1; i < n; i++) {
            if (i < m) {
                pre = pre.next;
                head = head.next;
                continue;
            }
            ListNode next = head.next.next;
            head.next.next = pre.next;
            pre.next = head.next;
            head.next = next;
        }
        return start.next;
    }
}
