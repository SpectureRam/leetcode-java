// 763. Partition Labels
// https://leetcode.com/problems/partition-labels/description/
// Hint
// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Example 1:

// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
// Example 2:

// Input: s = "eccbbbbdec"
// Output: [10]

// Constraints:

// 1 <= s.length <= 500
// s consists of lowercase English letters.

// Solution : 

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if (max == i) {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}