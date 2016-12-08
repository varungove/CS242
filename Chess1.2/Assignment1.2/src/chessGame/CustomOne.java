package chessGame;

/**
 * @author Varun Goverdhan
 * CustomOne piece can move two spots in any direction. It can jump over pieces and kills the same way it moves
 */
public class CustomOne extends Piece {

	/**
	 * Constructor for CustomOne
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public CustomOne(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/** 
	 * Checks if Destination is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {

		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

		// Diagonal Movements
		if (Math.abs(x - currX) == 2 && Math.abs(y - currY) == 2)
			return true;

		// Horizontal Movements
		if (Math.abs(x - currX) == 2 && Math.abs(y - currY) == 0)
			return true;

		// Vertical Movements
		if (Math.abs(x - currX) == 0 && Math.abs(y - currY) == 2)
			return true;

		return false;
	}

}
