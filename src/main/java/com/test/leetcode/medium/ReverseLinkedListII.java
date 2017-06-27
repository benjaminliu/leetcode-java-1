package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/6/26.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode node = sentinel;

        // move the "node" pointer in front of the m-th node
        for (int i = 1; i < m; ++i) {
            node = node.next;
        }

        // reverse nodes
        ListNode curr = node.next;
        for (int i = m; i < n; ++i) {
            ListNode temp = node.next;
            node.next = curr.next;
            curr.next = curr.next.next;
            node.next.next = temp;
        }

        return sentinel.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for(int i = 0; i < m - 1; i++){
            pre = cur;
            cur = cur.next;
        }

        ListNode last_no_reverse = pre;
        ListNode first_to_be_reversed = cur;

        for(int i = m; i <= n; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        last_no_reverse.next = pre;
        first_to_be_reversed.next = cur;

        return dummy.next;
    }
}