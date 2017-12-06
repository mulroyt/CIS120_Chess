/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * King class
 * 
 * extends the ChessPiece abstract class
 * The King piece can move in any direction, one space per move
 **/

public class King extends ChessPiece {
	private char pieceCode = 2656; // is this the right unicode
	
	//method to set the correct unicode based on the color
	//DO I NEED TO DO THIS OR WILL IT WORK IF I DRAW THE GRAPHICS WITH THE CORRECT COLOR?
	private char setPieceCode(Color c) {
		if (c == Color.white) {
			return pieceCode = 2654;
		} else {
			return pieceCode = 265C; // the unicode on wikepedia has a letter in it???
		}
	}
	
	//constructor
	public King(Position pos, Color c) {
		super(pos, pieceCode, c);
		
	}
	
	// TODO the game logic for how it is allowed to move
}