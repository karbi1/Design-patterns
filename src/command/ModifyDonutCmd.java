package command;

import geometry.Donut;

public class ModifyDonutCmd implements Command {

	private Donut oldState;
	private Donut newState;
	private Donut original;
	
	public ModifyDonutCmd()
	{
		
	}
	
	public ModifyDonutCmd(Donut oldState,Donut newState)
	{
		this.oldState=oldState;
		this.newState = newState;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		original = oldState.clone();
		oldState.setCenter(newState.getCenter());
		oldState.setRadius(newState.getRadius());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		oldState.setInnerRadius(newState.getInnerRadius());
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
			
		oldState.setCenter(original.getCenter());
		oldState.setRadius(original.getRadius());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());
		oldState.setInnerRadius(original.getInnerRadius());
		
	}
}
