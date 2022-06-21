package command;

import geometry.Point;
import geometry.Rectangle;
import mvc.DrawingModel;

public class ModifyRectangleCmd implements Command {

	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle original;
	
	public ModifyRectangleCmd()
	{
		
	}
	
	public ModifyRectangleCmd(Rectangle oldState,Rectangle newState)
	{
		this.oldState=oldState;
		this.newState = newState;

	}
	
	@Override
	public void execute() {

		original = oldState.clone();
		oldState.setUpperLeftPoint(newState.getUpperLeftPoint());
		oldState.setHeight(newState.getHeight());
		oldState.setWidth(newState.getWidth());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		oldState.setUpperLeftPoint(original.getUpperLeftPoint());
		oldState.setHeight(original.getHeight());
		oldState.setWidth(original.getWidth());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());
	}
}
