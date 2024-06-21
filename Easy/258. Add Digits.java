// 258. Add Digits
// https://leetcode.com/problems/add-digits/description/

// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

// Example 1:

// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.
// Example 2:

// Input: num = 0
// Output: 0

// Constraints:

// 0 <= num <= 231 - 1

// Follow up: Could you do it without any loop/recursion in O(1) runtime?

// Solution : 

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }
}

// The digital root of a number is the single digit obtained by iteratively
// summing the digits of the number until a single digit is obtained. There's a
// formula to find the digital root directly: digital root = 1+(n−1) % 9
// This works because of the properties of numbers in modular arithmetic.
// Specifically, for a non-zero number, the digital root is equivalent to the
// number modulo 9, except when the number itself is a multiple of 9 (in which
// case the digital root is 9).