import java.util.Random;
import java.util.Scanner;

public class Four_Queens_Random {


	private static int board_size; 
	private static int squares;
	private static int queens = 4; 
	private static int configurations;
	private static int attempts = 100;
	private static int answers; 


	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		System.out.printf(	"Welcome to the 3 queens on a board problem!"+
				"\nPlease enter an integer N for a N X N Grid"+
				"\nThe Number has to be larger than three."+
				"\nAnd the program only takes a few seconds to run"+
				"\nSo if no answers were found in about 10 secs just exit"+
				"\nPlease enter an integer:"

				);
		board_size= keyboard.nextInt();
		squares = board_size * board_size;
		configurations = squares * (squares - 1) * (squares - 2) * (squares - 3);
		boolean[] board = new boolean[squares]; 
		Random random = new Random(); 
		for (int x = 0; x < attempts; x++) { 
			for (int i = 0; i < board.length; board[i] = false, i++); 
			int[] q = new int[queens]; 

			int rand = random.nextInt(configurations);
			for (int i = 0; i < queens; i++) {
				q[i] = rand % (squares - i); 
				rand = rand / (squares - i); 
			}
			for (int i = 1; i < queens; i++) {
				for (int j = 0; j < i; j++) 
					if (q[i] >= q[j]) 
						q[i]++; 
				sort (q,i); 
			}
			for (int i = 0; i < queens; i++) { 
				board[q[i]] = true;
			}
			if (boardCovered(board)) 
				displayBoard(board);
		}
		if (answers == 0) System.out.println ("No answers found");

	}
	// Randomly assigns the position of the board to the queens.
	//---------------------------------------------------------------------------------------------------
	private static void sort(int[] q, int i) { 
		for (int x = 1; x < i; x++)
			for (int j = 0; j < i; j++) {
				if (q[j] > q[x]) { 
					int temp = q[x];
					q[x] = q[j];
					q[j] = temp;
				}
			}
	}
	//Sorts the Queens in ascending order
	//---------------------------------------------------------------------------------------------------
	public static void displayBoard(boolean[] board) {
		for (int row = 0; row < board_size; row++) { 
			for (int i = 0; i <  board_size; i++) System.out.print("****" + (i == board_size-1? "*\n" : ""));
			for (int col = 0; col < board_size; col++) { 
				System.out.print("*" + (board[board_size*row+col]?" Q ":(squareCovered(board,row,col)? " x " : "   ")) + (col == board_size-1? "*\n" : ""));
			}
		}
		for (int i = 0; i <  board_size; i++) System.out.print("****" + (i == board_size-1? "*\n" : ""));
		System.out.println(++answers + "\n");
	}
	// Displays board and keeps count of the answers. On the display Queens are shown as a Q and X's are the spots they attack
	//---------------------------------------------------------------------------------------------------
	public static boolean boardCovered(boolean[] board) {
		for (int row = 0; row < board_size; row++) 
			for (int col = 0; col < board_size; col++)
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
		for (int r = 0; r < board_size; r++)
			for (int c = 0; c < board_size; c++)
				if (board [board_size * r + c] && r - c == row - column) return true; 
		return false;
	}
	// Checks the first diagonal from top Left to bottom right if it's covered by a Queen
	//---------------------------------------------------------------------------------------------------
	public static boolean diagonal2(boolean[] board, int row, int column) {
		for (int r = 0; r < board_size; r++)
			for (int c = 0; c < board_size; c++)
				if (board [board_size* r + c] && r + c == row + column) return true;
		return false;
	}
	// Checks the second diagonal from top right to bottom left if it's covered by a Queen
	//---------------------------------------------------------------------------------------------------

	public static boolean horizontal(boolean[] board, int row) {
		for (int c = 0; c < board_size; c++)
			if (board [board_size * row + c] ) return true;
		return false;
	}
	// Checks the horizontal row to see if it's covered
	//---------------------------------------------------------------------------------------------------
	public static boolean vertical(boolean[] board, int column) {
		for (int r = 0; r < board_size; r++)
			if (board [board_size * r + column] ) return true;
		return false;
	}
	// Checks the vertical column to see if it's covered
	//---------------------------------------------------------------------------------------------------
}
