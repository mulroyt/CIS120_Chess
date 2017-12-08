/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;

/**
 * Queen class
 * 
 * extends the ChessPiece abstract class
 * The queen piece can move in any direction, the entire length of the board
 **/

public class Queen extends ChessPiece {
	
	public Queen(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2655");
		} else {
			super.setPieceCode("\u265B"); 
		}
	}
	
	// TODO the game logic for how it is allowed to move
}