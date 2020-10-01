package Interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
	int getMinX();
	int getMinY();
	int getWidth();
	int getHeight();
	ShapeColor getPrimaryColor();
	ShapeColor getSecondaryColor(); 
	ShapeShadingType getShade();
	void setMinX(int newXMin);
	void setMinY(int newYMin);
	void setPrimaryColor(ShapeColor newPrimaryColor);
	void setSecondaryColor(ShapeColor newSecondaryColor); 
	void setShade(ShapeShadingType newShade);
	ShapeType getShapeType();
	void set_X_Y_Width_Height(int a, int b, int c, int d);
}
