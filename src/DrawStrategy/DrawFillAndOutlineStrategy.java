package DrawStrategy;

import java.awt.Graphics2D;

import Interfaces.IShape;
import model.ColorMap;
import view.interfaces.IDrawStrategy;

public class DrawFillAndOutlineStrategy implements IDrawStrategy {
	private IShape shape;
	private Graphics2D graphic;
	
	public DrawFillAndOutlineStrategy(IShape shape, Graphics2D g2d) {
		this.shape = shape;
		this.graphic = g2d;
	}
	
	public void draw() {
		graphic.setColor(ColorMap.getColor(shape.getPrimaryColor()));
				
		switch(shape.getShapeType()) {
		case RECTANGLE:
			graphic.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			graphic.drawRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			graphic.setColor(ColorMap.getColor(shape.getPrimaryColor()));
			graphic.fillRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			break;
		case ELLIPSE:
			graphic.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			graphic.drawOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			graphic.setColor(ColorMap.getColor(shape.getPrimaryColor()));
			graphic.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			break;
		case TRIANGLE:
			int x = shape.getMinX(); 
			int y = shape.getMinY(); 
			int w = shape.getWidth(); 
			int h = shape.getHeight();
			int[] xPoints = {x + w, x, x + w};
			int[] yPoints = {y , y+ h, y + h};
			graphic.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			graphic.drawPolygon(xPoints, yPoints, 3);
			graphic.setColor(ColorMap.getColor(shape.getPrimaryColor()));
			graphic.fillPolygon(xPoints, yPoints, 3);
			break;
		default:
			break;
		}
	}
}
