package course1.unit5.practice1;

/**
 * Immerse yourself in the adventure of mountain trekking in a virtual world through coding. 
 * Your quest is to craft a Java function named pathTraverse that guides you 
 * through a matrix, always advancing to an adjacent cell with a higher value. 
 * Embark on this challenging journey with the provided starter code and fulfill t
 * he quest by completing the TODO blocks. Along the way, you will hone your 
 * skills in navigating two-dimensional arrays and maneuvering through them with precision. 
 * Set forth, code warrior, and tread carefully on this mountain trail!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Practice5 {

    // TODO: Define the pathTraverse function which takes a mountain matrix and the current position (row, column) as parameters.
    // The function should return an ArrayList of int arrays representing the coordinates of the path taken,
    // starting from the initial position and moving to each higher adjacent cell.
    static public List<Integer> pathTraverse(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols) {
            System.err.println("Invalid input");
            return new ArrayList<>();
        }
        
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1}
        };
        
        List<Integer> visited = new ArrayList<>();
        visited.add(grid[startRow][startCol]);
        
        while (true) {
            int currMax = -1;
            int nextRow = -1, nextCol = -1;
            
            for (int[] dir: directions) {
                int newRow = startRow + dir[0];
                int newCol = startCol + dir[1];
                
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }
                
                if (grid[newRow][newCol] > currMax) {
                    nextRow = newRow;
                    nextCol = newCol;
                    currMax = grid[newRow][newCol];
                }
            }
            
            if (currMax <= grid[startRow][startCol]) {
                break;
            }
            
            startRow = nextRow;
            startCol = nextCol;
            
            visited.add(currMax);
        }
        
        return visited;
    }

    public static void main(String[] args) {
        // TODO: Create a matrix named 'mountain' representing ascending values, akin to the increasing elevation while hiking up a mountain.
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // TODO: Set the starting position on the mountain using an array to store the row and column index.
        // TODO: Call the pathTraverse function to find the path from the starting point.
        List<Integer> res = pathTraverse(grid, 1, 1);
        // TODO: Output the coordinates of the path taken from the starting point.
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}