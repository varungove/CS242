package chessGame;

/**
 * @author Varun Goverdhan
 *  Queen class of Type Piece
 */
public class Queen extends Piece {

	/**
	 * Constructor for Queen
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Queen(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/**
	 * Checks if destination for queen is valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {
		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

		// Horizontal Movement
		if (y == currY) {
			for (int i = 1; i < Math.abs(x - currX); i++) {
				// Right
				if (x > currX) {
					if (board.getPiece(currX + i, currY) != null)
						return false;

				}
				// Left
				else {
					if (board.getPiece(currX - i, currY) != null)
						return false;

				}
			}

			return true;
		}
		// Vertical Movement
		if (x == currX) {

			for (int i = 1; i < Math.abs(y - currY); i++) {

				// Up
				if (y > currY) {
					if (board.getPiece(currX, currY + i) != null)
						return false;

				}
				// Down
				else {
					if (board.getPiece(currX, currY - i) != null)
						return false;

				}
			}

			return true;

		}

		// Diagonal
		if (Math.abs(currX - x) == Math.abs(currY - y)) {
			// Check if pieces are in between
			for (int i = 1; i < Math.abs(x - currX); i++) {
				// up and left
				if (y < currY && x < currX) {
					if (board.getPiece(currX - 1, currY - i) != null) {
						return false;
					}
				}

				// down and left
				if (y > currY && x < currX) {
					if (board.getPiece(currX - i, currY + i) != null) {
						return false;
					}
				}

				// up and right
				if (y < currY && x > currX) {
					if (board.getPiece(currX + i, currY - i) != null) {
						return false;
					}
				}

				// down and right
				if (y > currY && x > currX) {
					if (board.getPiece(currX + i, currY + i) != null) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

}
