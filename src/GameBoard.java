/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Component;

/**
 * GameBoard
 * 
 * This class stores the array representation of the location of the pieces on the board
 * It also hold the visual representation of the checkered board
 * It contains the logic for the taking of pieces and the state of the game
 **/

@SuppressWarnings("serial")
public class GameBoard extends JPanel {
	
	/* the paint example uses classes for modes with a mode interface, should i do this??
	 * I decided yes*/
	
	// state of the game board
	public boolean check; // not the best way to do this??
	public boolean checkMate;
	public boolean StaleMate;
	public boolean startMode; // before any pieces have been moved
	// public boolean whiteTurn = true; //white has the first move
	
	private JLabel status; // displays if someone is in check or not
	
	// Game Constants 
	public static final int COURT_WIDTH = 1200;
    public static final int COURT_HEIGHT = 1200;
	
    // Game Colors
    private Color c;
    
    // create the back end of the board using a 2D array of ChessPiece Objects
    public ChessPiece[][] boardBackEnd = new ChessPiece[8][8];
    // HOW DO I DEAL WITH EMPTY SPACES???? 
    
    // TODO make method that clears the board of all objects
    public void clear() {
    	for (int i = 0; i < 8; i ++) {
    		for (int j = 0; j < 8; j++) {
    			boardBackEnd[i][j] = null; // for now empty is a null space Maybe make a nullPiece class
    		}
    	}
    }
    
    // create the start of the game -- pieces on their starting locations should this be a method
    public void startMode() {
    	// resets the pieces
    	// first clear all the old objects 
    	this.clear();
    	// black pieces DO i need to number them ie pawn 1 pawn2 etc 
    	boardBackEnd[0][0] = new Rook(new Position(0, 0), Color.BLACK);
    	boardBackEnd[0][1] = new Knight(new Position(0, 1), Color.BLACK);
    	boardBackEnd[0][2] = new Bishop(new Position(0, 2), Color.BLACK);
    	boardBackEnd[0][3] = new Queen(new Position(0, 3), Color.BLACK);
    	boardBackEnd[0][4] = new King(new Position(0, 4), Color.BLACK);
    	boardBackEnd[0][5] = new Bishop(new Position(0, 5), Color.BLACK);
    	boardBackEnd[0][6] = new Knight(new Position(0, 6), Color.BLACK);
    	boardBackEnd[0][7] = new Rook(new Position(0, 7), Color.BLACK);
    	for (int i = 0; i < 8; i++) {
    		boardBackEnd[1][i] = new Pawn(new Position(1, i), Color.BLACK);
    	}
    	// white pieces
    	boardBackEnd[7][0] = new Rook(new Position(7, 0), Color.WHITE);
    	boardBackEnd[7][1] = new Knight(new Position(7, 1), Color.WHITE);
    	boardBackEnd[7][2] = new Bishop(new Position(7, 2), Color.WHITE);
    	boardBackEnd[7][3] = new Queen(new Position(7, 3), Color.WHITE);
    	boardBackEnd[7][4] = new King(new Position(7, 4), Color.WHITE);
    	boardBackEnd[7][5] = new Bishop(new Position(7, 5), Color.WHITE);
    	boardBackEnd[7][6] = new Knight(new Position(7, 6), Color.WHITE);
    	boardBackEnd[7][7] = new Rook(new Position(7, 7), Color.WHITE);
    	for (int i = 0; i < 8; i++) {
    		boardBackEnd[6][i] = new Pawn(new Position(6, i), Color.WHITE);
    	}
    }
    
    /* instead of a boolean state, make a mode of each players turn */
    interface Mode extends MouseListener, MouseMotionListener {	
    }
    
