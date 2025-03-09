package course1.unit5.practice1;

/**
 * Your task is to create a Java function named findNextPeak which will determine 
 * the next higher peak in a given 2D array. The function will receive 
 * a 2D array (int[][]) representing a trail map, as well as the current 
 * position on the map (row and column indices). The next higher peak is 
 * the adjacent cell with a higher elevation (value) than the current cell. 
 * From the current position, the function should check all adjacent cells 
 * (up, down, left, right) and return the coordinates of the next cell that 
 * contains a higher value signifying the next higher peak. 
 * If there are no adjacent cells with a higher value, the function 
 * should return the hiker's current coordinates.
 */

import java.util.Arrays;

class Practice3 {
    
    // TODO: Implement the findNextPeak function
    static int[] findNextPeak(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1}
        }; // Define directions
        
        int currentHeight = matrix[row][col];
        
        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                continue;
            }
            if (matrix[r][c] > currentHeight) { // Check if the new position is higher than the current
                return new int[]{r, c}; // Return coordinates of the next higher peak
            }
        }
        
        return new int[]{row, col}; // No higher peak, stay in place
    }
    
    public static void main(String[] args) {
        int[][] trailMap = {
            {3, 5, 6},
            {4, 7, 8},
            {1, 2, 9}
        };
        
        int[] startPosition = {1, 1}; // Starting elevation
        int[] nextPeak = findNextPeak(trailMap, startPosition[0], startPosition[1]);
        
        System.out.println("Next peak at coordinates: " + Arrays.toString(nextPeak));
    }
}