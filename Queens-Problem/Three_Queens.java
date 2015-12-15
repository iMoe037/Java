import java.io.*;
import java.util.*;
public class Three_Queens {
	//---------------------------------------------------------------------------------------------------
	public static int BOARD_SIZE; 
	public static int SQUARES;
	public static int LASTQ1; 
	public static int LASTQ2; 
	public static int LASTQ3; 
	public static int answers; 
	// Added the chess board with a whatever size the user chooses, added number of total squares and added last positions for Q1,Q2,Q3
	//---------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		System.out.printf(	"Welcome to the 3 Queens on a board problem!"+
							"\nPlease enter an integer N for a N X N Grid"+
							"\nThe Number has to be larger than three."+
							"\nAnd the program only takes a few seconds to run"+
							"\nSo if no answers were found in about 10 secs just exit"+
							"\nPlease enter an integer:"
				
						);
		BOARD_SIZE= keyboard.nextInt();
		SQUARES = BOARD_SIZE * BOARD_SIZE;
		LASTQ1 = (int) (Math.ceil(SQUARES/2)-2);
		LASTQ2 = SQUARES-1;
		LASTQ3 = SQUARES;
		boolean[] board = new boolean[SQUARES]; 
		for (int i = 0; i < board.length; board[i] = false, i++); 

		for (int q1 = 0; q1 < LASTQ1; board[q1] = false, q1++) {
			board[q1] = true;
			for (int q2 = q1 + 1; q2 < LASTQ2; board[q2] = false, q2++) {
				board[q2] = true; 
				for (int q3 = q2 + 1; q3 < LASTQ3; board[q3] = false, q3++) {
					board[q3] = true; 
					if (boardCovered(board)) 
						displayBoard(board);
				}
			}
		}

	}
	//initialized the values in the board, set the Queens at the beginning, and the board shows with a combo
	//---------------------------------------------------------------------------------------------------
	public static void displayBoard(boolean[] board) {
		for (int row = 0; row < BOARD_SIZE; row++) { 
			for (int i = 0; i <  BOARD_SIZE; i++) System.out.print("****" + (i == BOARD_SIZE-1? "*\n" : ""));
			for (int col = 0; col < BOARD_SIZE; col++) { 
				System.out.print("*" + (board[BOARD_SIZE*row+col]?" Q ":(squareCovered(board,row,col)? " x " : "   ")) + (col == BOARD_SIZE-1? "*\n" : ""));
			}
		}
		for (int i = 0; i <  BOARD_SIZE; i++) System.out.print("****" + (i == BOARD_SIZE-1? "*\n" : ""));
		System.out.println(++answers + "\n");
	}
	// Displays board and keeps count of the answers. On the display Queens are shown as a Q and X's are the spots they attack
	//---------------------------------------------------------------------------------------------------
	public static boolean boardCovered(boolean[] board) {
		for (int row = 0; row < BOARD_SIZE; row++) 
			for (int col = 0; col < BOARD_SIZE; col++)
				if (!squareCovered (board,row,col)) return false; 
		return true; 
	}
	// Returns if the board is completely covered. 2d array is used which is later changed back to a 1 dimensional
	//---------------------------------------------------------------------------------------------------
	public static boolean squareCovered(boolean[] board, int row, int column) {
		return 	horizontal (board, row) || 
				vertical (board, column) ||
				diagonal1 (board, row, column) || 
				diagonal2 (board, row, column); 
	}
	// Checks four directions to see if a Queen attacks a Square
	//---------------------------------------------------------------------------------------------------
	public static boolean diagonal1(boolean[] board, int row, int column) {
		for (int r = 0; r < BOARD_SIZE; r++)
			for (int c = 0; c < BOARD_SIZE; c++)
				if (board [BOARD_SIZE * r + c] && r - c == row - column) return true; 
		return false;
	}
	// Checks the first diagonal from top Left to bottom right if it's covered by a Queen
	//---------------------------------------------------------------------------------------------------
	public static boolean diagonal2(boolean[] board, int row, int column) {
		for (int r = 0; r < BOARD_SIZE; r++)
			for (int c = 0; c < BOARD_SIZE; c++)
				if (board [BOARD_SIZE* r + c] && r + c == row + column) return true;
		return false;
	}
	// Checks the second diagonal from top right to bottom left if it's covered by a Queen
	//---------------------------------------------------------------------------------------------------

	public static boolean horizontal(boolean[] board, int row) {
		for (int c = 0; c < BOARD_SIZE; c++)
			if (board [BOARD_SIZE * row + c] ) return true;
		return false;
	}
	// Checks the horizontal row to see if it's covered
	//---------------------------------------------------------------------------------------------------
	public static boolean vertical(boolean[] board, int column) {
		for (int r = 0; r < BOARD_SIZE; r++)
			if (board [BOARD_SIZE * r + column] ) return true;
		return false;
	}
	// Checks the vertical column to see if it's covered
	//---------------------------------------------------------------------------------------------------
}
