/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;



/** 
 * GameSquare
 * 
 * GameSquare is an extension of the JPanel. Each object is a black or white square used
 * to build the chess board
 * @author tmulroy
 *
 */

public class GameSquare {
	
	private int sideLength =  150;
	private int xP;
	private int yP;
	
	private Color c; 
	
	public GameSquare(Color c, int xP, int yP) {
		this.c = c;
		this.xP = xP;
		this.yP = yP;
	}
	
	
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(xP, yP, sideLength, sideLength);
    }
}