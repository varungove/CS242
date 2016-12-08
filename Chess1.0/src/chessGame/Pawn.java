package chessGame;

public class Pawn extends Piece
{
	
	public Pawn(int x, int y, int color, int type)
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
		
		//2-Squares Forward - 1st Try - White
		if(currX==x && y==currY+2 && turn==0)
		{
			if(currY==1 && check==null && board.getPiece(x, y-1)==null)
				return true;
			else
				return false;
		}
		
		//2-Squares Forward - 1st Try - Black
			if(currX==x && y==currY-2 && turn==1 && board.getPiece(x, y+1)==null)
			{
				if(currY==6 && check==null)
					return true;
				else
					return false;
			}
		//Left - Diagonal  - White
			if(x==currX-1 && y==currY+1 && turn==0)
			{
				if(check!=null && check.getColor()==1)
					return true;
				else
					return false;
			}
			
		//Right - Diagonal - White
			if(x==currX+1 && y==currY+1 && turn==0)
			{
				if(check!=null && check.getColor()==1)
					return true;
				else
					return false;
			}
			
		//Left - Diagonal - Black
			if(x==currX-1 && y==currY-1 && turn==1)
			{
				if(check!=null && check.getColor()==0)
					return true;
				else
					return false;
			}
			
		//Right - Diagonal - Black
			if(x==currX+1 && y==currY-1 && turn==1)
			{
				if(check!=null && check.getColor()==0)
					return true;
				else
					return false;
			}
			
		//1 Step Front - White
			if(x==currX && y==currY+1 && turn==0)
			{
				if(check==null)
					return true;
				else
					return false;
			}
			
			//1 Step Front - Black
			if(x==currX && y==currY-1 && turn==1)
			{
				if(check==null)
					return true;
				else
					return false;
			}
		
		
		//other moves
		return false;
	}

}//end of class
