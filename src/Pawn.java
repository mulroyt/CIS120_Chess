/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;

/**
 * Pawn class
 * 
 * extends the ChessPiece abstract class
 * The pawn piece can move forward 1 square at a time, if it is capturing a peice, it must move 
 * forward diagonally, on its first move it may move two spaces forward (add a special field)
 **/

public class Pawn extends ChessPiece {
	private Color c;
	
	public Pawn(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2659");
		} else {
			super.setPieceCode("\u265F"); 
		}
		
		this.c = c;
	}
	
	// TODO the game logic for how it is allowed to move
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
	
}