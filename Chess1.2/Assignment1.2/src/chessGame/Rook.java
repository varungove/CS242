package chessGame;

/**
 * @author Varun Goverdhan
 * Rook class of type piece
 *
 */
public class Rook extends Piece
{
	
	/**
	 * Constructor for Rook
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Rook(int x, int y, color color, type type)
	{
		super(x, y, color, type);
	}
	
	/** 
	 * Checks to see if destination for rook is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) 
	{
		if(!checkBasics(x, y, turn, board))
			return false;
		
		int currX = this.getX();
		int currY = this.getY();
		
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

}
