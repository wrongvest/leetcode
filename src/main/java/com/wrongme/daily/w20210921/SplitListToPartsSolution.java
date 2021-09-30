package com.wrongme.daily.w20210921;

import com.wrongme.basic.ListNode;

public class SplitListToPartsSolution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode[] ans = new ListNode[k];
        // 分隔为 k 个连续的部分,每部分的长度m
        int m = length / k;
        for (int i = 0, sum = 1; i < k; i++, sum++) {
            ans[i] = head;
            temp = head;
            int u = m;
            while (m-- > 1 && ++sum > 0) {
                temp = temp.next;
            }
            int remain = k - i - 1;
            if (m != 0 && sum + m * remain < length && ++sum > 0) {
                temp = temp.next;
            }
            head = temp!=null?temp.next:null;
            if (temp != null) {
                temp.next = null;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SplitListToPartsSolution solution = new SplitListToPartsSolution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        solution.splitListToParts(head, 5);
    }
}
