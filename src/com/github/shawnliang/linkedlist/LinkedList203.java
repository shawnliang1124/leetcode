package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/4 8:39
 * @contact 269882341@qq.com
 * @description 删除链表中等于给定值 val 的所有节点
 * @url https://leetcode-cn.com/problems/remove-linked-list-elements/ 使用虚拟头节点法删除
 */
public class LinkedList203 {


  class Solution {

    public ListNode removeElements(ListNode head, int val) {
      ListNode dummyHead = new ListNode(-1);
      dummyHead.next = head;

      ListNode prev = dummyHead;
      ListNode cur = head;
      while (cur != null) {
        if (cur.val == val) {
          prev.next = cur.next;
        } else {
          prev = cur;
        }
        cur = cur.next;
      }

      return dummyHead.next;
    }
  }

}
