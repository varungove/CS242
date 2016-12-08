package chessGame;

public class King extends Piece
{
	
	public King(int x, int y, int color, int type)
	{
		super(x, y, color, type);
	}
	
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) 
	{
		//out of board
		if (x>7 || y>7 || x<0 || y<0)
			return false;
		
		int currX = this.getX();
		int currY = this.getY();
		Piece check = board.getPiece(x, y);
		
		//players own piece is at destination - black
		if(check!=null && check.getColor()==1 && turn==1)
			return false;
		
		//players own piece is at destination = white
		if(check!=null && check.getColor()==0 && turn==0)
			return false;
		
		//Diagonal Movements
		if(Math.abs(x-currX)==1 && Math.abs(y-currY)==1)
			return true;
		
		//Horizontal Movements
		if(Math.abs(x-currX)==1 && Math.abs(y-currY)==0)
			return true;
		
		//Vertical Movements
		if(Math.abs(x-currX)==0 && Math.abs(y-currY)==1)
			return true;
		
		
		
		return false;
	}

}//end of class
