package chessGame;

/**
 * @author Varun Goverdhan 
 * King class of type Piece
 */
public class King extends Piece {

	/**
	 * Constructor for King
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public King(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/**
	 * Checks if destination for king is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {
		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

		// Diagonal Movements
		if (Math.abs(x - currX) == 1 && Math.abs(y - currY) == 1)
			return true;

		// Horizontal Movements
		if (Math.abs(x - currX) == 1 && Math.abs(y - currY) == 0)
			return true;

		// Vertical Movements
		if (Math.abs(x - currX) == 0 && Math.abs(y - currY) == 1)
			return true;

		return false;
	}

}
