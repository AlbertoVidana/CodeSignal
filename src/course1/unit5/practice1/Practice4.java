package course1.unit5.practice1;
/**
 * Now it's time to apply what you've learned about traversing through adjacent 
 * cells in a 2D array in Java. Similar to our previous example, you will create 
 * a function that makes a trek through a 2D array (int[][] grid) representing elevation levels. 
 * Starting from a specified point, your function should continue to move to the adjacent 
 * cell having a higher elevation. Fill in the missing parts to complete the function that 
 * determines the path of the hike.
 * 
 * 
class Solution {
    // The trekPath function should go here
    // TODO: Define the trekPath function that takes the elevationMap, startRow, and startCol as parameters.
    // TODO: Initialize the path with the starting position's elevation.
    // TODO: Implement the loop to find the path through higher elevations.

    public static void main(String[] args) {
        int[][] mountain = {
            {1, 2, 3},
            {2, 3, 4},
            {3, 5, 6}
        };
        Solution sol = new Solution();
        List<Integer> result = sol.trekPath(mountain, 1, 1);
        for (int height : result) {
            System.out.print(height + " ");
        }
    }
}
 */

import java.util.ArrayList;
import java.util.List;

class Practice4 {
    // The trekPath function should go here
    // TODO: Define the trekPath function that takes the elevationMap, startRow, and startCol as parameters.
    // TODO: Initialize the path with the starting position's elevation.
    // TODO: Implement the loop to find the path through higher elevations.
    public List<Integer> trekPath(int[][] matrix, int startRow, int startCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols) {
            return new ArrayList<Integer>();
        }
        int[][] directions = {
            {1, 0}, {-1, 0}, {0,-1}, {0, 1}
        };
        List<Integer> visited = new ArrayList<>();
        visited.add(matrix[startRow][startCol]);
    
        while (true) {
            int currMax = -1;
            int nextRow = -1, nextCol = -1;
            
            for (int[] dir : directions) {
                int newRow = startRow + dir[0];
                int newCol = startCol + dir[1];
                
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }
                
                if (matrix[newRow][newCol] > currMax) {
                    nextRow = newRow;
                    nextCol = newCol;
                    currMax = matrix[newRow][newCol];
                }
            }
            if (currMax <=  matrix[startRow][startCol]) {
                break;
            }
            
            startRow = nextRow;
            startCol = nextCol;
            
            visited.add(currMax);
        }
    
    return visited;
    }


    public static void main(String[] args) {
        int[][] mountain = {
            {1, 2, 3},
            {2, 3, 4},
            {3, 5, 6}
        };
        Practice4 sol = new Practice4();
        List<Integer> result = sol.trekPath(mountain, 1, 1);
        for (int height : result) {
            System.out.print(height + " ");
        }
    }
}