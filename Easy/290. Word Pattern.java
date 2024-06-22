// 290. Word Pattern
// https://leetcode.com/problems/word-pattern/description/
// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false
// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

// Constraints:

// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lowercase English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.

// Solution : 

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(ch, word);
            }
            if (wordToChar.containsKey(word)) {
                if (!wordToChar.get(word).equals(ch)) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }
        return true;
    }
}