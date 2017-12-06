/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

// need to import the java array tools

/* the position hold the position of a chess piece as an alpha numeric pair
* it maintains that the position is on the board
* */

public class Position {
	
	/* following the standard convention the row is stored as an integer
	 * the column is stored as a Char 
	 */
	
	private int row;
	private int col;
	
	// constructor
	public Position(int row, int col) {
		if (row < 9 && row > 0) {
			this.row = row;
		} else {
			throw new IndexOutOfBoundsException();
		}
	    if (col < 9 && col > 0) {
	    	this.col = col;
	    } else {
	    	throw new IndexOutOfBoundsException();
	    }
	}
	
	// getter
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	// setter
	public void setRow(int newRow) {
		if (row < 9 && row > 0) {
			this.row = newRow;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void setCol(int newCol) {
		 if (col < 9 && col > 0) {
		    	this.col = newCol;
		    } else {
		    	throw new IndexOutOfBoundsException();
		    }
	}
}