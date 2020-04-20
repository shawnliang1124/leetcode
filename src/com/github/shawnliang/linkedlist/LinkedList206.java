package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :   定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。.
 * @url https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author : Phoebe
 * @date : Created in 2020/4/6
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 实现方法，指针引用位置交换
 *
 */
public class LinkedList206 {

  /**
   * 反转单向链表的思路，头结点移动法
    * @param head 头结点
   * @return  .
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    return prev;
  }


  /**
   * 反转单向链表的思路，递归
   * @param head 头结点
   * @return  .
   */
  public static ListNode reverseList2(ListNode head) {
    // 先找到跳出链表的条件
    if (head == null || head.next == null) {
        return head;
    }

    //
    ListNode cur = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    System.out.println("cur is " + cur);
    return cur;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2= new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;

    LinkedList206.reverseList2(listNode1);





  }

}
