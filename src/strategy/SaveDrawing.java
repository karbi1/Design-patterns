package strategy;


import java.io.File;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

import java.util.ArrayList;

import javax.swing.JFileChooser;

import geometry.Shape;

public class SaveDrawing implements Save {
	
	ArrayList<Shape> list;

	@Override
	public void save(Object o) {
		list = (ArrayList<Shape>) o;
		JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        	try {
        		File file = fileChooser.getSelectedFile();
        		String path = file.getPath();
        	    FileOutputStream fos = new FileOutputStream(path);
        	    ObjectOutputStream oos = new ObjectOutputStream(fos);   
        	    oos.writeObject(list); // write MenuArray to ObjectOutputStream
        	    oos.close(); 
        	} catch(Exception ex) {
        	    ex.printStackTrace();
        	}
        }      
	}

}
