// 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/description/
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap  after raining.

// Example 1:

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

// Solution : 

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int left = 0, right = n - 1, ans = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = Math.max(maxLeft, height[left]);
                } else {
                    ans += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = Math.max(maxRight, height[right]);
                } else {
                    ans += maxRight - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}