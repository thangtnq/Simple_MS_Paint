package Shape;

import Interfaces.IShape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class Ellipse implements IShape {
	private int xMin;
	private int yMin;
	private int width;
	private int height;
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	private ShapeShadingType shade;
	
	public Ellipse(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int a , int b, int c, int d) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shade = shade;
		this.xMin = a;
		this.yMin = b;
		this.width = c;
		this.height = d;
		
	}
	
	public int getMinX() {
		return xMin;
	}
	
	public void setMinX(int newXMin) {
		this.xMin = newXMin;
	}
	
	public int getMinY() {
		return yMin;
	}
	
	public void setMinY(int newYMin) {
		this.yMin = newYMin;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;
	}
	
	public ShapeColor getPrimaryColor() {
		return primaryColor;
	}
	
	public void setPrimaryColor(ShapeColor newPrimaryColor) {
		this.primaryColor = newPrimaryColor;
	}
	
	public ShapeColor getSecondaryColor() {
		return secondaryColor;
	}
	
	public void setSecondaryColor(ShapeColor newSecondaryColor) {
		this.secondaryColor = newSecondaryColor;
	}
	
	public ShapeShadingType getShade() {
		return shade;
	}
	
	public void setShade(ShapeShadingType newShade) {
		this.shade = newShade;
	}
	
	public ShapeType getShapeType() {
		return ShapeType.ELLIPSE;
	}

	@Override
	public void set_X_Y_Width_Height(int a, int b, int c, int d) {
		this.xMin = a;
		this.yMin = b;
		this.width = c;
		this.height = d;
	}
}