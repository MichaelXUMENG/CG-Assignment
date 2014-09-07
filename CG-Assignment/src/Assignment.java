import java.awt.*;
import java.awt.event.*;

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
		
		add("Center", new squares());
		show();
	}

}


class squares extends Canvas{
	int centerX, centerY;
	float dis = 0.95F;
	float pixelSize, rWidth = 100.0F, rHeight = 100.0F;
	
	void initial(){
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
		centerX = maxX/2;
		centerY = maxY/2;
	}
	
	int iX(float x){return Math.round(centerX + x/pixelSize);}
	int iY(float y){return Math.round(centerY - y/pixelSize);}
	
	public void paint(Graphics g){
		initial();
		float point1X = -rWidth/2 * dis, point1Y = rHeight/2 * dis,
				point2X = rWidth/2 * dis, point2Y = rHeight/2 * dis,
				point3X = rWidth/2 * dis, point3Y = -rHeight/2 * dis,
				point4X = -rWidth/2 * dis, point4Y = -rHeight/2 * dis,
				newpointX, newpointY;
		for(int i = 1; i<50; i++){
			g.drawLine(iX(point1X), iY(point1Y), iX(point2X), iY(point2Y));
			g.drawLine(iX(point2X), iY(point2Y), iX(point3X), iY(point3Y));
			g.drawLine(iX(point3X), iY(point3Y), iX(point4X), iY(point4Y));
			g.drawLine(iX(point4X), iY(point4Y), iX(point1X), iY(point1Y));
			
			newpointX = (point1X + point2X)/2; newpointY = (point1Y + point2Y)/2;
			point2X = (point2X + point3X)/2; point2Y = (point2Y + point3Y)/2;
			point3X = (point3X + point4X)/2; point3Y = (point3Y + point4Y)/2;
			point4X = (point4X + point1X)/2; point4Y = (point4Y + point1Y)/2;
			point1X = newpointX; point1Y = newpointY;
		}
	}
}