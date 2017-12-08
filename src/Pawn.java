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
	
	public Pawn(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2659");
		} else {
			super.setPieceCode("\u265F"); 
		}
	}
	
	// TODO the game logic for how it is allowed to move
}