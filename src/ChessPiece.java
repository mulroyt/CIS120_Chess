/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */


import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** A chess piece in the game
 * 
 * chess pieces exist on the game board represented as a 2-d array
 * each piece stores its own location
 * each piece stores its own Graphic representation
 */

public abstract class ChessPiece {
	
	/* stores the position of the piece
	 * must be between 0-8 for row and A-H for col
	 */
	private Position pos;
	
	// the representative image of the piece
	private String imageFile;
	private static BufferedImage img;
	public static final int IMG_WIDTH = 10;
	public static final int IMG_HEIGHT = 10; // need to figure out how big to make these pieces, final b/c all are the same size
	
	// constructor
	public ChessPiece(Position pos, String imageFile) {
		this.pos = pos;
		this.imageFile = imageFile; //this is probably pointless
		
		try {
            if (img == null) {
                img = ImageIO.read(new File(this.imageFile));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
	}
	
	// move takes in a new position and calls the set methods in the position class
	public void move(int row, char col) {
		pos.setRow(row);
		pos.setCol(col);
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, this.pos.getRow(), this.pos.getCol(), IMG_WIDTH, IMG_HEIGHT, null);
	}
	 
}