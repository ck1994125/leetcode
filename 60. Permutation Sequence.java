/*
题目：
60. Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

分析：
    时间复杂度：O(n)
    假设长度为n，求全排列的第k个排列（a1,a2,a3,...,an）：
    当第一位确定时，其全排列个数为(n-1)!,
    所以，对于第k个全排列的第1位 a1=k/(n-1)!;
    则对于剩下的n-2位，也是求第k个排列，且新的k为 k=k%(n-1)!，所以 a2 = k/(n-2)!;
    以此类推。
*/
class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for( int i=1 ; i<=n ; i++ ){
            sum *= i;
            factorial[i] = sum;
        }

        for(int i=1; i<=n; i++){
            numbers.add(i);
        }

        k--;

        for(int i = n; i > 0; i--){
            int index = k/factorial[i-1];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k = k%factorial[i-1];
        }

        return String.valueOf(sb);
    }
}
