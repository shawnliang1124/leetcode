package com.github.shawnliang.base;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:04
 * @contact 269882341@qq.com
 * @description
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 有参构造 传入数组，构建链表
     * @param arr 数组
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
           throw new RuntimeException("empty array is not allowed here");
        }
        this.val = arr[0];
        ListNode cur = this;
        // cycle array
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append("->");
            if (cur.next == null) {
                res.append("NULL");
            }
            cur = cur.next;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        ListNode listNode = new ListNode(array);
        System.out.println(listNode.toString());
    }
}
