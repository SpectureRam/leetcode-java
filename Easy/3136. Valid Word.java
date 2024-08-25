// 3136. Valid Word
// https://leetcode.com/problems/valid-word/description/
// Hint
// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.

// Return true if word is valid, otherwise, return false.

// Notes:

// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.

// Example 1:

// Input: word = "234Adas"

// Output: true

// Explanation:

// This word satisfies the conditions.

// Example 2:

// Input: word = "b3"

// Output: false

// Explanation:

// The length of this word is fewer than 3, and does not have a vowel.

// Example 3:

// Input: word = "a3$e"

// Output: false

// Explanation:

// This word contains a '$' character and does not have a consonant.

// Constraints:

// 1 <= word.length <= 20
// word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.

// Solution : 

class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        String vowel = "aeiouAEIOU";
        boolean hasVow = false, hasCon = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                if (vowel.indexOf(ch) != -1) {
                    hasVow = true;
                } else {
                    hasCon = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return hasVow && hasCon;
    }
}