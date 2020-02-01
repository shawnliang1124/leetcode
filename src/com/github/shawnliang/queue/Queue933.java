package com.github.shawnliang.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:12
 * @contact 269882341@qq.com
 * @description 933. 最近的请求次数
 * @url https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class Queue933 {


    Queue<Integer> queue = new LinkedList<>();



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
