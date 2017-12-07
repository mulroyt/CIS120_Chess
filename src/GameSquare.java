/* CIS 120 Game HW
 * December 4, 2017
 * Thomas Mulroy
 */

import java.awt.*;
import java.awt.Color;
import javax.swing.*;


/** 
 * GameSquare
 * 
 * GameSquare is an extension of the JPanel. Each object is a black or white square used
 * to build the chess board
 * @author tmulroy
 *
 */

@SuppressWarnings("serial")
public class GameSquare extends JPanel {
	
	private Dimension sideLength =  new Dimension(150, 150);
	
	public GameSquare(Color c) {
		super();
		setBackground(c);
		setSize(sideLength);
	}
}