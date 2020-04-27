package com.github.shawnliang.linkedlist;

import com.github.shawnliang.base.ListNode;

/**
 * Description :
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。.
 * @url https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * @author : Phoebe
 * @date : Created in 2020/4/23
 * 这道题的数组法就不讲了，时间复杂度是o(n)的同时，空间复杂度还要o(n)
 * 主要讲的是双指针移动法,画个图，A指针从k的链表位置开始出发，B指针从头出发
 * 当A指针到达终点的时候，A走了N步伐， 实际上B指针到的位置就是链表长度-N,就是倒数第K个的位置
 */
public class LinkedListMianshi0202 {

  public int kthToLast(ListNode head, int k) {
    if (head == null) {
      return 0;
    }
    ListNode cur = head;
    for (int i = 0; i < k; i++) {
      cur = cur.next;
    }
    while (cur != null) {
      cur = cur.next;
      head = head.next;
    }
    return head.val;
  }
}
