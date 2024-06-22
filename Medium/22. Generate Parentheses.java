// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/description/
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

// Constraints:

// 1 <= n <= 8

// Solution : 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        combination(result, "", 0, 0, n);
        return result;
    }

    public static void combination(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            combination(result, current + '(', open + 1, close, max);
        }
        if (close < open) {
            combination(result, current + ')', open, close + 1, max);
        }
    }
}