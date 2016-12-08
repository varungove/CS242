package chessGame;

public class Knight extends Piece
{
	
	public Knight(int x, int y, int color, int type)
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
		
		if(Math.abs(currX-x)*Math.abs(currY-y)==2)
			return true;
		
		return false;
	}

}//end of class
