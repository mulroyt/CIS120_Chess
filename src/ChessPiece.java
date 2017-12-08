/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */


import java.awt.Graphics;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.*;

/** A chess piece in the game
 * 
 * chess pieces exist on the game board represented as a 2-d array
 * each piece stores its own location
 * each piece stores its own Graphic representation
 */

public abstract class ChessPiece {
	
	/* stores the position of the piece
	 * must be between 0-8 
	 */
	private Position pos;
	// center of the piece location in the square
	private int graphicsRow;
	private int graphicsCol;
	// height of each square on the screen
	public static final int SQ_HEIGHT = 150;
	
	// the representative image of the piece
	// private String imageFile;
	// private static BufferedImage img;
	public static final int IMG_WIDTH = 100;
	public static final int IMG_HEIGHT = 100; // need to figure out how big to make these pieces, final b/c all are the same size
	
	// instead of an image use the unicode characters for chess pieces
	private String pieceCode; // TODO Need to update it to store as a string
	
	// need to store what color the piece is??
	private Color c;
	
	// constructor
	public ChessPiece(Position pos, Color c) {
		this.pos = pos;
		// need to map the position on the board to the graphics location on the screen
		this.graphicsRow = pos.getRow()*SQ_HEIGHT + SQ_HEIGHT/2;
		this.graphicsCol = pos.getCol()*SQ_HEIGHT + SQ_HEIGHT/2;
		
		// this.imageFile = imageFile; //this is probably pointless
		
		// this.pieceCode = pieceCode;
		
		this.c = c; // setting the color of the piece
		
		/* try {
            if (img == null) {
                img = ImageIO.read(new File(this.imageFile));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } */
		
	
	}
	
	/* Method to set the piece code to only be called by the constructor of the specific piece
	 * i.e. the rook's constructor will set the piece code depending on the color called for  
	 */
	public void setPieceCode(String code) {
		this.pieceCode = code;
	}
	
	// methods for click and drag moving of pieces
	//TODO listeners etc to move pieces see the paint code for combination of button// line previews in canvas
	
	public Color getColor() {
		return this.c;
	}
	
	// move takes in a new position and calls the set methods in the position class
	public void move(int row, int col) {
		// call the function in the instance to see if it is a legal move?
		pos.setRow(row);
		pos.setCol(col);
		// when the piece moves it needs to update the graphics position
		graphicsRow = pos.getRow()*SQ_HEIGHT + SQ_HEIGHT/2;
		graphicsCol = pos.getCol()*SQ_HEIGHT + SQ_HEIGHT/2;
		
	}
	
	// something with the graphics row and graphics col for use with the preview in gameBoard
	public void preview(int x, int y) {
		graphicsCol = x;
		graphicsRow = y;
		
	}
	
	// each piece can draw itself
	public void draw(Graphics g) {
		// TODO need to determine the interactions with the Graphics object, right now it is an input to draw, or 
		// should each piece store its own Graphics object and draw takes in void
		g.setColor(c);
		// g.drawImage(img, graphicsCol, graphicsRow, IMG_WIDTH, IMG_HEIGHT, null);
		g.drawString(pieceCode, graphicsCol - IMG_WIDTH/2, graphicsRow - IMG_HEIGHT/2); //need to check these!!!!!
		/* check the length and the offset */
	}
	 
}