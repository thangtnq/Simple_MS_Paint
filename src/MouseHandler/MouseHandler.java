package MouseHandler;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Controller;

public class MouseHandler extends MouseAdapter {
	private int startingX;
	private int startingY;
	private int endingX;
	private int endingY;
	private int minY;
	private int minX;
	private int width;
	private int height;
	private boolean reverse;
	
	private Point startPoint, endPoint;
	
	public MouseHandler() {
		super();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.startPoint = e.getPoint();
		
		startingX = e.getX();
		startingY = e.getY();
		endingX = e.getX();
		endingY = e.getY();
		
		if(e.getButton() == 3) {
			reverse = true;
		}
		else {
			reverse = false;
		}
					
		minX = Math.min(startingX, endingX);
		minY = Math.min(startingY, endingY);
		width = Math.abs(startingX - endingX); 
		height = Math.abs(startingY - endingY);
	
		Controller.mousePressed();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.endPoint = e.getPoint();
		endingX = e.getX();
		endingY = e.getY();
		
		minX = Math.min(startingX, endingX);
		minY = Math.min(startingY, endingY);
		width = Math.abs(startingX - endingX); 
		height = Math.abs(startingY - endingY);
	
		Controller.mouseReleased();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endingX = e.getX();
		endingY = e.getY();
	
		minX = Math.min(startingX, endingX);
		minY = Math.min(startingY, endingY);
		width = Math.abs(startingX - endingX); 
		height = Math.abs(startingY - endingY);
	
		Controller.mouseDragged();
	}
	
	public int getMinX() {
		return minX;
	}
	
	public int getMinY() {
		return minY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getStartingX() {
		return startingX;
	}
	
	public int getStartingY() {
		return startingY;
	}
	
	public int getEndingX() {
		return endingX;
	}
	
	public int getEndingY() {
		return endingY;
	}
	
	public boolean getReverse() {
		return reverse;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public Point getEndPoint() {
		return this.endPoint;
	}
}
