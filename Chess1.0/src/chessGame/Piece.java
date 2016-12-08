package chessGame;

public abstract class Piece 
{
	
	private int x; 
	private int y;
	private int color; // 0 for white, 1 for black
	private boolean alive;
	private int type; // 0 Pawn, 1 Rook, 2 Bishop, 3 Knight, 4 Queen, 5 King
	
	public Piece(int x, int y, int color, int type)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		this.alive = true;
		this.type = type;
	} 
	
	abstract boolean checkDestination(int x, int y, int turn, ChessBoard board);
	 
	 //Getters for X, Y, Color, Alive
	 
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public boolean getAlive()
	{
		return this.alive;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	//Setters for Position, Color, Alive
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}
	
	

}//end of Class
