/*
题目：
17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

分析：
    时间复杂度：O(4^n)
    思路依然是回溯。
*/
// recursive solution
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combination(res, digits, map, 0, "");
        return res;
    }

    private void combination(LinkedList<String> res, String s, String[] map, int index, String tmp) {
        if (index == s.length()) {
            res.add(tmp);
            return;
        }

        for (int i = 0; i < map[s.charAt(index) - '0'].length(); i++) {
            combination(res, s, map, index+1, tmp+map[s.charAt(index) - '0'].charAt(i));
        }
        return;
    }
}

// iterative solution
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int value = digits.charAt(i) - '0';//Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String start = res.remove();
                for (char next : map[value].toCharArray()) {
                    res.add(start + next);
                }
            }
        }
        return res;
    }
}
