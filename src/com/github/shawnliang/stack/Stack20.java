package com.github.shawnliang.stack;

import java.util.Stack;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:08
 * @contact 269882341@qq.com
 * @description 20.有效的括号
 * @url https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Stack20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('|| c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char stackTop = stack.pop();
                if(stackTop=='(' && c != ')'){
                    return false;
                }
                if(stackTop=='{' && c != '}'){
                    return false;
                }
                if(stackTop == '[' && c!=']'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
