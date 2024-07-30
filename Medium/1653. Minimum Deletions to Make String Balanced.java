// 1653. Minimum Deletions to Make String Balanced
// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
// You are given a string s consisting only of characters 'a' and 'b'​​​​.

// You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

// Return the minimum number of deletions needed to make s balanced.

// Example 1:

// Input: s = "aababbab"
// Output: 2
// Explanation: You can either:
// Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
// Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
// Example 2:

// Input: s = "bbaaaaabb"
// Output: 2
// Explanation: The only solution is to delete the first two characters.

// Constraints:

// 1 <= s.length <= 105
// s[i] is 'a' or 'b'​​.

// Solution : 

class Solution {
    public int minimumDeletions(String s) {
        int totalA = 0;
        int totalB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            } else {
                totalB++;
            }
        }
        int prefixA = 0;
        int prefixB = 0;
        int minDeletions = Math.min(totalA, totalB);
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                prefixA++;
            } else {
                prefixB++;
            }
            int deletions = prefixB + (totalA - prefixA);
            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}