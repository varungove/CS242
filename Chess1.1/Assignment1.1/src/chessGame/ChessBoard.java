package chessGame;

import chessGame.Piece.color;
import chessGame.Piece.type;

/**
 * @author Varun Goverdhan
 * The basic chessboard with chess board functionality
 */
public class ChessBoard {

	private Piece[][] board;
	private int whiteKingX;
	private int whiteKingY;
	private int blackKingX;
	private int blackKingY;

	
	/**
	 * Constructs and Initializes the Board
	 */
	public ChessBoard() {
		this.board = new Piece[8][8];
		whiteKingX = 3;
		whiteKingY = 0;
		blackKingX = 3;
		blackKingY = 7;

		// Initializing empty spots
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				board[i][j] = null;
			}
		}
		// Initializing default spots
		Rook rookWhiteOne = new Rook(0, 0, color.WHITE, type.ROOK);
		board[0][0] = rookWhiteOne;
		Knight knightWhiteOne = new Knight(1, 0, color.WHITE, type.KNIGHT);
		board[1][0] = knightWhiteOne;
		Bishop bishopWhiteOne = new Bishop(2, 0, color.WHITE, type.BISHOP);
		board[2][0] = bishopWhiteOne;
		King kingWhite = new King(3, 0, color.WHITE, type.KING);
		board[3][0] = kingWhite;
		Queen queenWhite = new Queen(4, 0, color.WHITE, type.QUEEN);
		board[4][0] = queenWhite;
		Bishop bishopWhiteTwo = new Bishop(5, 0, color.WHITE, type.BISHOP);
		board[5][0] = bishopWhiteTwo;
		Knight knightWhiteTwo = new Knight(6, 0, color.WHITE, type.KNIGHT);
		board[6][0] = knightWhiteTwo;
		Rook rookWhiteTwo = new Rook(7, 0, color.WHITE, type.ROOK);
		board[7][0] = rookWhiteTwo;

		Pawn pawnWhiteOne = new Pawn(0, 1, color.WHITE, type.PAWN);
		board[0][1] = pawnWhiteOne;
		Pawn pawnWhiteTwo = new Pawn(1, 1, color.WHITE, type.PAWN);
		board[1][1] = pawnWhiteTwo;
		Pawn pawnWhiteThree = new Pawn(2, 1, color.WHITE, type.PAWN);
		board[2][1] = pawnWhiteThree;
		Pawn pawnWhiteFour = new Pawn(3, 1, color.WHITE, type.PAWN);
		board[3][1] = pawnWhiteFour;
		Pawn pawnWhiteFive = new Pawn(4, 1, color.WHITE, type.PAWN);
		board[4][1] = pawnWhiteFive;
		Pawn pawnWhiteSix = new Pawn(5, 1, color.WHITE, type.PAWN);
		board[5][1] = pawnWhiteSix;
		Pawn pawnWhiteSeven = new Pawn(6, 1, color.WHITE, type.PAWN);
		board[6][1] = pawnWhiteSeven;
		Pawn pawnWhiteEight = new Pawn(7, 1, color.WHITE, type.PAWN);
		board[7][1] = pawnWhiteEight;

		Pawn pawnBlackOne = new Pawn(0, 6, color.BLACK, type.PAWN);
		board[0][6] = pawnBlackOne;
		Pawn pawnBlackTwo = new Pawn(1, 6, color.BLACK, type.PAWN);
		board[1][6] = pawnBlackTwo;
		Pawn pawnBlackThree = new Pawn(2, 6, color.BLACK, type.PAWN);
		board[2][6] = pawnBlackThree;
		Pawn pawnBlackFour = new Pawn(3, 6, color.BLACK, type.PAWN);
		board[3][6] = pawnBlackFour;
		Pawn pawnBlackFive = new Pawn(4, 6, color.BLACK, type.PAWN);
		board[4][6] = pawnBlackFive;
		Pawn pawnBlackSix = new Pawn(5, 6, color.BLACK, type.PAWN);
		board[5][6] = pawnBlackSix;
		Pawn pawnBlackSeven = new Pawn(6, 6, color.BLACK, type.PAWN);
		board[6][6] = pawnBlackSeven;
		Pawn pawnBlackEight = new Pawn(7, 6, color.BLACK, type.PAWN);
		board[7][6] = pawnBlackEight;

		Rook rookBlackOne = new Rook(0, 7, color.BLACK, type.ROOK);
		board[0][7] = rookBlackOne;
		Knight knightBlackOne = new Knight(1, 7, color.BLACK, type.KNIGHT);
		board[1][7] = knightBlackOne;
		Bishop bishopBlackOne = new Bishop(2, 7, color.BLACK, type.BISHOP);
		board[2][7] = bishopBlackOne;
		King kingBlack = new King(3, 7, color.BLACK, type.KING);
		board[3][7] = kingBlack;
		Queen queenBlack = new Queen(4, 7, color.BLACK, type.QUEEN);
		board[4][7] = queenBlack;
		Bishop bishopBlackTwo = new Bishop(5, 7, color.BLACK, type.BISHOP);
		board[5][7] = bishopBlackTwo;
		Knight knightBlackTwo = new Knight(6, 7, color.BLACK, type.KNIGHT);
		board[6][7] = knightBlackTwo;
		Rook rookBlackTwo = new Rook(7, 7, color.BLACK, type.ROOK);
		board[7][7] = rookBlackTwo;
	} 

	
	/**
	 * Getter for individual pieces
	 * @param x
	 * @param y
	 * @return
	 */
	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	
	/**
	 * Checks if the piece the user selected is valid
	 * @param x
	 * @param y
	 * @param turn
	 * @return true if selection is valid, false if not
	 */
	public boolean checkSelection(int x, int y, int turn) {
		color check;
		if (turn == 0)
			check = color.WHITE;
		else
			check = color.BLACK;
		if (board[x][y] == null)
			return false;

		if (board[x][y].getColor() == check && board[x][y].getX() == x && board[x][y].getY() == y)
			return true;
		else
			return false;

	}

	
	/**
	 * If the move is valid, it makes the move, updates location and kills piece at destination if necessary
	 * @param x
	 * @param y
	 * @param newx
	 * @param newy
	 */
	public void makeMove(int x, int y, int newx, int newy) {
		
		if (board[x][y].getType() == type.KING && board[x][y].getColor() == color.WHITE) {
			whiteKingX = newx;
			whiteKingY = newy;
		}

		
		if (board[x][y].getType() == type.KING && board[x][y].getColor() == color.BLACK) {
			blackKingX = newx;
			blackKingY = newy;
		}

		
		if (board[newx][newy] != null)
			board[newx][newy].setAlive(false);

		board[newx][newy] = board[x][y];
		board[x][y].setPosition(newx, newy);
		board[x][y] = null;
	}

	
	/**
	 * Checks to see if the last move made put the King into check
	 * @param turn
	 * @return true if check, false if not
	 */
	public boolean checkCheck(int turn) {
		Piece check;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				check = this.getPiece(i, j);

				
				if (check != null) {
					// if White Made the Last Move
					if (turn == 0 && check.getColor() == color.WHITE) {
						if (check.checkDestination(blackKingX, blackKingY, turn, this))
							return true;
					}
					// if Black Made the Last Move
					if (turn == 1 && check.getColor() == color.BLACK) {
						if (check.checkDestination(whiteKingX, whiteKingY, turn, this))
							return true;
					}

				}

			}
		}
		return false;
	}

	
	/**
	 * If the last move put the game in check, it checks if it is in check mate
	 * @param turn
	 * @return true if checkmate, false if not
	 */
	public boolean checkCheckMate(int turn) {
		Piece check;
		int x, y;

		if (turn == 1) {
			check = this.getPiece(whiteKingX, whiteKingY);
			x = whiteKingX;
			y = whiteKingY;
		} else {
			check = this.getPiece(blackKingX, blackKingY);
			x = blackKingX;
			y = blackKingY;
		}

		boolean[] kingMoves = new boolean[8];
		kingMoves[0] = check.checkDestination(x, y + 1, turn, this) && checkCheck(turn, x, y + 1);
		kingMoves[1] = check.checkDestination(x, y - 1, turn, this) && checkCheck(turn, x, y - 1);
		kingMoves[2] = check.checkDestination(x - 1, y, turn, this) && checkCheck(turn, x - 1, y);
		kingMoves[3] = check.checkDestination(x + 1, y, turn, this) && checkCheck(turn, x + 1, y);
		kingMoves[4] = check.checkDestination(x + 1, y + 1, turn, this) && checkCheck(turn, x + 1, y + 1);
		kingMoves[5] = check.checkDestination(x - 1, y - 1, turn, this) && checkCheck(turn, x - 1, y - 1);
		kingMoves[6] = check.checkDestination(x - 1, y + 1, turn, this) && checkCheck(turn, x - 1, y + 1);
		kingMoves[7] = check.checkDestination(x + 1, y - 1, turn, this) && checkCheck(turn, x + 1, y - 1);

		for (int i = 0; i < 8; i++) {
			if (kingMoves[i] == false)
				return false;
		}

		return true;
	}

	// Helper Function for checkCheckMate. Passes in the possible escape
	// coordinates for King and sees if those also put the King in Check
	/**
	 * Helper function for checkCheckMate. Takes into account if every one of kings possible moves
	 * still keeps the game in check
	 * @param turn
	 * @param KingX
	 * @param KingY
	 * @return
	 */
	public boolean checkCheck(int turn, int KingX, int KingY) {
		Piece check;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				check = this.getPiece(i, j);

				// if There is a piece in that spot
				if (check != null) {
					// if White is Trying to CheckMate
					if (turn == 0 && check.getColor() == color.WHITE) {
						if (check.checkDestination(KingX, KingY, turn, this))
							return true;
					}
					// if Black is Trying to CheckMate
					if (turn == 1 && check.getColor() == color.BLACK) {
						if (check.checkDestination(KingX, KingY, turn, this))
							return true;
					}

				}

			}
		}
		return false;
	}

}
