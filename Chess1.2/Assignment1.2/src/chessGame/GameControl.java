package chessGame;

import chessGame.Piece.color;
import chessGame.Piece.type;

/**
 * @author Varun Goverdhan 
 * Control - Main Game Loop
 */
public class GameControl {

	private Piece selectedPiece;
	private static ChessBoard gameBoard;
	private int turn;
	private static GUI gameView;
	GameControl backUp;
	int oldX, newX, oldY, newY;
	Piece undo;
	Piece undoTemp;

	/**
	 * Constructor for GameControl
	 */
	public GameControl() {
		gameBoard = new ChessBoard();
		gameView = new GUI(this, gameBoard);
		selectedPiece = null;
		oldX = newX = oldY = turn = newY = 0;
	}

	/**
	 * Getter for selectedPiece
	 * 
	 * @return current selectedPiece
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * Getter for Turn
	 * 
	 * @return current player's turn
	 */
	public int getTurn() {
		return this.turn;
	}

	/**
	 * Setter For Turn
	 * 
	 * @param x
	 */
	public void setTurn(int x) {
		turn = x;
	}

	/**
	 * Checks if player selected the right piece
	 * 
	 * @param x
	 * @param y
	 */
	public void selecting(int x, int y) {
		Boolean check = gameBoard.checkSelection(x, y, turn);

		if (check)
			selectedPiece = gameBoard.getPiece(x, y);
		else
			System.out.println("Selected Wrong Piece");
	}

	/**
	 * Makes the move
	 * 
	 * @param x
	 * @param y
	 */
	public void makeMove(int x, int y) {
		gameView.flag = false;
		Boolean check = selectedPiece.checkDestination(x, y, turn, gameBoard);

		if (check) {
			backUp = this;
			int oldx = selectedPiece.getX();
			int oldy = selectedPiece.getY();
			undo = gameBoard.getPiece(x, y);
			gameBoard.makeMove(oldx, oldy, x, y);
			gameView.updateBoard(oldx, oldy, x, y, selectedPiece);
			selectedPiece = null;
			turn = 1 - turn;
			newX = oldx;
			newY = oldy;
			oldX = x;
			oldY = y;
			checkGameStatus();
		} else {
			System.out.println("Invalid Destination");
		}
	}

	/**
	 * Checks the Status of the game. (Game Over/Check/CheckMate)
	 */
	public void checkGameStatus() {

		if (gameBoard.checkCheck(turn)) {

			if (gameBoard.checkCheckMate(turn)) {
				System.out.println("CHECK MATE! Game over");
				turn = 3;
			} else
				System.out.println("CHECK");
		}

		if (gameBoard.kingStatus()) {
			turn = 3;
			System.out.println("Game Over!");
		}
	}

	/**
	 * Prompts user of a restart request
	 */
	public void promptRestart() {
		gameView.menuButtons[0].setVisible(false);
		gameView.menuButtons[1].setVisible(false);
		gameView.menuButtons[2].setVisible(false);
		gameView.menuButtons[3].setVisible(false);
		gameView.menuButtons[4].setVisible(true);
		gameView.menuButtons[5].setVisible(true);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gameView.buttons[i][j].setVisible(false);
			}
		}

		turn = 1 - turn;
	}

	/**
	 * Restarts the game
	 */
	public void restart() {
		turn = 0;
		selectedPiece = null;
		gameBoard = new ChessBoard();
		gameView = new GUI(this, gameBoard);
		resetScreen();
		gameView.view.revalidate();
	}

	/**
	 * Resets the screen making all buttons visible
	 */
	public void resetScreen() {
		gameView.menuButtons[0].setVisible(true);
		gameView.menuButtons[1].setVisible(true);
		gameView.menuButtons[2].setVisible(true);
		gameView.menuButtons[3].setVisible(true);
		gameView.menuButtons[4].setVisible(false);
		gameView.menuButtons[5].setVisible(false);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gameView.buttons[i][j].setVisible(true);
			}
		}

	}

	/**
	 * Ends game if one of the player's forfeits
	 */
	public void forfeit() {
		System.out.println("Player " + turn + " Forfiets!");
		turn = 3;
	}

	/**
	 * Undoes players last move
	 */

	public void undo() {
		Piece check = gameBoard.getPiece(oldX, oldY);
		if (check != null) {
			undoTemp = undo;
			gameBoard.makeMove(oldX, oldY, newX, newY);

			gameView.updateBoard(oldX, oldY, newX, newY, check);
			if (undoTemp != null) {
				gameBoard.board[oldX][oldY] = undoTemp;
				gameView.updateBoard(oldX, oldY, oldX, oldY, undoTemp);
			}
			selectedPiece = null;
			turn = 1 - turn;
		}
	}

	/**
	 * Puts the custom pieces into play. Only happens for 1st round of game
	 */
	public void custom() {
		gameBoard.board[0][1] = new CustomOne(0, 1, color.WHITE, type.CUSTOMONE);
		gameBoard.board[0][6] = new CustomOne(0, 6, color.BLACK, type.CUSTOMONE);
		gameBoard.board[7][1] = new CustomOne(7, 1, color.WHITE, type.CUSTOMTWO);
		gameBoard.board[7][6] = new CustomOne(7, 6, color.BLACK, type.CUSTOMTWO);
	}

	/**
	 * Entry main() Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new GameControl();
	}

}
