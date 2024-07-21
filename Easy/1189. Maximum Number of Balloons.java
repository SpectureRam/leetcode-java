// 1189. Maximum Number of Balloons
// https://leetcode.com/problems/maximum-number-of-balloons/description/
// Hint
// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

// You can use each character in text at most once. Return the maximum number of instances that can be formed.

// Example 1:

// Input: text = "nlaebolko"
// Output: 1
// Example 2:

// Input: text = "loonbalxballpoon"
// Output: 2
// Example 3:

// Input: text = "leetcode"
// Output: 0

// Constraints:

// 1 <= text.length <= 104
// text consists of lower case English letters only.

// Solution : 

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balloons = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b' -> balloons[0]++;
                case 'a' -> balloons[1]++;
                case 'l' -> balloons[2]++;
                case 'o' -> balloons[3]++;
                case 'n' -> balloons[4]++;
            }
        }
        balloons[2] /= 2;
        balloons[3] /= 2;
        int count = balloons[0];
        for (int i : balloons) {
            count = Math.min(i, count);
        }
        return count;
    }
}