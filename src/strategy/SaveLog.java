package strategy;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;



public class SaveLog implements Save {

	DefaultListModel<String> dlm;
	
	public SaveLog(){
		
	}
	
	@Override
	public void save(Object o) {
		this.dlm = (DefaultListModel<String>) o;
		 JFileChooser fileChooser = new JFileChooser();
	        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            try {
	                String path = file.getPath() + ".txt";
	                file = new File(path);
	                FileWriter filewriter = new FileWriter(file.getPath(), true);
	                BufferedWriter buff = new BufferedWriter(filewriter);
	                PrintWriter writer = new PrintWriter(buff);
	                  
	                int i = 0;
	                while(i < dlm.size()){
	                	writer.write(dlm.get(i) + "\n");
	                	i++;
	                }
	                writer.close();
	            } catch (FileNotFoundException e2) {
	                e2.printStackTrace();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }       
		
		
	}

}
