package arrays;

public class Arrays2D {
	    public static int[] reverseTraverse(int[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int[] output = new int[rows * cols];
	        int index = 0;

//	        for (int row = rows - 1; row >= 0; --row) {
//	            for (int col = cols - 1; col >= 0; --col) {
//	                output[index++] = matrix[row][col];
//	            }
//	        }
	        for(int col = cols - 1; col >= 0; col--) {
	        	for(int row = rows -1; row >= 0; --row) {
	        		output[index++] = matrix[row][col];
	        	}
	        }

	        return output;
	    }

	    public static void main(String[] args) {
	        int[][] matrix = {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12}
	        };

	        int[] result = reverseTraverse(matrix);
	        for (int num : result) {
	            System.out.print(num + " ");
	        }
	    }
	}
