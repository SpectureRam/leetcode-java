// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/description/
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
// palindrome
//  that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

// Constraints:

// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

// Solution : 

class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[58];
        for (char ch : s.toCharArray()) {
            freq[ch - 'A']++;
        }
        int res = 0;
        for (int num : freq) {
            if (num % 2 == 0) {
                res += num;
            } else {
                res += num - 1;
            }
        }
        return res == s.length() ? res : res + 1;
    }
}