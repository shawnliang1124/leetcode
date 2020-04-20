package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/4/2 8:39
 * @contact 269882341@qq.com
 * @description 删除链表中的节点
 * @urlhttps://leetcode-cn.com/problems/delete-node-in-a-linked-list/ 使用虚拟头节点法删除
 */
public class LinkedList237 {
  class Solution {

    private ListNode listNode;

    public void deleteNode(ListNode node) {
      // 虚拟头节点
      ListNode dummyHead = new ListNode(-1);
      dummyHead.next = this.listNode;

      ListNode prev = dummyHead;
      ListNode cur = listNode;
      while (cur != null) {
        if (cur.val == node.val) {
            prev.next = cur.next;
            break;
        }
        prev = cur;
        cur = cur.next;
      }

    }
  }


}
