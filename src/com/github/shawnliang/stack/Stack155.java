package com.github.shawnliang.stack;

import java.util.Stack;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:10
 * @contact 269882341@qq.com
 * @description 155. 最小栈
 * @url https://leetcode-cn.com/problems/min-stack/submissions/
 */
public class Stack155 {

    private Stack<Integer> helper;
    private Stack<Integer> data;

    public Stack155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        //helper辅助栈为空或者helper辅助栈的栈顶大于x的话，就把x加入helper中
        if(helper.isEmpty() || helper.peek() > x){
            helper.push(x);
        }else{
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if(data.isEmpty() || helper.isEmpty()){
            throw new RuntimeException("栈顶为空");
        }
        data.pop();
        helper.pop();

    }

    public int top() {
        return data.isEmpty()?0:data.peek();
    }

    public int getMin() {
        return helper.isEmpty()?0:helper.peek();
    }
}
