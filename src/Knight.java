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
}