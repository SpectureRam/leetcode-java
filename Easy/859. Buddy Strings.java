// 859. Buddy Strings
// Easy
// Topics
// Companies
// Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

// Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

// For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

// Example 1:

// Input: s = "ab", goal = "ba"
// Output: true
// Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
// Example 2:

// Input: s = "ab", goal = "ab"
// Output: false
// Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
// Example 3:

// Input: s = "aa", goal = "aa"
// Output: true
// Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

// Constraints:

// 1 <= s.length, goal.length <= 2 * 104
// s and goal consist of lowercase letters.

// Solution : 

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char ch : s.toCharArray()) {
                set.add(ch);
            }
            if (set.size() < s.length()) {
                return true;
            } else {
                return false;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1))
                && s.charAt(list.get(1)) == goal.charAt(list.get(0))) {
            return true;
        } else {
            return false;
        }
    }
}