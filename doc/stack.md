### 栈解题思路  

#### 前言  
首先，我们要关注，栈的一个数据结构。  
栈是一个后进先出的数据结构，先进来的数据会在栈底部，后进来的数据是在栈顶，出来的顺序是先从栈顶出来，所以这是一个后进先出的过程。  

#### 一、 Stack20


**1.1题目详解**  

```
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```  


**1.2解决思路**  
使用栈这种数据结构，左边的括号入栈，并且把栈顶的元素和右边括号的元素进行比较了。  
如果匹配不成功，直接就返回false,否则继续进行字符串的循环，在结束循环之后，最后还要判断一下，栈中是否还存在元素，不存在才返回最终的结果。。  



```
import java.util.Stack;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/12/28 17:16
 * @contact 269882341@qq.com
 * @description 左括号入栈，右括号进行匹配
 */
public class Solution {

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

```  


#### 二、 Stack155

**2.1题目详解**  
```
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。


实例：  

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack

```   

**2.2 解决思路**  
栈的数据结构就不多提了，这里我直接用的JDK的java.util.Stack类，题目的目的是要在o(1)时间常数内检索到最小的元素的栈，无疑是牺牲空间换取时间的解决方式，这里考虑使用辅助栈即可（用于保存栈中的对应索引的最小的值），那么就是在push入栈的方法中要加一下判断，判断当前栈顶的值和将要入栈的x值，小的那个值就丢到辅助栈中。  

**2.3 代码**  

```
package com.github.shawnliang.stack;

import java.util.Stack;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/12/28 18:08
 * @contact 269882341@qq.com
 * @description 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    private Stack<Integer> data;

    private Stack<Integer> helper;


    public MinStack() {
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




    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(2);
        minStack.push(1);
        minStack.push(-3);
        System.out.println(minStack);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

```  


****  
#### 三、Stack1047
  
  
 **3.1 题目详解**   
 ```
 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。


实例：  
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb"  
由于两字母相邻且相同，这是此时唯一可以执行删
    除操作的重复项。之后我们得到字符串   "aaca"，其中又只有 "aa"  
可以执行重复项删除操作，所以最后的字符串为 "ca"

 ```   
 
 **3.2 解题思路**  
 利用栈的数据结构，遍历字符串，如果栈顶的元素和字符不相同，就压栈，如果相同，就出栈。最后再遍历一下栈，打印一下字符串就好了。   
 
 
 **3.3 代码**
 
 ```
 
 public class Solution2 {

    public String removeDuplicates(String s) {

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


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String result = solution2.removeDuplicates("accaba");
        System.out.println(result);
    }
}

 
 ```