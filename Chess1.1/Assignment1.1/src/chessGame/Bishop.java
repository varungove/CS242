package chessGame;

/**
 * @author Varun Goverdhan
 *  Bishop class of type Piece
 */
public class Bishop extends Piece {

	/**
	 * Constructor for Bishop
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Bishop(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/**
	 * Checks if destination for Bishop is Valid
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {

		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();

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
