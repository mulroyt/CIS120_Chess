/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;
import java.util.TreeSet;
import java.util.Set;

/**
 * Knight class
 * 
 * extends the ChessPiece abstract class
 * The knight piece can move in 'L' shape, 2 squares out, 1 over
 **/

public class Knight extends ChessPiece {
	
	private Set<Position> legalMoves;
	
	public Knight(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2658");
		} else {
			super.setPieceCode("\u265E"); 
		}
		
		legalMoves = new TreeSet<Position>();
	}
	
	
	/* the game logic for how it is allowed to move
	 * Store the available moves in a set that is updated after a piece moves. This set can be used 
	 * for determining the state of the game i.e. check/checkmate/stalemate
	 */ 
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
        
        if (Math.abs(sX - eX) == 1 && Math.abs(sY- eY) == 2) {
        	return true;
        } else if (Math.abs(sX - eX) == 2 && Math.abs(sY- eY) == 1) {
        	return true;
        }
		return false;
	}
	/* would it be faster to build the set of legal moves upon the construction of the piece, and 
	 * update it every time the piece is moved? and then when attempted to move the piece, check 
	 * the end square for the membership of this set?? 
	 */
	public void setOfLegalMoves(Position start, ChessPiece[][] boardState) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (legalMove(start, new Position(i, j), boardState)) {
					legalMoves.add(new Position(i, j));
				}
			}
		}
	}
	
	/* method to test membership of the legalMoves set */
	public boolean isLegal(Position end) {
		return legalMoves.contains(end);
	}
}