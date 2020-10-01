package model;

import java.util.ArrayList;

import DrawStrategy.DrawShape;
import Interfaces.IShape;
import view.gui.PaintCanvas;

public class ShapeList {
	private static final ShapeList instance = new ShapeList();
	private final ArrayList<IShape> listOfShapes;
	private ArrayList<IShape> selectedShapeList;
	private ArrayList<IShape> copiedShapeList;
	
	private ShapeList() {
		listOfShapes = new ArrayList<IShape>();
		selectedShapeList = new ArrayList<IShape>();
	}
	
	public static ShapeList getInstance() {
		return instance;
	}
	
	public void addShape(IShape shape) {
		clearSelectedShapes();
		listOfShapes.add(shape);
	}
	
	public void removeShape(IShape shape) {
		clearSelectedShapes();
		listOfShapes.remove(shape);
	}
	
	public IShape findShape(IShape toFind) {
		return listOfShapes.get(listOfShapes.indexOf(toFind));
	}
	
	public void updateShapes() {
		PaintCanvas canvas = PaintCanvas.getInstance();
		canvas.clear();
		for (IShape shape : listOfShapes) {
			DrawShape.draw(shape);
		}
		drawSelectedBorders();
		canvas.requestFocus();
	}
	
	public ArrayList<IShape> selectShapes(int minX, int maxX, int minY, int MaxY) {
		clearSelectedShapes();
		
		for (IShape shape : listOfShapes) {
			int shapeMinX = shape.getMinX();
			int shapeMinY = shape.getMinY();
			int shapeMaxX = shapeMinX + shape.getWidth();
			int shapeMaxY = shapeMinY + shape.getHeight();
			if ((minX > shapeMaxX) || (shapeMinX > maxX)) {
				continue; 
			}
			
			if ((minY > shapeMaxY) || (shapeMinY > MaxY)) {
				continue; 
			}
			
			selectedShapeList.add(shape);
		}
		drawSelectedBorders();
		return selectedShapeList;
	}
	
	public ArrayList<IShape> getSelectedShapes() {
		return selectedShapeList;
	}
	
	public void setSelectedShapes(ArrayList<IShape> newList) {
		selectedShapeList = newList;
		drawSelectedBorders();
	}
	
	public void drawSelectedBorders() {
		for (IShape selected: selectedShapeList) {
			DrawShape.select(selected);
		}
	}
	
	public void clearSelectedShapes() {
		if (selectedShapeList.size() != 0) {
			selectedShapeList = new ArrayList<IShape>();
			updateShapes();
		}
	}

	public ArrayList<IShape> getCopiedShapes() {
		return copiedShapeList;
	}

	public void setCopiedShapes(ArrayList<IShape> copiedShapes) {
		copiedShapeList = copiedShapes;
	}
	
	
}
