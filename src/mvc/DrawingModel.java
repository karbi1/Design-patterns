package mvc;
import geometry.Shape;
import java.util.ArrayList;
import java.util.Stack;

import command.Command;

public class DrawingModel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();	
	private ArrayList<String> log = new ArrayList<String>();

	public void add(Shape shape){
		shapes.add(shape);
	}
	
	public void remove(Shape shape){
		shapes.remove(shape);
	}
	
	public Shape get(int index){
		return shapes.get(index); 
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public void log(String log){
		this.log.add(log);
	}
	
	
	
}
