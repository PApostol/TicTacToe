package Game;

public class Methods extends Main{

	   // initialise game board
	   public void initGame() {
	      for (int row = 0; row < rows; ++row) {
	         for (int col = 0; col < columns; ++col) {
	            grid[row][col] = empty;  // fill with zeros
	         }
	      }
	      currentState = playing; // ready to play
	      currentPlayer = cross;  // cross plays first
	   }
	 
	   // player move
	   public void playerMove(int theSeed) {
	      boolean validInput = false;  // for input validation
	     
	      do {
	         if (theSeed == cross) {
	        	 if (p1)
	        	 {Advice myadvice = new Advice();
	        	 myadvice.advice("1");
	        	 }
	            System.out.print("Player 1, enter  position (x y): ");
	         } else {
	        	 if (p2)
	        	 {Advice myadvice = new Advice();
	        	 myadvice.advice("2");
	        	 }
	            System.out.print("Player 2, enter  position (x y): ");
	         }
	        
	         int row = in.nextInt() - 1;  // adjust arrays
	         int col = in.nextInt() - 1;
	         
	         if (row >= 0 && row < rows && col >= 0 && col < columns && grid[row][col] == empty) {
	            currentRow = row;
	            currentCol = col;
	            grid[currentRow][currentCol] = theSeed;  // update game-board content
	            validInput = true;  // input okay, exit loop
	         }
	         else {
	            System.out.println("Move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again.");
	            System.out.println();
	         }
	      } while (!validInput);  // repeat until input is valid
	   }
	 
	   
	  // update current state
	   public void updateGame(int theSeed, int currentRow, int currentCol) {

		   if (checkWin(theSeed, currentRow, currentCol))
			  {  // check if winning move
				  currentState = (theSeed == cross) ? cross_wins : zero_wins;
			  } 
			  else if (isDraw())
			  {  // check for draw
				  currentState = draw;
			  }	   
	   }
	   
	 
	  // check for draw
	   public boolean isDraw() {
	      for (int row = 0; row < rows; ++row) {
	         for (int col = 0; col < columns; ++col) {
	            if (grid[row][col] == empty) {
	               return false;  // an empty cell found, not draw yet
	            }
	         }
	      }
	      return true;  // no empty cell, it's a draw
	   }
	 	   
	   
	   // check winning conditions
	   public static boolean checkWin(int theSeed, int currentRow, int currentCol) {
		      
		   boolean ans = false;
		   
		   // for row
		   for (int i=0; i<rows; i++)
		   {		   			   
			   if (grid[currentRow][i] == theSeed)
				   ans = true;
			   else
				   {
				   ans = false;
				   break;
				   }
		   }
		   		   
		   if (ans)
			   return true;
		   
		   // for column
		   for (int i=0; i<columns; i++)
		   {		   			   
			   if (grid[i][currentCol] == theSeed)
				   ans = true;
			   else
				   {
				   ans = false;
				   break;
				   }
		   }
		   		   
		   if (ans)
			   return true;

           // for main diagonal
		   for (int i=0; i<rows; i++)
		   {		   			   
			   if (grid[i][i] == theSeed)
				   ans = true;
			   else
				   {
				   ans = false;
				   break;
				   }
		   }
		   		   
		   if (ans)
			   return true;
		   	   
		   // for secondary diagonal
		   for (int i=0; i<rows; i++)
		   {		   			   
			   if (grid[i][rows-1-i] == theSeed)
				   ans = true;
			   else
				   {
				   ans = false;
				   break;
				   }
		   }
		   		   
		   if (ans)
			   return true;
		      
		   return false;
	 }	   
	 
	   
	  // print
	   public void printBoard() {
	      for (int row = 0; row < rows; ++row) {
	         for (int col = 0; col < columns; ++col) {
	            printCell(grid[row][col]); // print each of the cells
	            if (col != columns - 1) {
	               System.out.print("|");   // print vertical part
	            }
	         }	         
	         System.out.println();
	         
	         if (row != rows - 1) {
	            int i=0;	            
	        	for (i=0; i<rows; i++)
	        	 System.out.print("----"); // print horizontal part
	       
	        	System.out.println();        	 
	         }
	      }
	      System.out.println();
	   }
	

	   // print specific cell (used in printBoard)
	   public static void printCell(int content) {
	      switch (content) {
	         case empty:  System.out.print("   ");
	         		break;
	         case zero: System.out.print(" O ");
	         		break;
	         case cross:  System.out.print(" X ");
	         		break;
	      }
	   }
}
