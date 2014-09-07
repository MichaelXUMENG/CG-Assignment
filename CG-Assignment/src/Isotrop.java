import java.awt.*;
import java.awt.event.*;

public class Isotrop extends Frame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Isotrop();
	}
	
	Isotrop(){
		super("Isotropic mapping mode");
		addWindowListener( new WindowAdapter()
		    {public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(400, 300);
		add("Center", new CvIsotrop());
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		show();
	}

}

class CvIsotrop extends Canvas{
	int centerX, centerY;
	float pixelSize, rWidth = 10.0F, rHeight = 10.0F, xP = 100000, yP;
	
	CvIsotrop(){
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent evt){
				xP = fx(evt.getX()); yP = fy(evt.getY());
				repaint();
			}
		});
	}
	
	void initgr(){
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
		centerX = maxX/2; centerY = maxY/2;
	}
	
	int iX(float x){return Math.round(centerX + x/pixelSize);}
	int iY(float y){return Math.round(centerY + y/pixelSize);}
	float fx(int x){return (x - centerX)* pixelSize;}
	float fy(int y){return (centerY - y)* pixelSize;}
	
	public void paint(Graphics g){
		initgr();
		int left = iX(-rWidth/2), right = iX(rWidth/2),
				bottom = iY(-rHeight/2), top = iY(rHeight/2),
				xMiddle = iX(0), yMiddle = iY(0);
		g.drawLine(xMiddle, bottom, right, yMiddle);
		g.drawLine(right, yMiddle, xMiddle, top);
		g.drawLine(xMiddle, top, left, yMiddle);
		g.drawLine(left, yMiddle, xMiddle, bottom);
		if(xP != 1000000){
			g.drawString("Logical coordinates of selected point: "+ xP + "" + yP, 20 , 100);
		}
	}
	
}
