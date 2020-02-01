package com.github.shawnliang.stack;

import java.util.Stack;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2020/2/1 12:11
 * @contact 269882341@qq.com
 * @description 1047. 删除字符串中的所有相邻重复项
 * @url https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class Stack1047 {

    public String removeDuplicates(String s) {
        if(s.length() > 2000){

        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() !=c){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