    class WhiteStartMode extends MouseAdapter implements Mode {
    	public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			Position pos = getPos(p);
			ChessPiece cp = boardBackEnd[pos.getCol()][pos.getRow()];
			if (cp != null && cp.getColor().equals(Color.WHITE)) { 
				mode = new WhiteEndMode(p, pos, cp); /* end mode takes in the graphics position e.getPoint and
				 the array position of the piece, and the piece itself */
				
			} else {mode = new WhiteStartMode();}
    		
		}
    }
    
    class WhiteEndMode extends MouseAdapter implements Mode {
    	Point modePoint;
    	Position piecePos;
    	ChessPiece cp;
    	
    	WhiteEndMode(Point p, Position pos, ChessPiece cp) {
    		modePoint = p;
    		piecePos = pos;
    		this.cp = cp;
    	}
    	
    	public void mouseDragged(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		
    		// use this information to preview the pieces location -> need to interact with the piece class
    		// probably need to make a preview class b/c the piece class can only have the piece location?
    		// check out the draw method to see what is possible there
    		cp.preview(p.x, p.y);
    		repaint();
    	}
    	
    	public void mouseReleased(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		Position pos = getPos(p);
    		cp.move(pos.getRow(), pos.getCol()); // moves the piece how to make the graphics update?
    		mode = new BlackStartMode();
    	}
    }
    
    class BlackStartMode extends MouseAdapter implements Mode {
    	public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			Position pos = getPos(p);
			ChessPiece cp = boardBackEnd[pos.getCol()][pos.getRow()];
			if (cp != null && cp.getColor().equals(Color.BLACK)) { 
				mode = new BlackEndMode(p, pos, cp); /* end mode takes in the graphics position e.getPoint and
				 the array position of the piece, and the piece itself */
				
			} else {mode = new BlackStartMode();}
    		
		}
    }
    
    class BlackEndMode extends MouseAdapter implements Mode {
    	Point modePoint;
    	Position piecePos;
    	ChessPiece cp;
    	
    	BlackEndMode(Point p, Position pos, ChessPiece cp) {
    		modePoint = p;
    		piecePos = pos;
    		this.cp = cp;
    	}
    	
    	public void mouseDragged(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		
    		// use this information to preview the pieces location -> need to interact with the piece class
    		// probably need to make a preview class b/c the piece class can only have the piece location?
    		// check out the draw method to see what is possible there
    		cp.preview(p.x, p.y);
    		repaint();
    	}
    	
    	public void mouseReleased(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		Position pos = getPos(p);
    		cp.move(pos.getRow(), pos.getCol()); // moves the piece how to make the graphics update?
    		repaint(); // what exactly does repaint do?
    		mode = new WhiteStartMode();
    	}
    }
    
    private Mode mode = null; //probably set to WhiteStartMode
    
    public GameBoard(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // TODO create the graphic representation of the board, map the boardBackEnd to the graphic rep
        //create the checker board pattern from the GameSquare Objects 
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		if ((i + j) % 2 == 0) {
        			c = Color.WHITE;
        		} else {c = Color.BLACK;}
        		new GameSquare(c);
        		setLocation(i*150, j*150);
        	}
        }
        
        
        //CAN THIS BE CHANGED TO CLICK FOCUSABLE???? TODO
        // Enable keyboard focus on the court area. 
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);
        
        Mouse mouseListener = new Mouse();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        
        /* listener to tell if a click occurs in a space. click a space with a piece to start moving it
         * then click another square to move it there. check if the square is empty here, then check if 
         * is a legal move in the specific piece's class
         */
        
        this.status = status;
    }
    
    // DONT THINK I NEED THIS ANYMORE
    // method to find all the array spaces occupied by white pieces
    // method to find all the array spaces occupied by black pieces
    
    //Mouse class, handles mouse events in the board space and passes them the current mode
    private class Mouse extends MouseAdapter {
    	
    	/* code that runs when the mouse is pressed inside the game board */
    	@Override
    	public void mousePressed(MouseEvent arg0) {
    		mode.mousePressed(arg0);
    	}
    	
    	@Override 
    	public void mouseDragged(MouseEvent arg0) {
    		mode.mouseDragged(arg0);
    	}
    	
    	@Override
    	public void mouseReleased(MouseEvent arg0) {
    		mode.mouseReleased(arg0);
    	}
    }
    
    // create a function called getPos that takes in a point and returns the nearest square
    public Position getPos(Point p) {
		int r_x = p.x/ChessPiece.SQ_HEIGHT;
		int r_y = p.y/ChessPiece.SQ_HEIGHT;
		Position pos = new Position(r_x, r_y);
    	return pos;
    }
    
}