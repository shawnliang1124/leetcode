package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:04
 * @contact 269882341@qq.com
 * @description  83. 删除排序链表中的重复元素
 * @url  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class LinkedList83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

}
