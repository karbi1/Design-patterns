package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



import mvc.DrawingFrame;

public class SelectListObserver implements PropertyChangeListener{
	
	
	private int listSize;
	private DrawingFrame frame;
	
	public SelectListObserver(DrawingFrame frame)
	{
		this.frame = frame;
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		
		if(evt.getPropertyName().equals("size"))
		{
		this.listSize = (int) evt.getNewValue();
		
		this.ChangeButton();
		}
		
	}
	
	public void ChangeButton()
	{
		if(listSize == 1)
		{
			frame.getBbtnBringToBack().setEnabled(true);
			frame.getBbtnBringToFront().setEnabled(true);
			frame.getBbtnToBack().setEnabled(true);
			frame.getBbtnToFront().setEnabled(true);
			frame.getBbtnDelete().setEnabled(true);
			frame.getBbtnModify().setEnabled(true);
		}
		
		else if (listSize > 1)
		{
			frame.getBbtnBringToBack().setEnabled(false);
			frame.getBbtnBringToFront().setEnabled(false);
			frame.getBbtnToBack().setEnabled(false);
			frame.getBbtnToFront().setEnabled(false);
			frame.getBbtnModify().setEnabled(false);
			frame.getBbtnDelete().setEnabled(true);
		}
		
		else 
		{
			frame.getBbtnBringToBack().setEnabled(false);
			frame.getBbtnBringToFront().setEnabled(false);
			frame.getBbtnToBack().setEnabled(false);
			frame.getBbtnToFront().setEnabled(false);
			frame.getBbtnDelete().setEnabled(false);
			frame.getBbtnModify().setEnabled(false);
		}
	}

}