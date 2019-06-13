package Game;

public class Advice extends Methods{
	
	public void advice(String player)
	{	
		System.out.println();		
		int centre = rows/2; // note that array indices start from 0

		if ((counter<4)&&(grid[centre][centre]==empty))
			System.out.println("Advice for Player "+player+": Position (" + (centre+1) + ","+ (centre+1)+")");
	
		else if ((counter<4)&&(grid[centre-1][centre-1]==empty))
			System.out.println("Advice for Player "+player+": Position (" + (centre) + ","+ (centre)+")");
		
		else if ((counter<4)&&(grid[centre+1][centre+1]==empty))
			System.out.println("Advice for Player "+player+": Position (" + (centre+2) + ","+ (centre+2)+")");
		
		else if ((counter<4)&&(grid[centre-1][centre+1]==empty))
			System.out.println("Advice for Player "+player+": Position (" + (centre) + ","+ (centre+2)+")");
		
		else if ((counter<4)&&(grid[centre+1][centre-1]==empty))
			System.out.println("Advice for Player "+player+": Position (" + (centre+2) + ","+ (centre)+")");
	
		else
		{	boolean ans = true;
			int sum=0;
			// for row
			if (ans)
			for (int i=0; i<rows; i++)
			{
			sum=0;
			for (int j=0; j<columns; j++)   			   
				if (grid[i][j] != empty)
					sum+=grid[i][j];
	   	
				if ((rows*zero-sum==zero)||(rows*cross-sum==cross))
					for (int j=0; j<columns; j++)
						if ((grid[i][j]==empty)&&(ans))
							{System.out.println("Advice for Player "+player+": Position (" + (i+1) + ","+ (j+1)+")");
							ans = false;
							}
				break;
			}
	    
			
			// for column
			if (ans)
			for (int j=0; j<columns; j++)
			{
				sum=0;
				for (int i=0; i<rows; i++)   			   
					if (grid[i][j] != empty)
						sum+=grid[i][j];
   	
				if ((rows*zero-sum==zero)||(rows*cross-sum==cross))
					for (int i=0; i<rows; i++)
						if ((grid[i][j]==empty)&&(ans))
							{System.out.println("Advice for Player "+player+": Position (" + (i+1) + ","+ (j+1)+")");
							ans = false;
							}
				break;
			}
			

			// for main diagonal
			if (ans)
			{sum=0;
			for (int i=0; i<rows; i++)
			{		   
				if (grid[i][i] != empty)
					sum+=grid[i][i];
			}
	
			if ((rows*zero-sum==zero)||(rows*cross-sum==cross))
				for (int i=0; i<rows; i++)
					if ((grid[i][i]==empty)&&(ans))
						{System.out.println("Advice for Player "+player+": Position (" + (i+1) + ","+ (i+1)+")");	   	
						ans=false;
						}   
			}
			
			
			// for secondary diagonal
			if (ans){
			sum=0;	
			for (int i=0; i<rows; i++)
			{	   
				if (grid[rows-1-i][i] != zero)
					sum+=grid[rows-1-i][i];
			}
	
			if ((rows*zero-sum==zero)||(rows*cross-sum==cross))
				for (int i=0; i<rows; i++)
					if ((grid[rows-1-i][i]==empty)&&(ans))
						{System.out.println("Advice for Player "+player+": Position (" + (rows-i) + ","+ (i+1)+")");
						ans = false;}
						}
  	
			}
		}
}
