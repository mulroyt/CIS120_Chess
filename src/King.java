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
}