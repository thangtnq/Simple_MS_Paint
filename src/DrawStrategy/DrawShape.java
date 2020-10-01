package DrawStrategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import Interfaces.IShape;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.PaintCanvas;
import view.interfaces.IDrawStrategy;

public class DrawShape {
	
	public static void draw(IShape shape) {
		PaintCanvas canvas = PaintCanvas.getInstance();
		Graphics2D graphic = canvas.getGraphics2D();
		graphic.setStroke(new BasicStroke(2));
		IDrawStrategy strat = null;
		
		if(shape.getShade() == ShapeShadingType.OUTLINE) {
			strat = new DrawOutlineStrategy(shape, graphic);
		} else if (shape.getShade() == ShapeShadingType.FILLED_IN) {
			strat = new DrawFillStrategy(shape, graphic);
		} else if(shape.getShade() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
			strat = new DrawFillAndOutlineStrategy(shape, graphic);
		}
		
		strat.draw();
	}
	
	public static void select(IShape shape) {
		PaintCanvas canvas = PaintCanvas.getInstance();
		Graphics2D g2d = canvas.getGraphics2D();
		float[] dash1 = { 5f, 0f, 5f };
	    BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
	    g2d.setStroke(bs1);
	    int offSet = 5;
	    
	    g2d.setColor(Color.black);
		int x = shape.getMinX() - offSet; 
		int y = shape.getMinY() - offSet; 
		int w = shape.getWidth() + offSet + offSet; 
		int h = shape.getHeight() + offSet + offSet;
		
		if(shape.getShapeType() == ShapeType.RECTANGLE) {
			g2d.drawRect(x, y, w, h);
		}
		else if (shape.getShapeType() == ShapeType.ELLIPSE) {
			g2d.drawOval(x, y, w, h);
		}
		else {
			int[] xPoints = {x + w, x , x + w};
			int[] yPoints = {y , y + h, y + h};
			
			g2d.drawPolygon(xPoints, yPoints, 3);
		}
	}
}
