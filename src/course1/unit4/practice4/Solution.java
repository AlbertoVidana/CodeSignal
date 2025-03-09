package course1.unit4.practice4;

public class Solution {
	    
	    public static boolean evaluateMove(char[][] board, int row, int col) {
	        // TODO: Check if a move to the given cell is possible; write a condition to check if the cell is empty.
	        // TODO: Check if at least one neighboring cell is empty (not diagonally).
	                if (board[row][col] == 'E') {
	                    if ((row > 0 && board[row - 1][col] == 'E') ||
	                        (row < board.length - 1 && board[row + 1][col] == 'E') ||
	                        (col > 0 && board[row][col - 1] == 'E') ||
	                        (col < board[0].length - 1 && board[row][col + 1] == 'E')) {
	                        return true;
	                }
	        }
	        return false; // Placeholder return statement
	    }

	    public static void main(String[] args) {
	        // Assuming a constant 2D array representing a board
	        char[][] board = {
	            {'P', 'E', 'E', 'P'},
	            {'E', 'P', 'E', 'P'},
	            {'P', 'E', 'P', 'P'},
	            {'P', 'E', 'P', 'E'}
	        };

	        // TODO: Write a loop or loops to find all valid move positions and display them.
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	                if (evaluateMove(board, i, j)) {
	                    System.out.println("(" + i + ", " + j + ")");                    
	                }
	            }
	        }
	    }
	}