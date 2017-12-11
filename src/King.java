/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;
import java.util.TreeSet;
import java.util.Set;

/**
 * King class
 * 
 * extends the ChessPiece abstract class
 * The King piece can move in any direction, one space per move
 **/

public class King extends ChessPiece {
	
	private Set<Position> legalMoves;
	
	public King(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2654");
		} else {
			super.setPieceCode("\u265A"); 
		}
		
		legalMoves = new TreeSet<Position>();
	}
	
	// The game logic for how it is allowed to move
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
        int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
        
        if (Math.abs(sX - eX) < 2 && Math.abs(sY - eY) < 2) {
        	return true;
        }
		
		return false;
	}
	
	/* set of legal moves */
	public void setOfLegalMoves(Position start, ChessPiece[][] boardState) {
		legalMoves.clear();
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