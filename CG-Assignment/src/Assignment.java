import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Assignment extends Frame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Assignment();
	}
	
	Assignment(){
		super("Assignment1 Drawing squares");
		addWindowListener(new WindowAdapter()
		   {public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(600, 400);
		
		Dimension screenSize = 
				Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		int x = (screenWidth - this.getWidth())/2;
		int y = (screenHeight - this.getHeight())/4;
		this.setLocation(x, y);
		
		show();
	}

}
