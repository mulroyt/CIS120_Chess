/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

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
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
		
		if (Math.abs(sX - eX) > 0 && sY - eY == 0) {
			if (eX > sX) {
				for (int i = sX + 1; i < eX; i++) {
					if (boardState[i][eY] != null) {
						return false;
					}
				} 	
				return true;
			} else {
				for (int i = eX + 1; i < sX; i++) {
					if (boardState[i][eY] != null) {
						return false;
					}
				}
				return true;
			}			
		} else if (sX - eX == 0 && Math.abs(sY - eY) > 0) {
			if (eY > sY) {
				for (int i = sY + 1; i < eY; i++) {
					if (boardState[eX][i] != null) {
						return false;
					}
				} 
				return true;
			} else {
				for (int i = eY + 1; i < sY - eY; i++) {
					if (boardState[eX][i] != null) {
						return false;
					}
				}
				return true;
			}
		} else {return false;}	
	}
	
}