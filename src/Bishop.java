/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;

/**
 * Bishop class
 * 
 * extends the ChessPiece abstract class
 * The rook piece can move in straight lines the entire length of the board
 **/

public class Bishop extends ChessPiece {
	
	public Bishop(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2657");
		} else {
			super.setPieceCode("\u265D"); 
		}
	}
	
	// TODO the game logic for how it is allowed to move
}