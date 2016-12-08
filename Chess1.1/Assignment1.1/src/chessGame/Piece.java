package chessGame;

/**
 * @author Varun Goverdhan 
 * Piece class from which all types of pieces extend from
 */
public abstract class Piece {
	enum color {
		WHITE, BLACK
	}

	enum type {
		PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING, CUSTOMONE, CUSTOMTWO
	}

	private int x;
	private int y;
	private boolean alive;
	private type type;
	private color color;

	/**
	 * Constructor for piece class
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param type
	 */
	public Piece(int x, int y, color color, type type) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.alive = true;
		this.type = type;
	}

	/**
	 * Takes the destination coordinates and checks to see if it is valid
	 * 
	 * @param x
	 * @param y
	 * @param turn
	 * @param board
	 * @return true if move is valid, false if not
	 */
	abstract boolean checkDestination(int x, int y, int turn, ChessBoard board);

	/**
	 * Getters for Piece X, Y, Color, Alive, Type
	 */

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public color getColor() {
		return this.color;
	}

	public boolean getAlive() {
		return this.alive;
	}

	public type getType() {
		return this.type;
	}

	/**
	 * Setters for Piece Position, Color, Alive
	 */

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setColor(color color) {
		this.color = color;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Checks to see if a possible move has valid inputs
	 * 
	 * @param x
	 * @param y
	 * @param turn
	 * @param board
	 * @return True if it passes the basic tests, False if not
	 */
	@SuppressWarnings("static-access")
	public boolean checkBasics(int x, int y, int turn, ChessBoard board) {

		if (x > 7 || y > 7 || x < 0 || y < 0)
			return false;

		Piece check = board.getPiece(x, y);

		if (check != null && check.getColor() == color.BLACK && turn == 1)
			return false;

		if (check != null && check.getColor() == color.WHITE && turn == 0)
			return false;

		return true;
	}

}
