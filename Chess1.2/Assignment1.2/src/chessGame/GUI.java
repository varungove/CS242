package chessGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chessGame.Piece.color;
import chessGame.Piece.type;

/**
 * @author Varun Goverdhan 
 * View - Controls the GUI implementation of the game
 */
@SuppressWarnings("serial")
public class GUI extends Frame {

	JButton buttons[][] = new JButton[8][8];
	JButton menuButtons[] = new JButton[6];
	boolean flag = true;
	JPanel view;

	/**
	 * Constructor that setups the GUI components
	 */
	public GUI(GameControl game, ChessBoard gameBoard) {

		view = new JPanel();
		view.setPreferredSize(new Dimension(600, 600));
		view.setLayout(new GridLayout(9, 8));
		JFrame window = new JFrame("Chess");

		colorGrid(view);
		setDefaultPieces();
		setMenu(view, game, gameBoard);
		listen(game, gameBoard);

		window.setSize(625, 650);
		window.setContentPane(view);
		window.setVisible(true);
	}

	/**
	 * Colors the squares gray and white
	 * 
	 * @param view
	 */
	private void colorGrid(JPanel view) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[j][i] = new JButton();
				buttons[j][i].setActionCommand("" + j + " " + i);

				if ((i + j) % 2 == 0)
					buttons[j][i].setBackground(Color.white);
				else
					buttons[j][i].setBackground(Color.gray);

