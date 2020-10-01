package DrawStrategy;

import java.awt.Graphics2D;

import Interfaces.IShape;
import model.ColorMap;
import view.interfaces.IDrawStrategy;

public class DrawOutlineStrategy implements IDrawStrategy {
	private IShape shape;
	private Graphics2D g2d;
	
	public DrawOutlineStrategy(IShape shape, Graphics2D g2d) {
		this.shape = shape;
		this.g2d = g2d;
	}
	
	public void draw() {
		g2d.setColor(ColorMap.getColor(shape.getPrimaryColor()));
		int x = shape.getMinX(); 
		int y = shape.getMinY(); 
		int w = shape.getWidth(); 
		int h = shape.getHeight();
		
		switch(shape.getShapeType()) {
		case RECTANGLE:
			g2d.drawRect(x, y, w, h);
			break;
		case ELLIPSE:
			g2d.drawOval(x, y, w, h);
			break;
		case TRIANGLE:
			int[] xPoints = {x + w, x, x + w};
			int[] yPoints = {y , y + h, y + h};
			g2d.drawPolygon(xPoints, yPoints, 3);
			break;
		default:
			break;
		}
	}
}
