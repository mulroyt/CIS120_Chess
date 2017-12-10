/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;
import java.util.TreeSet;
import java.util.Set;
/**
 * Pawn class
 * 
 * extends the ChessPiece abstract class
 * The pawn piece can move forward 1 square at a time, if it is capturing a peice, it must move 
 * forward diagonally, on its first move it may move two spaces forward (add a special field)
 **/

public class Pawn extends ChessPiece {
	private Color c;
	private Set<Position> legalMoves;
	
	public Pawn(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2659");
		} else {
			super.setPieceCode("\u265F"); 
		}
		legalMoves = new TreeSet<Position>();
		this.c = c;
	}
	
	// The game logic for how it is allowed to move
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
		int sY = start.getY();
		int eX = end.getX();
		int eY = end.getY();
		ChessPiece endSquare = boardState[eX][eY];
		
		if (c == Color.WHITE) {
			if (Math.abs(sX - eX) == 1 && sY - eY == 1 && endSquare != null) {
				if (endSquare.getColor() == Color.BLACK) {
				return true;
				}
			}
			if (sY - eY == 2 && sY == 6 && sX - eX == 0 && endSquare == null) {
				return true;
			} else if (sY - eY == 1 && sX - eX == 0 && endSquare == null) {
				return true;
			} else {return false;}
		} else if (Math.abs(sX - eX) == 1 && eY - sY == 1 && endSquare != null) {
			if (endSquare.getColor() == Color.WHITE) {
			    return true;
			}
		}
	    if (eY - sY == 2 && sY == 1 && sX - eX == 0 && endSquare == null) {
			return true;
		} else if (eY - sY == 1 && sX - eX == 0 && endSquare == null) {
			return true;
		}
		return false;
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