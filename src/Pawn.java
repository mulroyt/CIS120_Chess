/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * Pawn class
 * 
 * extends the ChessPiece abstract class
 * The pawn piece can move forward 1 square at a time, if it is capturing a peice, it must move 
 * forward diagonally, on its first move it may move two spaces forward (add a special field)
 **/

public class Pawn extends ChessPiece {
	private char pieceCode = 2659; // is this the right unicode
	
	//method to set the correct unicode based on the color
	//DO I NEED TO DO THIS OR WILL IT WORK IF I DRAW THE GRAPHICS WITH THE CORRECT COLOR?
	private char setPieceCode(Color c) {
		if (c == Color.white) {
			return pieceCode = 2656;
		} else {
			return pieceCode = 265C; // the unicode on wikepedia has a letter in it???
		}
	}
	
	//constructor
	public Pawn(Position pos, Color c) {
		super(pos, pieceCode, c);
		
	}
	
	// TODO the game logic for how it is allowed to move
}