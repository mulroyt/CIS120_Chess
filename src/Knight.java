/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;

/**
 * Knight class
 * 
 * extends the ChessPiece abstract class
 * The knight piece can move in 'L' shape, 2 squares out, 1 over
 **/

public class Knight extends ChessPiece {
	
	public Knight(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2658");
		} else {
			super.setPieceCode("\u265E"); 
		}
	}
	
	// TODO the game logic for how it is allowed to move
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
}