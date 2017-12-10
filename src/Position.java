/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

// need to import the java array tools

/* the position hold the position of a chess piece as an alpha numeric pair
* it maintains that the position is on the board
* */

public class Position implements Comparable<Object> {
	
	/* store the position as an int for the row and an int for the column
	 */
	
	private int x_pos;
	private int y_pos;
	
	// constructor
	public Position(int x, int y) {
		if (x < 8 && x >= 0) {
			this.x_pos = x;
		} else {
			throw new IndexOutOfBoundsException();
		}
	    if (y < 8 && y >= 0) {
	    	this.y_pos = y;
	    } else {
	    	throw new IndexOutOfBoundsException();
	    }
	}
	
	// getter
	public int getX() {
		return this.x_pos;
	}
	
	public int getY() {
		return this.y_pos;
	}
	
	// setter
	public void setX(int x) {
		if (x < 8 && x >= 0) {
			this.x_pos = x;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void setY(int y) {
		 if (y < 8 && y >= 0) {
		    	this.y_pos = y;
		    } else {
		    	throw new IndexOutOfBoundsException();
		    }
	}

	@Override
	public int compareTo(Object otherPos) {
		if (otherPos.getClass() == Position.class) {
			Position pos = (Position) otherPos;
			if (this.x_pos*10 + y_pos < pos.getX()*10 + pos.getY()) {
				return -1;
			} else if (this.x_pos*10 + y_pos > pos.getX()*10 + pos.getY()) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}