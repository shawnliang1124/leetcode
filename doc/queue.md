### 队列解题思路   

#### 前言  
首先，我们要关注队列的数据结构特点是： 

先进先出，也就是说像我们排队一样，增加是加到尾部去，这个过程也叫做<font color="red">入队</font>；删除是从头部开始删除，这个操作也叫做<font color="red">出队</font> 


#### 一、 Queue933   


##### 1.1题目描述：   
```
写一个 RecentCounter 类来计算最近的请求。

它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。

返回从 3000 毫秒前到现在的 ping 数。

任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。

保证每次对 ping 的调用都使用比之前更大的 t 值。

 

示例：

输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
输出：[null,1,2,3,3]


```  

说实话，这个题目看了我半天真心是没看懂。。。后面是看了某个评论才稍微看懂一丢丢的。   


```
JAVA 实现： 利用队列(FIFO, 先进先出)
进行实现。题目说的是，在时间点 t 进行一次 ping
操作，加上之前在 [t-3000, t] 范围内的 ping
操作的次数，并将次数返回。例如，例子中第一次
ping 的 t = 1， 返回 1；第二次 ping 的 t = 100, 第一次 ping 的时间点 1 在本次允许范围
[100-3000, 100] 之内，所以返回2；第三次 ping
时，前两次的 ping 都在允许范围[3000-3000, 3000]
之内，所以返回 3；第四次 ping 时，第一次 ping
的 t = 1 不在允许范围[3002-3000, 3000]
之内，所以返回 3。
```  


##### 1.2解题思路   

这里利用队列的数据结构，先进先出。每次输入一个时间点t，都会和队列的头元素进行比较，如果t-3000大于队列的头元素，则将头元素进行移除，然后到下一个头元素，再进行相同的判断，如此循环(使用while循环)，因为时间是依次递增的，假如队列的头元素满足t-3000 <= 头元素的条件，那么队列后面的元素也是必定满足这个t-3000的条件的，最后，再将t添加到队尾，并且返回队列的长度即可。   


##### 1.3 代码实现   

```
class RecentCounter {

  
    Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
      if(t < 0){
          throw new IllegalArgumentException("t is not illegal..");
      }
      while (!queue.isEmpty()){
          if(t - 3000 > queue.peek()){
              queue.poll();
          }else{
              break;
          }
      }
      queue.add(t);
      return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```
