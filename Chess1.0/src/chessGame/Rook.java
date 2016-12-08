package chessGame;

public class Rook extends Piece
{
	
	public Rook(int x, int y, int color, int type)
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
		
		//Horizontal Movement
		if(y==currY)
		{
			for(int i = 1; i < Math.abs(x - currX); i++)
			{
				//Right
				if(x>currX)
				{
					if(board.getPiece(currX+i, currY)!=null)
						return false;
					
				}
				//Left
				else
				{
					if(board.getPiece(currX-i, currY)!=null)
						return false;
					
				}
			}
			
			return true;
		}
			//Vertical Movement
			if(x==currX)
			{
			
				for(int i = 1; i < Math.abs(y - currY); i++)
				{
				
					//Up
					if(y>currY)
					{
						if(board.getPiece(currX, currY+i)!=null)
							return false;
						
					}
					//Down
					else
					{
						if(board.getPiece(currX, currY-i)!=null)
							return false;
						
					}
				}
			
				return true;
		}
		
		return false;
	}

}//end of class
