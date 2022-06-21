package command;

import geometry.Shape;
import mvc.DrawingModel;

public class AddShapeCmd implements Command {
	
	Shape shape;
	DrawingModel model;
	
	public AddShapeCmd(DrawingModel model, Shape shape){
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.getShapes().add(shape);

	}

	@Override
	public void unexecute() {
		model.getShapes().remove(shape);

	}

}
