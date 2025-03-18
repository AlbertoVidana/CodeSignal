package web.codesignal;


public class Solution {
    public static int[] columnTraverse(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String direction = "up";
        int row = rows - 1;
        int col = cols - 1;
        int[] output = new int[rows * cols];
        int index = 0;

        while (index < rows * cols) {
            output[index++] = matrix[row][col];

            if (direction.equals("up")) {
                if (row - 1 < 0) {
                    direction = "down";
                    col -= 1;
                } else {
                    row -= 1;
                }
            } else {
                if (row + 1 == rows) {
                    direction = "up";
                    col -= 1;
                } else {
                    row += 1;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = {
        		{1, 3, 5, 7},
        	    {2, 4, 6, 8},
        	    {9, 11, 13, 15}
        };

        int[] result = columnTraverse(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}