/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */


import java.awt.Graphics;
import java.awt.*;
import java.awt.Color;
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
	private int graphicsX;
	private int graphicsY;
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
		this.graphicsX = pos.getX()*SQ_HEIGHT + SQ_HEIGHT/2;
		this.graphicsY = pos.getY()*SQ_HEIGHT + SQ_HEIGHT/2;
		
		this.c = c; // setting the color of the piece
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
	public void move(int x, int y) {
		// call the function in the instance to see if it is a legal move?
		pos.setX(x);
		pos.setY(y);
		// when the piece moves it needs to update the graphics position
		graphicsX = pos.getX()*SQ_HEIGHT + SQ_HEIGHT/2;
		graphicsY = pos.getY()*SQ_HEIGHT + SQ_HEIGHT/2; 
		
	}
	
	// something with the graphics row and graphics col for use with the preview in gameBoard
	public void preview(int x, int y) {
		graphicsX = x;
		graphicsY = y;
		
	}
	
	// each piece can draw itself
	public void draw(Graphics g) {
		// TODO need to determine the interactions with the Graphics object, right now it is an input to draw, or 
		// should each piece store its own Graphics object and draw takes in void
	    g.setColor(c);
	    Font currFont = g.getFont();
	    Font newFont = currFont.deriveFont(currFont.getSize()*1); // This doesn't seem to work???
	    g.setFont(newFont);
	    g.drawString(pieceCode, graphicsX - 5, graphicsY); //need to check these!!!!!
	    
	    /* check the length and the offset */
	}
	 
}