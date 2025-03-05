package lear.couser.matrix.unit3.practice5;

public class TransposingMatrix2D {

    // TODO: Define a function 'transposeSeating' that takes a 2D array 'arrangement' as its parameter.
    static int[][] transposeSeating(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposeMatrix = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        
        return transposeMatrix;
    }

    public static void main(String[] args) {
        // Restaurant seating before transposition (rows)
        int[][] seatingBefore = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        // TODO: Call the 'transposeSeating' function with 'seatingBefore' and print the result to see the new seating arrangement.
        int[][] seatingAfter = transposeSeating(seatingBefore);
        
        for (int i = 0; i < seatingAfter.length; i++) {
            for (int j = 0; j < seatingAfter[i].length; j++) {
                System.out.print(seatingAfter[i][j] + " ");
            }
            System.out.println();
        }
    }
}