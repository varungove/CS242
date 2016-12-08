package chessGame;

/**
 * @author Varun Goverdhan 
 * Knight class of type Piece
 */
public class Knight extends Piece {

	/**
	 * Constructor for Knight class
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Knight(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/**
	 * Checks if destination for knight is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {

		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

		if (Math.abs(currX - x) * Math.abs(currY - y) == 2)
			return true;

		return false;
	}

}
