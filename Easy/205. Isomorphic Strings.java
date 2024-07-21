// 205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/description/
// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true

// Constraints:

// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.

// Solution : 

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                if (map1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map1.put(s.charAt(i), t.charAt(i));
            }
            if (map2.containsKey(t.charAt(i))) {
                if (map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}