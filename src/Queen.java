/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * Queen class
 * 
 * extends the ChessPiece abstract class
 * The queen piece can move in any direction, the entire length of the board
 **/

public class Queen extends ChessPiece {
	private char pieceCode = 2656; // is this the right unicode
	
	//method to set the correct unicode based on the color
	//DO I NEED TO DO THIS OR WILL IT WORK IF I DRAW THE GRAPHICS WITH THE CORRECT COLOR?
	private char setPieceCode(Color c) {
		if (c == Color.white) {
			return pieceCode = 2655;
		} else {
			return pieceCode = 265C; // the unicode on wikepedia has a letter in it???
		}
	}
	
	//constructor
	public Queen(Position pos, Color c) {
		super(pos, pieceCode, c);
		
	}
	
	// TODO the game logic for how it is allowed to move
}