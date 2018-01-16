/*
题目：
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

分析：
    时间复杂度：O(n)
    栈操作
*/
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else{
                if (stack.empty()) {
                    return false;
                }
                if (s.charAt(i) == ')') {
                    char c = stack.pop();
                    if (c != '(') {
                        return false;
                    }
                }
                else if (s.charAt(i) == ']') {
                    char c = stack.pop();
                    if (c != '[') {
                        return false;
                    }
                }
                else if (s.charAt(i) == '}') {
                    char c = stack.pop();
                    if (c != '{') {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }

        }
        if (stack.empty()) {
            return true;
        }
        else{
            return false;
        }
    }
}
