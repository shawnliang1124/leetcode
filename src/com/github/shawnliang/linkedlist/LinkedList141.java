package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:07
 * @contact 269882341@qq.com
 * @description 141. 环形链表
 * @url https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedList141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            //一次走两步
            fast = fast.next.next;
            //一次走一步
            slow = slow.next;
        }
        return true;

    }
}
