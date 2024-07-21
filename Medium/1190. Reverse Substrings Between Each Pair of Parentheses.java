// 1190. Reverse Substrings Between Each Pair of Parentheses
// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
// Hint
// You are given a string s that consists of lower case English letters and brackets.

// Reverse the strings in each pair of matching parentheses, starting from the innermost one.

// Your result should not contain any brackets.

 

// Example 1:

// Input: s = "(abcd)"
// Output: "dcba"
// Example 2:

// Input: s = "(u(love)i)"
// Output: "iloveu"
// Explanation: The substring "love" is reversed first, then the whole string is reversed.
// Example 3:

// Input: s = "(ed(et(oc))el)"
// Output: "leetcode"
// Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

// Constraints:

// 1 <= s.length <= 2000
// s only contains lower case English characters and parentheses.
// It is guaranteed that all parentheses are balanced.

// Solution : 

class Solution {
    public int i = 0;
    public String reverseParentheses(String s) {
        char arr[] = s.toCharArray();
        return helper(arr);
    }
    public String helper(char[] arr){
        StringBuilder sb = new StringBuilder();
        while(i < arr.length){
            if(arr[i] == ')'){
                i++;
                return sb.reverse().toString();
            }
            else if(arr[i] == '('){
                i++;
                String str = helper(arr);
                sb.append(str);
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }
        return sb.toString();
    }
}