				buttons[j][i].setOpaque(true);
				buttons[j][i].setBorderPainted(false);
				view.add(buttons[j][i]);
			}
		}

	}

	/**
	 * Sets Menu Buttons and ActionListeners for Each Button. (Restart, Forfeit,
	 * Undo, Custom, Yes, No)
	 * 
	 * @param view
	 * @param game
	 * @param gameBoard
	 */
	public void setMenu(JPanel view, GameControl game, ChessBoard gameBoard) {
		menuButtons[0] = new JButton();
		menuButtons[0].setText("Restart");
		view.add(menuButtons[0]);

		menuButtons[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.promptRestart();
				view.revalidate();
			}

		});

		menuButtons[1] = new JButton();
		menuButtons[1].setText("Forfeit");
		view.add(menuButtons[1]);

		menuButtons[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.forfeit();
			}

		});

		menuButtons[2] = new JButton();
		menuButtons[2].setText("Undo");
		view.add(menuButtons[2]);

		menuButtons[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.undo();
				view.revalidate();
			}

		});

		menuButtons[3] = new JButton();
		menuButtons[3].setText("Custom Game");
		view.add(menuButtons[3]);

		menuButtons[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (flag) {
					buttons[0][1].setIcon(null);
					buttons[0][1].setText(String.valueOf('\u260E'));
					buttons[0][6].setIcon(null);
					buttons[0][6].setText(String.valueOf('\u260F'));

					buttons[7][1].setIcon(null);
					buttons[7][1].setText(String.valueOf('\u2605'));
					buttons[7][6].setIcon(null);
					buttons[7][6].setText(String.valueOf('\u2606'));

					game.custom();

					flag = false;
				}
			}

		});

		menuButtons[4] = new JButton();
		menuButtons[4].setText("Yes");
		view.add(menuButtons[4]);
		menuButtons[4].setVisible(false);

		menuButtons[4].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.restart();
				view.revalidate();
			}

		});

		menuButtons[5] = new JButton();
		menuButtons[5].setText("No");
		view.add(menuButtons[5]);
		menuButtons[5].setVisible(false);

		menuButtons[5].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.resetScreen();
				view.revalidate();
				game.setTurn(1 - game.getTurn());

			}

		});
	}

	/**
	 * Sets the default pieces in position
	 */
	void setDefaultPieces() {
		ImageIcon img;

		for (int i = 0; i < 8; i++) {
			img = new ImageIcon("images/pawnWhite.png");
			buttons[i][6].setIcon(img);
		}

		for (int i = 0; i < 8; i++) {
			img = new ImageIcon("images/pawnBlack.png");
			buttons[i][1].setIcon(img);
		}

		img = new ImageIcon("images/rookWhite.png");
		buttons[0][7].setIcon(img);
		img = new ImageIcon("images/knightWhite.png");
		buttons[1][7].setIcon(img);
		img = new ImageIcon("images/bishopWhite.png");
		buttons[2][7].setIcon(img);
		img = new ImageIcon("images/kingWhite.png");
		buttons[3][7].setIcon(img);
		img = new ImageIcon("images/queenWhite.png");
		buttons[4][7].setIcon(img);
		img = new ImageIcon("images/bishopWhite.png");
		buttons[5][7].setIcon(img);
		img = new ImageIcon("images/knightWhite.png");
		buttons[6][7].setIcon(img);
		img = new ImageIcon("images/rookWhite.png");
		buttons[7][7].setIcon(img);

		img = new ImageIcon("images/rookBlack.png");
		buttons[0][0].setIcon(img);
		img = new ImageIcon("images/knightBlack.png");
		buttons[1][0].setIcon(img);
		img = new ImageIcon("images/bishopBlack.png");
		buttons[2][0].setIcon(img);
		img = new ImageIcon("images/kingBlack.png");
		buttons[3][0].setIcon(img);
		img = new ImageIcon("images/queenBlack.png");
		buttons[4][0].setIcon(img);
		img = new ImageIcon("images/bishopBlack.png");
		buttons[5][0].setIcon(img);
		img = new ImageIcon("images/knightBlack.png");
		buttons[6][0].setIcon(img);
		img = new ImageIcon("images/rookBlack.png");
		buttons[7][0].setIcon(img);
	}

	/**
	 * Updates the GUI board when a piece has moved.
	 * 
	 * @param oldx
	 * @param oldy
	 * @param x
	 * @param y
	 * @param check
	 */
	@SuppressWarnings("static-access")
	public void updateBoard(int oldx, int oldy, int x, int y, Piece check) {
		oldy = 7 - oldy;
		y = 7 - y;
		ImageIcon img;

		buttons[oldx][oldy].setIcon(null);
		buttons[oldx][oldy].setText("");

		type type = check.getType();
		color color = check.getColor();

		switch (type) {
		case PAWN:
			if (color == color.WHITE) {
				img = new ImageIcon("images/pawnWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/pawnBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case BISHOP:
			if (color == color.WHITE) {
				img = new ImageIcon("images/bishopWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/bishopBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case ROOK:
			if (color == color.WHITE) {
				img = new ImageIcon("images/rookWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/rookBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case KING:
			if (color == color.WHITE) {
				img = new ImageIcon("images/kingWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/kingBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case QUEEN:
			if (color == color.WHITE) {
				img = new ImageIcon("images/queenWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/queenBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case KNIGHT:
			if (color == color.WHITE) {
				img = new ImageIcon("images/knightWhite.png");
				buttons[x][y].setIcon(img);
			} else {
				img = new ImageIcon("images/knightBlack.png");
				buttons[x][y].setIcon(img);
			}
			break;
		case CUSTOMONE:
			if (color == color.WHITE) {
				buttons[x][y].setText(String.valueOf('\u260F'));
			} else {
				buttons[x][y].setText(String.valueOf('\u260E'));
			}
			break;
		case CUSTOMTWO:
			if (color == color.WHITE) {
				buttons[x][y].setText(String.valueOf('\u2606'));
			} else {
				buttons[x][y].setText(String.valueOf('\u2605'));
			}
			break;

		}
	}

	/**
	 * ActionListener for all the Board squares.
	 * 
	 * @param game
	 * @param gameBoard
	 */
	public void listen(GameControl game, ChessBoard gameBoard) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						JButton button = (JButton) e.getSource();
						String str = button.getActionCommand();
						int x = Character.getNumericValue(str.charAt(0));
						int y = Character.getNumericValue(str.charAt(2));

						// Selecting Piece
						if (game.getSelectedPiece() == null) {
							game.selecting(x, 7 - y);
						}
						// Selection Destination
						else {
							game.makeMove(x, 7 - y);
						}
					}

				});

			}

		}
	}

}