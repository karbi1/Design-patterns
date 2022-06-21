package command;

import geometry.Line;
import mvc.DrawingModel;

public class ModifyLineCmd implements Command {
	
	private Line oldState;
	private Line newState;
	private Line original;
	
	public ModifyLineCmd(){
		
	}
	 
	public ModifyLineCmd(Line oldState, Line newState){
		this.oldState = oldState;
		this.newState = newState;
	}



	@Override
	public void execute() {
		original = oldState.clone();
		oldState.setStartPoint(newState.getStartPoint());
		oldState.setEndPoint(newState.getEndPoint());
		oldState.setColor(newState.getColor());
		

	}

	@Override
	public void unexecute() {
		oldState.setStartPoint(original.getStartPoint());
		oldState.setEndPoint(original.getEndPoint());
		oldState.setColor(original.getColor());
		
	}

}
