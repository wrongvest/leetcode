package com.wrongme.daily.w20211222;

import com.wrongme.basic.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382. 链表随机节点
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    Random random = new Random(20220116);
    public Solution(ListNode head) {
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
