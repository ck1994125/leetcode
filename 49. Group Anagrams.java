/*
题目：
49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

分析：
    时间复杂度：O(n)
    使用HashMap。
    对字符串排序，然后使用map存储，最后将map转换为list。
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int size = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        for( String s : strs ){
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if( !map.containsKey(key) ){
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(key , value);
            }
            else{
                map.get(key).add(s);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}
