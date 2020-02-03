package com.study.leetCode.stack.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ValidParenthesesSolution {
    private final Map<Character, Character> matchMap = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };


    /**
     * 左括号->push
     * 右括号->peek
     * matchMap->pop
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        boolean result = true;
        char currentChar;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (!matchMap.containsKey(currentChar)) {
                //当前括号是左括号，进行压栈
                stack.push(currentChar);
            } else if (stack.empty() || stack.pop() != matchMap.get(currentChar)) {
                //当前括号是左括号，需要与栈顶括号进行匹配
                //栈中没有元素与之匹配或者栈顶元素不匹配，弹出栈顶元素，出错
                result = false;
                break;
            }
        }
        if (result) {
            result = stack.empty();
        }
        return result;
    }

}
