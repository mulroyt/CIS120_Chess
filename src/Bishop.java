/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;
import java.util.TreeSet;
import java.util.Set;

/**
 * Bishop class
 * 
 * extends the ChessPiece abstract class
 * The rook piece can move in straight lines the entire length of the board
 **/

public class Bishop extends ChessPiece {
	private Set<Position> legalMoves;
	
	public Bishop(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2657");
		} else {
			super.setPieceCode("\u265D"); 
		}
		
		legalMoves = new TreeSet<Position>();
	}
	
	/* The game logic for how it is allowed to move */
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
		
		if (Math.abs(sX - eX) != Math.abs(sY - eY)) {
            return false;
		}
		if (sX < eX && sY < eY) { 
			for (int i = 1; i < eX - sX; i++) {
				if (boardState[sX + i][sY + 1] != null) {
					return false;
				}
			} return true; 
		}
		if (eX < sX && eY < sY) {
			for (int i = 1; i < sX - eX; i++) {
				if (boardState[sX - i][sY - i] != null) {
					return false;
				}
			} return true;
		}
		if (sX < eX && eY < sY) {
			for (int i = 1; i < eX - sX; i++) {
				if (boardState[sX + i][sY - i] != null) {
					return false;
				}
			} return true;
		} else {
			for (int i = 1; i < sX - eX; i++) {
				if (boardState[sX - i][sY + i] != null) {
					return false;
				}
			} return true;
		}
	}
	
	/* the set of legal moves */
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