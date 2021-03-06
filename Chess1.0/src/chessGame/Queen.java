package chessGame;

public class Queen extends Piece
{
	
	public Queen(int x, int y, int color, int type)
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
					
					//Diagonal
					if(Math.abs(currX - x) == Math.abs(currY - y))
			        {
			            //Check if pieces are in between
			            for(int i = 1; i < Math.abs(x - currX); i++)
			            {
			                //up and left
			                if(y < currY && x < currX)
			                {
			                    if(board.getPiece(currX-1, currY-i) != null)
			                    {
			                        return false;
			                    }
			                }

			                //down and left
			                if(y > currY && x < currX)
			                {
			                    if(board.getPiece(currX-i, currY+i) != null)
			                    {
			                        return false;
			                    }
			                }

			                //up and right
			                if(y < currY && x > currX)
			                {
			                    if(board.getPiece(currX+i, currY-i) != null)
			                    {
			                        return false;
			                    }
			                }

			                //down and right
			                if(y > currY && x > currX)
			                {
			                    if(board.getPiece(currX+i, currY+i) != null)
			                    {
			                        return false;
			                    }
			                }
			            }
			            return true;
			        }
		return false;
	}

}//end of class
