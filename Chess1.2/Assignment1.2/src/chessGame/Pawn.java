package chessGame;

/**
 * @author Varun Goverdhan 
 * Pawn class of type Piece
 */
public class Pawn extends Piece {

	/**
	 * Constructor for Pawn Class
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Pawn(int x, int y, color color, type type) {
		super(x, y, color, type);
	}

	/**
	 * Checks if destination for pawn is valid or not
	 */
	@Override
	public boolean checkDestination(int x, int y, int turn, ChessBoard board) {
		if (!checkBasics(x, y, turn, board))
			return false;

		int currX = this.getX();
		int currY = this.getY();
		Piece check = board.getPiece(x, y);

		// 2-Squares Forward - 1st Try - White
		if (currX == x && y == currY + 2 && turn == 0) {
			if (currY == 1 && check == null && board.getPiece(x, y - 1) == null)
				return true;
			else
				return false;
		}

		// 2-Squares Forward - 1st Try - Black
		if (currX == x && y == currY - 2 && turn == 1 && board.getPiece(x, y + 1) == null) {
			if (currY == 6 && check == null)
				return true;
			else
				return false;
		}
		// Left - Diagonal - White
		if (x == currX - 1 && y == currY + 1 && turn == 0) {
			if (check != null && check.getColor() == color.BLACK)
				return true;
			else
				return false;
		}

		// Right - Diagonal - White
		if (x == currX + 1 && y == currY + 1 && turn == 0) {
			if (check != null && check.getColor() == color.BLACK)
				return true;
			else
				return false;
		}

		// Left - Diagonal - Black
		if (x == currX - 1 && y == currY - 1 && turn == 1) {
			if (check != null && check.getColor() == color.WHITE)
				return true;
			else
				return false;
		}

		// Right - Diagonal - Black
		if (x == currX + 1 && y == currY - 1 && turn == 1) {
			if (check != null && check.getColor() == color.WHITE)
				return true;
			else
				return false;
		}

		// 1 Step Front - White
		if (x == currX && y == currY + 1 && turn == 0) {
			if (check == null)
				return true;
			else
				return false;
		}

		// 1 Step Front - Black
		if (x == currX && y == currY - 1 && turn == 1) {
			if (check == null)
				return true;
			else
				return false;
		}

		// other moves
		return false;
	}

}
