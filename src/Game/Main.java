package Game;

import java.util.Scanner;

public class Main {
	// global variables
	public static final int empty = 0;
	public static final int cross = 1;
	public static final int zero = 2;
	
	public static final int playing = 0;
	public static final int draw = 1;
	public static final int cross_wins = 2;
	public static final int zero_wins = 3;

	public static boolean p1 = false;
	public static boolean p2 = false;
	public static int rows, columns; // number of rows and columns
	public static int[][] grid;

	public static int counter=1;
	public static int currentState, currentPlayer;
	public static int currentRow, currentCol; // current position
	public static Scanner in = new Scanner(System.in);

	// main
	public static void main(String[] args) {

		try {

			System.out.println("Welcome to Tic-Tac-Toe! Give the size of the grid (single integer):");
			rows = in.nextInt();
			
			while (rows<2)
			{	System.out.println("Size must be at least equal to 2, try again!");
				rows = in.nextInt();
			}
			
			columns = rows;		
			grid = new int[rows][columns];
			
			// any help?
			int ans = -1;
			
			while ((ans!=0)&&(ans!=1)&&(ans!=2)&&(ans!=3))
			{
			System.out.println("Advice? 0=No, 1=Advice for Player1, 2=Advice for Player2, 3=Advice for both");
			ans = in.nextInt();
			}
						
			if (ans==1)
				p1=true;
			else if (ans==2)
				p2 = true;
			else if (ans==3)
				{p1 = true;
				 p2 = true;
				}
			
			// initialise game
			Methods mygame = new Methods();
			mygame.initGame();

			do {
				mygame.playerMove(currentPlayer); // update stuff
				mygame.updateGame(currentPlayer, currentRow, currentCol); // update more stuff
				mygame.printBoard();
				
				// check if game ended
				if (currentState == cross_wins) {
					System.out.println("Player 1 is the winner!");
				}
				else if (currentState == zero_wins) {
					System.out.println("Player 2 is the winner!");
				}
				else if (currentState == draw) {
					System.out.println("Draw!");
				}

				// switch player
				currentPlayer = (currentPlayer == cross) ? zero : cross;
				counter++;
			} 
			while (currentState == playing); // repeat if not game-over
			in.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}