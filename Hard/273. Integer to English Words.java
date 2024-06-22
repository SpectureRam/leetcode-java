// 273. Integer to English Words
// https://leetcode.com/problems/integer-to-english-words/description/
// Convert a non-negative integer num to its English words representation.

// Example 1:

// Input: num = 123
// Output: "One Hundred Twenty Three"
// Example 2:

// Input: num = 12345
// Output: "Twelve Thousand Three Hundred Forty Five"
// Example 3:

// Input: num = 1234567
// Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

// Constraints:

// 0 <= num <= 231 - 1

// Solution : 

class Solution {
    private final String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20) {
            sb.append(belowTwenty[num]);
        } else if (num < 100) {
            sb.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return sb.toString().trim();
    }
}