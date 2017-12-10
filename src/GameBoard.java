/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
	public static final int BOARD_WIDTH = 1200;
    public static final int BOARD_HEIGHT = 1200;
    // the 2d array holding the visual
    public GameSquare[][] boardVisual = new GameSquare[8][8];
    
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
    public void NewGame() {
    	// resets the pieces
    	// first clear all the old objects 
    	this.clear();
    	// black pieces DO i need to number them i.e. pawn 1 pawn2 etc 
    	boardBackEnd[0][0] = new Rook(new Position(0, 0), Color.BLACK);
    	boardBackEnd[1][0] = new Knight(new Position(1, 0), Color.BLACK);
    	boardBackEnd[2][0] = new Bishop(new Position(2, 0), Color.BLACK);
    	boardBackEnd[3][0] = new Queen(new Position(3, 0), Color.BLACK);
    	boardBackEnd[4][0] = new King(new Position(4, 0), Color.BLACK);
    	boardBackEnd[5][0] = new Bishop(new Position(5, 0), Color.BLACK);
    	boardBackEnd[6][0] = new Knight(new Position(6, 0), Color.BLACK);
    	boardBackEnd[7][0] = new Rook(new Position(7, 0), Color.BLACK);
    	for (int i = 0; i < 8; i++) {
    		boardBackEnd[i][1] = new Pawn(new Position(i, 1), Color.BLACK);
    	}
    	// white pieces
    	boardBackEnd[0][7] = new Rook(new Position(0, 7), Color.WHITE);
    	boardBackEnd[1][7] = new Knight(new Position(1, 7), Color.WHITE);
    	boardBackEnd[2][7] = new Bishop(new Position(2, 7), Color.WHITE);
    	boardBackEnd[3][7] = new Queen(new Position(3, 7), Color.WHITE);
    	boardBackEnd[4][7] = new King(new Position(4, 7), Color.WHITE);
    	boardBackEnd[5][7] = new Bishop(new Position(5, 7), Color.WHITE);
    	boardBackEnd[6][7] = new Knight(new Position(6, 7), Color.WHITE);
    	boardBackEnd[7][7] = new Rook(new Position(7, 7), Color.WHITE);
    	for (int i = 0; i < 8; i++) {
    		boardBackEnd[i][6] = new Pawn(new Position(i, 6), Color.WHITE);
    	}
    	repaint();
    	mode = new WhiteStartMode();
    }
    
    /* instead of a boolean state, make a mode of each players turn */
    interface Mode extends MouseListener, MouseMotionListener {	
    }
    
    class WhiteStartMode extends MouseAdapter implements Mode {
    	public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			Position pos = getPos(p);
			ChessPiece cp = boardBackEnd[pos.getX()][pos.getY()];
			if (cp != null && cp.getColor().equals(Color.WHITE)) { 
				mode = new WhiteEndMode(p, pos, cp); /* end mode takes in the graphics position e.getPoint and
				 the array position of the piece, and the piece itself */
				
			} else {mode = new WhiteStartMode();
			status.setText("White Move");
			}
    		
		}
    }
    
    class WhiteEndMode extends MouseAdapter implements Mode {
    	Point modePoint;
    	Position startPos;
    	ChessPiece cp;
    	
    	WhiteEndMode(Point p, Position pos, ChessPiece cp) {
    		modePoint = p; // TODO is this correct?? p is now the originally clicked point (in the graphics context)
    		startPos = pos; // The board back end position of the selected piece
    		this.cp = cp; // The chess piece that has been selected
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
    		//cp.move(pos.getX(), pos.getY());
    		//boardBackEnd[pos.getX()][pos.getY()] = cp; 
    		//boardBackEnd[startPos.getX()][startPos.getY()] = null;
    		if (movePiece(cp, startPos, pos)) {
   			     repaint(); 
   	             mode = new BlackStartMode();
   	             status.setText("Black Move");
   		     } else {
   			     cp.move(startPos.getX(), startPos.getY());
   			     mode = new WhiteStartMode();
   			     repaint();
   	     	 }
    	}
    }
    
    class BlackStartMode extends MouseAdapter implements Mode {
    	public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			Position pos = getPos(p);
			ChessPiece cp = boardBackEnd[pos.getX()][pos.getY()];
			if (cp != null && cp.getColor().equals(Color.BLACK)) { 
				mode = new BlackEndMode(p, pos, cp); /* end mode takes in the graphics position e.getPoint and
				 the array position of the piece, and the piece itself */
				
			} else {mode = new BlackStartMode();
			    status.setText("Black Move");
			}
    		
		}
    }
    
    class BlackEndMode extends MouseAdapter implements Mode {
    	Point modePoint;
    	Position startPos;
    	ChessPiece cp;
    	
    	BlackEndMode(Point p, Position pos, ChessPiece cp) {
    		modePoint = p;
    		startPos = pos;
    		this.cp = cp;
    	}
    	
    	public void mouseDragged(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		
    		// use this information to preview the pieces location -> need to interact with the piece class
    		// probably need to make a preview class b/c the piece class can only have the piece location?
    		// check out the draw method to see what is possible there
    		cp.preview(p.x, p.y); //preview method in ChessPiece sets the graphics coordinates
    		repaint();
    	}
    	
    	public void mouseReleased(MouseEvent arg0) {
    		Point p = arg0.getPoint();
    		Position pos = getPos(p);
    		//cp.move(pos.getX(), pos.getY()); // moves the piece how to make the graphics update?
    		//boardBackEnd[pos.getX()][pos.getY()] = cp;  // make a method that does all three (move, update board back end and clear board back end
    		//boardBackEnd[startPos.getX()][startPos.getY()] = null;
    		 if (movePiece(cp, startPos, pos)) {
    			 repaint(); 
    	         mode = new WhiteStartMode();
    	         status.setText("White Move");
    		 } else {
    			 cp.move(startPos.getX(), startPos.getY());
    			 mode = new BlackStartMode();
    			 repaint();
    		 }
    	}
    }
    
    //private Mode mode = null; //probably set to WhiteStartMode
    private Mode mode = new WhiteStartMode();
    
    public GameBoard(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        /* create the graphic representation of the board, map the boardBackEnd to the graphic rep
         * create the checker board pattern from the GameSquare Objects */
       
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		if ((i + j) % 2 == 0) {
        			c = Color.LIGHT_GRAY;
        		} else {c = Color.GRAY;}
        		boardVisual[i][j] = new GameSquare(c, i*150, j*150);
        		
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
    
    /* create a method called getPos that takes in a point and returns the nearest square 
     * this feature snaps the piece to the center of the closest square */
    public Position getPos(Point p) {
		int r_x = p.x/ChessPiece.SQ_HEIGHT;
		int r_y = p.y/ChessPiece.SQ_HEIGHT;
		Position pos = new Position(r_x, r_y);
    	return pos;
    }
    
    /* method that is used by the mouseRealased method in the EndMode inner classes. It has four 
     * functions, the first is to check if the move it valid on the most basic level, that is the 
     * square is not occupied by ones own piece. The second is is to call ChessPiece.move.
     * Next it updates boardBackEnd to place the new piece and clear the old space
     */
    public boolean movePiece(ChessPiece cp, Position start, Position end) {
    	int eX = end.getX();
    	int eY = end.getY();
    	ChessPiece moveTo = boardBackEnd[eX][eY];
    	int sX = start.getX();
    	int sY = start.getY();
    	if (!cp.legalMove(start, end, boardBackEnd)) {
    		return false;
    	}
    	if (moveTo == null || moveTo.getColor() == oppColor(cp)) {
    		cp.move(eX,eY);
    		boardBackEnd[eX][eY] = cp;
    		boardBackEnd[sX][sY] = null;
    		return true;
    	} else { return false;}
    }
    
    /* helper method that returns the opposite color */
    public Color oppColor(ChessPiece cp) {
    	if (cp.getColor() == Color.WHITE) {
    		return Color.BLACK;
    	} else { return Color.WHITE;}
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			boardVisual[i][j].draw(g);
    		}
    	}
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if (boardBackEnd[i][j] != null) {
    			    boardBackEnd[i][j].draw(g);
    			}
    		}
    	}
    }
}