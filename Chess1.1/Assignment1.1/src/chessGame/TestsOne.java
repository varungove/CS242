package chessGame;

import static org.junit.Assert.*;


import org.junit.Test;

import chessGame.Piece.color;

public class TestsOne {

	//Testing that white part of board is set up
	@Test
	public void testBoardWhite() 
	{
		ChessBoard testBoard = new ChessBoard();
		assertEquals(testBoard.getPiece(1, 1).getColor(), color.WHITE);
		
	}
	
	//Testing that black part of board is set up
	@Test
	public void testBoardBlack() 
	{
		ChessBoard testBoard = new ChessBoard();
		assertEquals(testBoard.getPiece(7, 7).getColor(), color.BLACK);
		
	}
	
	//Testing if making a good selection works
	@Test
	public void testSelectionGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		assertTrue(testBoard.checkSelection(7, 7, 1));
		
	}
	
	//Testing if making a bad selection doesn't work
	@Test
	public void testSelectionBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		assertFalse(testBoard.checkSelection(0, 0, 1));
		
	}
	
	//Testing the move capability (Arbitrary)
	@Test
	public void testMakeMove() 
	{
		ChessBoard testBoard = new ChessBoard();
		testBoard.makeMove(0, 1, 0, 2);
		assertNotNull(testBoard.getPiece(0,2));
		
	}
	
	//Testing moving the pawn to a possible location
	@Test
	public void checkDestinationPawnGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(0, 1);
		assertTrue(checkPiece.checkDestination(0, 3, 0, testBoard));
		
	}
	
	//Testing moving the pawn to a bad location
	@Test
	public void checkDestinationPawnBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(0, 1);
		assertFalse(checkPiece.checkDestination(0, 4, 0, testBoard));
		
	}
	
	//Testing moving the rook to a possible location
	@Test
	public void checkDestinationRookGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(0, 0);
		testBoard.makeMove(0, 1, 0, 3);
		assertTrue(checkPiece.checkDestination(0, 2, 0, testBoard));
		
	}
	
	//Testing moving the rook to a bad location
	@Test
	public void checkDestinationRookBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(0, 0);
		assertFalse(checkPiece.checkDestination(0, 4, 0, testBoard));
		
	}
	
	//Testing moving the knight to a possible location
	@Test
	public void checkDestinationKnightGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(1, 0);
		assertTrue(checkPiece.checkDestination(0, 2, 0, testBoard));
		
	}
	
	//Testing moving the knight to a bad location
	@Test
	public void checkDestinationKnightBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(0, 0);
		assertFalse(checkPiece.checkDestination(3, 4, 0, testBoard));
		
	}
	
	//Testing moving the Bishop to a possible location
	@Test
	public void checkDestinationBishopGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(2, 0);
		testBoard.makeMove(1, 1, 1, 3);
		assertTrue(checkPiece.checkDestination(0, 2, 0, testBoard));
		
	}
	
	//Testing moving the Bishop to a bad location
	@Test
	public void checkDestinationBishopBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(2, 0);
		assertFalse(checkPiece.checkDestination(1, 7, 0, testBoard));
		
	}
	
	//Testing moving the queen to a possible location
	@Test
	public void checkDestinationQueenGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(4, 0);
		testBoard.makeMove(4, 1, 4, 3);
		assertTrue(checkPiece.checkDestination(4, 2, 0, testBoard));
		
	}
	
	//Testing moving the queen to a bad location
	@Test
	public void checkDestinationQueenBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(4, 0);
		assertFalse(checkPiece.checkDestination(5, 5, 0, testBoard));
		
	}
	
	//Testing moving the king to a possible location
	@Test
	public void checkDestinationKingGood() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(3, 7);
		testBoard.makeMove(2, 6, 2, 4);
		assertTrue(checkPiece.checkDestination(2, 6, 0, testBoard));
		
	}
	
	//Testing moving the king to a bad location
	@Test
	public void checkDestinationKingBad() 
	{
		ChessBoard testBoard = new ChessBoard();
		Piece checkPiece = testBoard.getPiece(3, 7);
		assertFalse(checkPiece.checkDestination(7, 3, 0, testBoard));
		
	}

}
