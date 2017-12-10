/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;

/**
 * King class
 * 
 * extends the ChessPiece abstract class
 * The King piece can move in any direction, one space per move
 **/

public class King extends ChessPiece {
	
	public King(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2654");
		} else {
			super.setPieceCode("\u265A"); 
		}
	}
	
	// TODO the game logic for how it is allowed to move
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
}