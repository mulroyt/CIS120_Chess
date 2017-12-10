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
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
		
		if (Math.abs(sX - eX) != Math.abs(sY - eY)) {
            return false;
		}
		if (sX < eX && sY < eY) { 
			for (int i = 1; i < eX - sX; i++) {
				if (boardState[sX + i][sY + 1] != null) {
					return false;
				}
			} return true; 
		}
		if (eX < sX && eY < sY) {
			for (int i = 1; i < sX - eX; i++) {
				if (boardState[sX - i][sY - i] != null) {
					return false;
				}
			} return true;
		}
		if (sX < eX && eY < sY) {
			for (int i = 1; i < eX - sX; i++) {
				if (boardState[sX + i][sY - i] != null) {
					return false;
				}
			} return true;
		} else {
			for (int i = 1; i < sX - eX; i++) {
				if (boardState[sX - i][sY + i] != null) {
					return false;
				}
			} return true;
		}
	}
}