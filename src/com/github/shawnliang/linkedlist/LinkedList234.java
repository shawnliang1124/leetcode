package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;
import java.util.Stack;

/**
 * Description :
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * .
 * @url https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author : Phoebe
 * @date : Created in 2020/4/26
 */
public class LinkedList234 {

  /**
   * 使用快慢指针法进行移动
   * 快指针走两步，慢指针走一步
   * 当快指针到达尾部的时候，慢指针一定到达中间
   * 之后将慢指针之后的节点进行反转， 和慢指针前半部分的进行比较
   * @param head  头指针
   * @return  。
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode halfNode = fastSlow(head);
    ListNode reverseNode = reverseList(halfNode);
    boolean result = false;
    while (reverseNode != null && head.next != null) {
      if(head.val == reverseNode.val) {
        head = head.next;
        reverseNode = reverseNode.next;
        result = true;
      } else {
        return false;
      }
    }
      return result;
  }

  /**
   * 快慢指针获得中间节点
   * @param head  头结点
   * @return  快慢指针获得中间节点
   */
  private ListNode fastSlow(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
   }

  /**
   * 反转链表
   * @param head 节点
   * @return  反转链表.
   */
   private ListNode reverseList(ListNode head) {
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

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode head2 = new ListNode(2);
    head.next = head2;
    LinkedList234 linkedList234 = new LinkedList234();
    boolean palindrome = linkedList234.isPalindrome(head);
    System.out.println(palindrome);
  }

}
