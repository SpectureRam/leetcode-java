// 2815. Max Pair Sum in an Array
// https://leetcode.com/problems/max-pair-sum-in-an-array/
// Hint
// You are given an integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the largest digit in both numbers is equal.

// For example, 2373 is made up of three distinct digits: 2, 3, and 7, where 7 is the largest among them.

// Return the maximum sum or -1 if no such pair exists.

 

// Example 1:

// Input: nums = [112,131,411]

// Output: -1

// Explanation:

// Each numbers largest digit in order is [2,3,4].

// Example 2:

// Input: nums = [2536,1613,3366,162]

// Output: 5902

// Explanation:

// All the numbers have 6 as their largest digit, so the answer is 2536 + 3366 = 5902.

// Example 3:

// Input: nums = [51,71,17,24,42]

// Output: 88

// Explanation:

// Each number's largest digit in order is [5,7,7,4,4].

// So we have only two possible pairs, 71 + 17 = 88 and 24 + 42 = 66.

 

// Constraints:

// 2 <= nums.length <= 100
// 1 <= nums[i] <= 104

// Solution : 

class Solution {
    public int maxSum(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int num : nums){
            int largest = getLargestNum(num);
            map.putIfAbsent(largest,new ArrayList<>());
            List<Integer> list = map.get(largest);
            list.add(num);
        }
        int max = -1;
        for(List<Integer> list : map.values()){
            if(list.size() > 1){
                Collections.sort(list,Collections.reverseOrder());
                int currentSum = list.get(0) + list.get(1);
                max = Math.max(currentSum,max);
            }
        }
        return max;
    }
    public int getLargestNum(int num){
        int largest = 0;
        while(num > 0){
            largest = Math.max(largest,num % 10);
            num/=10;
        }
        return largest;
    }
}