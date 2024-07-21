// 118. Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/description/
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]

// Constraints:

// 1 <= numRows <= 30

// Solution : 

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        List<Integer> prevRow = row;
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            currentRow.add(1);
            result.add(new ArrayList<>(currentRow));
            prevRow = currentRow;
        }
        return result;
    }
}