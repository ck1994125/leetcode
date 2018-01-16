/*
题目：
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

分析：
    时间复杂度：O(2^n)
    回溯，使用left和right分别记录需要添加的左括号和右括号的个数，根据两数的比较来判断本次需要插入的括号类型。
    注意：可以直接使用String类型，不需要使用StringBuilder。
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, new StringBuilder(), n, n);
        return res;
    }

    private void generate(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            String s = sb.toString();
            res.add(s);
            return;
        }
        if (left == 0 && right != 0) {
            sb.append(")");
            generate( res, sb, left, right-1);
        }
        else if (left == right){
            sb.append("(");
            generate( res, sb, left-1, right);
        }
        else {
            sb.append("(");
            generate( res, sb, left-1, right);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            generate( res, sb, left, right-1);
        }
        sb.deleteCharAt(sb.length()-1);
        return;
    }
}

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
