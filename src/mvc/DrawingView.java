package mvc;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Rectangle;
import geometry.Shape;



import geometry.Shape;
import geometry.SurfaceShape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingView extends JPanel {

	private ArrayList <Shape> shapes=new ArrayList <Shape>();
	private DrawingModel model = new DrawingModel();
	
	

	public DrawingView() {
		
		
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		Iterator <Shape> it = model.getShapes().iterator();
		 	while (it.hasNext()) {
		 		it.next().draw(g);
		 	}
	}
	
	public void setModel(DrawingModel model) {
		this.model = model;
	}

	
	
	
}
