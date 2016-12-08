package chessGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Varun Goverdhan
 * Controls the GUI implementation of the game
 */
@SuppressWarnings("serial")
public class GUI extends Frame {

	ChessBoard gameBoard = new ChessBoard();
	JButton buttons[][] = new JButton[8][8];

	
	/**
	 * Constructor that setups the GUI components
	 */
	public GUI() {
		JPanel view = new JPanel();
		view.setPreferredSize(new Dimension(600, 600));
		view.setLayout(new GridLayout(8, 8));
		JFrame window = new JFrame("Chess");

		colorGrid(view);
		setDefaultPieces();

		window.setSize(625, 650);
		window.setContentPane(view);
		window.setVisible(true);
	}

	/**
	 * Colors the squares gray and white
	 * @param view
	 */
	private void colorGrid(JPanel view) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[j][i] = new JButton();

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
	 * Sets the default pieces in position
	 * TODO: Switch to Unicode instead 
	 */
	private void setDefaultPieces() {
		ImageIcon img;
		
		for (int i = 0; i < 8; i++) {
			img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/pawnWhite.png");
			buttons[i][6].setIcon(img);
		}

		
		for (int i = 0; i < 8; i++) {
			img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/pawnBlack.png");
			buttons[i][1].setIcon(img);
		}

		
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/rookWhite.png");
		buttons[0][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/knightWhite.png");
		buttons[1][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/bishopWhite.png");
		buttons[2][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/kingWhite.png");
		buttons[3][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/queenWhite.png");
		buttons[4][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/bishopWhite.png");
		buttons[5][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/knightWhite.png");
		buttons[6][7].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/rookWhite.png");
		buttons[7][7].setIcon(img);

		
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/rookBlack.png");
		buttons[0][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/knightBlack.png");
		buttons[1][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/bishopBlack.png");
		buttons[2][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/kingBlack.png");
		buttons[3][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/queenBlack.png");
		buttons[4][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/bishopBlack.png");
		buttons[5][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/knightBlack.png");
		buttons[6][0].setIcon(img);
		img = new ImageIcon("/Users/varungove/Documents/workspace/Chess/images/rookBlack.png");
		buttons[7][0].setIcon(img);
	}

	
	/**
	 * Entry main() Method
	 * @param args
	 */
	public static void main(String[] args) {
		
		new GUI();
	}

}