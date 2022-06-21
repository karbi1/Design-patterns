package command;

import javax.swing.JOptionPane;

import geometry.Shape;
import mvc.DrawingModel;

public class ToFrontCmd implements Command {
	
	private DrawingModel model;
	private Shape shape;
	private Shape temp;
	
	
	public ToFrontCmd()
	{
		
	}
	
	public ToFrontCmd(DrawingModel model, Shape shape)
	{
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		
		try {
		int index = model.getShapes().indexOf(shape);
		temp = model.getShapes().get(index+1);
		model.getShapes().set(index, temp);
		model.getShapes().set(index+1, shape);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Shape is in the front", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	@Override
	public void unexecute() {
		
		int index = model.getShapes().indexOf(shape);
		temp = model.getShapes().get(index-1);
		model.getShapes().set(index, temp);
		model.getShapes().set(index-1, shape);
	}
}
