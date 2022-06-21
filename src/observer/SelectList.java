package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectList {
	private int listSize;

	private PropertyChangeSupport pcs;

	public SelectList() {
		pcs = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	public void setListSize(int listSize) {

		pcs.firePropertyChange("size", this.listSize, listSize);

		this.listSize = listSize;
	}
}
