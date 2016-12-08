package chessGame;

public class ChessBoard 
{

	private Piece[][] board;
	
	//Construction and Initializing the Board
	public ChessBoard()
	{
		this.board = new Piece[8][8];
		
		//Initializing empty spots
		for(int i=0; i<8; i++)
		{
			for(int j=2; j<6; j++)
			{
				board[i][j] = null;
			}
		}
		//Initializing default spots
		Rook rookWhiteOne = new Rook(0, 0, 0, 1);
		board[0][0] = rookWhiteOne;
		Knight knightWhiteOne = new Knight(1, 0, 0, 3);
		board[1][0] = knightWhiteOne;
		Bishop bishopWhiteOne = new Bishop(2, 0, 0, 2);
		board[2][0] = bishopWhiteOne;
		King kingWhite = new King(3, 0, 0, 5);
		board[3][0] = kingWhite;
		Queen queenWhite = new Queen(4, 0, 0, 4);
		board[4][0] = queenWhite;
		Bishop bishopWhiteTwo = new Bishop(5, 0, 0, 2);
		board[5][0] = bishopWhiteTwo;
		Knight knightWhiteTwo = new Knight(6, 0, 0, 3);
		board[6][0] = knightWhiteTwo;
		Rook rookWhiteTwo = new Rook(7, 0, 0, 1);
		board[7][0] = rookWhiteTwo;
		
		Pawn pawnWhiteOne = new Pawn(0, 1, 0, 0);
		board[0][1] = pawnWhiteOne;
		Pawn pawnWhiteTwo = new Pawn(1, 1, 0, 0);
		board[1][1] = pawnWhiteTwo;
		Pawn pawnWhiteThree = new Pawn(2, 1, 0, 0);
		board[2][1] = pawnWhiteThree;
		Pawn pawnWhiteFour = new Pawn(3, 1, 0, 0);
		board[3][1] = pawnWhiteFour;
		Pawn pawnWhiteFive = new Pawn(4, 1, 0, 0);
		board[4][1] = pawnWhiteFive;
		Pawn pawnWhiteSix = new Pawn(5, 1, 0, 0);
		board[5][1] = pawnWhiteSix;
		Pawn pawnWhiteSeven = new Pawn(6, 1, 0, 0);
		board[6][1] = pawnWhiteSeven;
		Pawn pawnWhiteEight = new Pawn(7, 1, 0, 0);
		board[7][1] = pawnWhiteEight;
		
		Pawn pawnBlackOne = new Pawn(0, 6, 1, 0);
		board[0][6] = pawnBlackOne;
		Pawn pawnBlackTwo = new Pawn(1, 6, 1, 0);
		board[1][6] = pawnBlackTwo;
		Pawn pawnBlackThree = new Pawn(2, 6, 1, 0);
		board[2][6] = pawnBlackThree;
		Pawn pawnBlackFour = new Pawn(3, 6, 1, 0);
		board[3][6] = pawnBlackFour;
		Pawn pawnBlackFive = new Pawn(4, 6, 1, 0);
		board[4][6] = pawnBlackFive;
		Pawn pawnBlackSix = new Pawn(5, 6, 1, 0);
		board[5][6] = pawnBlackSix;
		Pawn pawnBlackSeven = new Pawn(6, 6, 1, 0);
		board[6][6] = pawnBlackSeven;
		Pawn pawnBlackEight = new Pawn(7, 6, 1, 0);
		board[7][6] = pawnBlackEight;
		
		Rook rookBlackOne = new Rook(0, 7, 1, 1);
		board[0][7] = rookBlackOne;
		Knight knightBlackOne = new Knight(1, 7, 1, 3);
		board[1][7] = knightBlackOne;
		Bishop bishopBlackOne = new Bishop(2, 7, 1, 2);
		board[2][7] = bishopBlackOne;
		King kingBlack = new King(3, 7, 1, 5);
		board[3][7] = kingBlack;
		Queen queenBlack = new Queen(4, 7, 1, 4);
		board[4][7] = queenBlack;
		Bishop bishopBlackTwo = new Bishop(5, 7, 1, 2);
		board[5][7] = bishopBlackTwo;
		Knight knightBlackTwo = new Knight(6, 7, 1, 3);
		board[6][7] = knightBlackTwo;
		Rook rookBlackTwo = new Rook(7, 7, 1, 1);
		board[7][7] = rookBlackTwo;
	} //end of Constructor
	
	//getter for the piece
	public Piece getPiece(int x, int y)
	{
		return board[x][y];
	}
	
	//checking the users selection
	public boolean checkSelection(int x, int y, int turn)
	{
		if(board[x][y]==null)
			return false;
		
		if(board[x][y].getColor()==turn && board[x][y].getX()==x && board[x][y].getY()==y)
			return true;
		else
			return false;
					
	}
	
	//making the move if the move is valid
	public void makeMove(int x, int y, int newx, int newy)
	{
		if(board[newx][newy]!=null)
		board[newx][newy].setAlive(false);
		
		board[newx][newy] = board[x][y];
		board[x][y].setPosition(newx, newy);
		board[x][y] = null;
	}
	
	
	
	
	
} //end of Class
