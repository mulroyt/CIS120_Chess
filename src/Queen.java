/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.Color;
import java.util.TreeSet;
import java.util.Set;

/**
 * Queen class
 * 
 * extends the ChessPiece abstract class
 * The queen piece can move in any direction, the entire length of the board
 **/

public class Queen extends ChessPiece {
	
	private Set<Position> legalMoves;
	
	public Queen(Position pos, Color c) {
		super(pos, c);
		
		if (c == Color.white) {
			super.setPieceCode("\u2655");
		} else {
			super.setPieceCode("\u265B"); 
		}
		
		legalMoves = new TreeSet<Position>();
	}
	
	/* the game logic for how it is allowed to move
	 */ 
	public boolean legalMove(Position start, Position end, ChessPiece[][] boardState) {
		int sX = start.getX();
        int sY = start.getY();
        int eX = end.getX();
        int eY = end.getY();
		
        // diagonal moves
		if (Math.abs(sX - eX) == Math.abs(sY - eY)) {
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
		// straight line moves
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
				for (int i = eY + 1; i < sY; i++) {
					if (boardState[eX][i] != null) {
						return false;
					}
				}
				return true;
			}
		} else {return false;}
		
	}
	
	/* The set of legal moves. Store the available moves in a set that is updated after a piece
	 * moves. This set can be used for determining the state of the game i.e.
	 * check/checkmate/stalemate
	 */
	public void setOfLegalMoves(Position start, ChessPiece[][] boardState) {
		legalMoves.clear();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (legalMove(start, new Position(i, j), boardState)) {
					legalMoves.add(new Position(i, j));
				}
			}
		}
	}
	
	/* method to test membership of the legalMoves set */
	public boolean isLegal(Position end) {
		return legalMoves.contains(end);
	}
}