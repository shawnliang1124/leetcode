### 链表解题思路  

#### 前言  


#### 一、LinkedList83  
##### 1.1  删除排序链表中的重复元素(https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)  

##### 1.2题目描述 
```
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
```

##### 1.3 题目分析  
这个题难度不大，和我上面实现删除链表的逻辑实际上是一样的，目的就是找到对应的下标的元素，进行删除就好，删除的逻辑就是去除元素的引用，找到删除的元素delNode,它的next设置为null即可。  


##### 1.4解题方法  
```

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
```   

***

#### 二、LinkedList141  


2.1 题目要求，给定一个链表，判断链表中是否有环（https://leetcode-cn.com/problems/linked-list-cycle/）  


2.2 题目要求如下：  

```
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。


 

进阶：

你能用 O(1)（即，常量）内存解决此问题吗？



```


2.3 解决思路  

- 说实话，在拿到这个题目的时候，我是没有什么思路的~可能本人太菜了。  


不过后面的解决思路还是想出来了，主要有两种方式：  


A.把链表的元素放在HashSet里面，如果在HashSet中发现有值，证明就是环形链表。   
```
  /**
     * 判断链表是否有环
     * 方法1，使用HashSet来实现，将元素存储在Set集合里面，如果遍历完链表在集合中
     * 发现重复的元素，就认为是环形
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null){
            if(listNodes.contains(head)){
                return true;
            }else{
                listNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

```

B.使用快慢指针~这个逻辑是利用龟兔赛跑的道理~文字不好表示，用代码来解释或者比较直接。    


```
 /**
     * 使用快慢指针实现空间复杂度o(1)算法
     * 类似于龟兔赛跑的故事，无论如何，
     * 兔子(快指针)一定比龟(慢指针)快，
     * 一定能够追上乌龟，假设追到乌龟，就是碰到了以前兔子自己走过的地方，
     * 就是所谓的环形链表
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
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

```