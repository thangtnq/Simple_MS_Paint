package model;

import Interfaces.IShape;
import Shape.*;

public class ShapeFactory {
	
	public static IShape createEllipse(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int a, int b, int c, int d) {
		return new Ellipse(primaryColor, secondaryColor, shade, a, b, c, d);
	}
	
    public static IShape createRectangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int a, int b, int c, int d) {
    	return new Rectangle(primaryColor, secondaryColor, shade, a, b, c, d);
    }
    
    public static IShape createTriangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int a, int b, int c, int d) {
    	return new Triangle(primaryColor, secondaryColor, shade, a, b, c, d);
    }
}
