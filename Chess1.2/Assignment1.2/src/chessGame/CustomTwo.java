package chessGame;

/**
 * @author varungove
 * CustomTwo can only hop over pieces. Can not move otherwise. Kills at destination.
 */
public class CustomTwo extends Piece {

	/**
	 * Constructor for CustomTwo
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public CustomTwo(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/** 
	 * Checks if destination for CustomTwo is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {

		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

		// Horizontal Movements
		if (Math.abs(x - currX) == 2 && Math.abs(y - currY) == 0) {
			if (x - currX < 0 && board.getPiece(x - 1, currY) != null)
				return true;

			if (x - currX > 0 && board.getPiece(x + 1, currY) != null)
				return true;

		}

		// Vertical Movements
		if (Math.abs(x - currX) == 0 && Math.abs(y - currY) == 2) {
			if (y - currY < 0 && board.getPiece(x, currY - 1) != null)
				return true;

			if (y - currY > 0 && board.getPiece(x, currY + 1) != null)
				return true;

		}

		return false;
	}

}
