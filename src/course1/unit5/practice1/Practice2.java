package course1.unit5.practice1;

/**
 * In your latest digital mountain exploration project, you have written a program
 * in Java to identify the highest peak reachable from a starting point on a mountain.
 * However, it appears there is an issue with the code, as it is not always 
 * returning the correct altitude of the highest peak reachable. 
 * Can you spot and fix the issue to ensure the digital exploration is successful?
 */

class Practice2 {

    public static int findPeakAltitude(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        int altitude = grid[startRow][startCol];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for (int[] dir : directions) {
            int newRow = startRow + dir[0];
            int newCol = startCol + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] > altitude) {
                altitude = grid[newRow][newCol];
            }
        }
        return altitude;
    }

    public static void main(String[] args) {
        int[][] mountain = {
            {1, 2, 3},
            {2, 5, 7},
            {4, 6, 9}
        };

        System.out.println(findPeakAltitude(mountain, 0, 1));  // Should print the altitude of the highest peak reachable
    }
}