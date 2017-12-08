/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.Color;

/**
 * Rook class
 * 
 * extends the ChessPiece abstract class
 * The rook piece can move in straight lines the entire length of the board
 **/

public class Rook extends ChessPiece {
	
	public Rook(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2656");
		} else {
			super.setPieceCode("\u265C"); 
		}
		
	}
	
	// TODO the game logic for how it is allowed to move
	
	//delegates the drawing to the super class
	@Override 
	public void draw(Graphics g) {
		super.draw(g);
	}
}