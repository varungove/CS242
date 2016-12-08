package chessGame;
import java.io.*;

public class GamePlay 
{
	private static ChessBoard gameBoard = new ChessBoard();
	private static String[][] boardPrint = new String[8][8];
	
	public static void main (String[] args) throws NumberFormatException, IOException
	{
		//GamePlay game = new GamePlay();
		System.out.println("Welcome To The Chess Game");
		
		int turn=0, x=0, y=0, newx=0, newy=0; //0 for player 1, 1 for player 2, 3 for game over
		String chance="";
		boolean check=false;
		Piece checkPiece;
		
		
		
		while(turn==0 || turn==1)
		{
			printBoard();
			
			if(turn==0)
				chance="Player 1's turn (White)";
			else
				chance="Player 2's turn (Black)";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//Checks to see if they selected a selectable piece
			while(check==false)
			{
			
			System.out.println(chance + " Enter x corrdinate of piece to move");
			x=Integer.parseInt(br.readLine());
			System.out.println(chance + " Enter y corrdinate of piece to move");
			y=Integer.parseInt(br.readLine());
			check = gameBoard.checkSelection(x, y, turn);
			
			if(check==false)
				System.out.println("Error, Try Again");
				
			} 
			
			//Checks to see if destination is valid
			while(check==true)
			{
				checkPiece = gameBoard.getPiece(x, y);
			System.out.println("Enter x corrdinate of destination");
			newx=Integer.parseInt(br.readLine());
			System.out.println("Enter y corrdinate of destination");
			newy=Integer.parseInt(br.readLine());
			
			check = checkPiece.checkDestination(newx, newy, turn, gameBoard);
			
				if(check==false)
				{
				System.out.println("Error, Try Again");
				check=true;
				}
				else
					check=false;
			
			}
			
			//Now we know that the move is valid
			gameBoard.makeMove(x, y, newx, newy);
			
			if(turn==1)
				turn=0;
			else
				turn=1;
			
			
		}//end of turn
		
	}//end of main
	
	public static void printBoard()
	{
		updateBoard();
			
		System.out.println("7|" + boardPrint[0][7] + boardPrint[1][7] + boardPrint[2][7] + boardPrint[3][7] + boardPrint[4][7] + boardPrint[5][7] + boardPrint[6][7] + boardPrint[7][7]);
		System.out.println("6|" + boardPrint[0][6] + boardPrint[1][6] + boardPrint[2][6] + boardPrint[3][6] + boardPrint[4][6] + boardPrint[5][6] + boardPrint[6][6] + boardPrint[7][6]);
		System.out.println("5|" + boardPrint[0][5] + boardPrint[1][5] + boardPrint[2][5] + boardPrint[3][5] + boardPrint[4][5] + boardPrint[5][5] + boardPrint[6][5] + boardPrint[7][5]);
		System.out.println("4|" + boardPrint[0][4] + boardPrint[1][4] + boardPrint[2][4] + boardPrint[3][4] + boardPrint[4][4] + boardPrint[5][4] + boardPrint[6][4] + boardPrint[7][4]);
		System.out.println("3|" + boardPrint[0][3] + boardPrint[1][3] + boardPrint[2][3] + boardPrint[3][3] + boardPrint[4][3] + boardPrint[5][3] + boardPrint[6][3] + boardPrint[7][3]);
		System.out.println("2|" + boardPrint[0][2] + boardPrint[1][2] + boardPrint[2][2] + boardPrint[3][2] + boardPrint[4][2] + boardPrint[5][2] + boardPrint[6][2] + boardPrint[7][2]);
		System.out.println("1|" + boardPrint[0][1] + boardPrint[1][1] + boardPrint[2][1] + boardPrint[3][1] + boardPrint[4][1] + boardPrint[5][1] + boardPrint[6][1] + boardPrint[7][1]);
		System.out.println("0|" + boardPrint[0][0] + boardPrint[1][0] + boardPrint[2][0] + boardPrint[3][0] + boardPrint[4][0] + boardPrint[5][0] + boardPrint[6][0] + boardPrint[7][0]);
		System.out.println("  -----------------------");
		System.out.println("   0  1  2  3  4  5  6  7");

	} //end of printBoard
	
	public static void updateBoard()
	{
		Piece check;
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				check = gameBoard.getPiece(i, j);
				if(check!=null)
				{
					if(check.getType()==0 && check.getColor()==0)
						boardPrint[i][j]="WP ";
					else
						if(check.getType()==0 && check.getColor()==1)
							boardPrint[i][j]="BP ";
					else
						if(check.getType()==1 && check.getColor()==0)
							boardPrint[i][j]="WR ";
					else
						if(check.getType()==1 && check.getColor()==1)
							boardPrint[i][j]="BR ";
					else
						if(check.getType()==2 && check.getColor()==0)
							boardPrint[i][j]="WB ";
					else
						if(check.getType()==2 && check.getColor()==1)
							boardPrint[i][j]="BB ";
					else
						if(check.getType()==3 && check.getColor()==0)
								boardPrint[i][j]="WH ";
					else
						if(check.getType()==3 && check.getColor()==1)
								boardPrint[i][j]="BH ";
					else
						if(check.getType()==4 && check.getColor()==0)
								boardPrint[i][j]="WQ ";
					else
						if(check.getType()==4 && check.getColor()==1)
								boardPrint[i][j]="BQ ";
					else
						if(check.getType()==5 && check.getColor()==0)
								boardPrint[i][j]="WK ";
					else
							boardPrint[i][j]="BK ";
							
						
				}
				else
				{
					boardPrint[i][j]="   ";
				}
				
			}//end of j for
		}//end of i for
	}//end of updateBoard

}//end of class
