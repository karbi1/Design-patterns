package dialogModification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgLineModification extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JTextField txtStartX;
	private boolean isOk;
	private JTextField txtEndX;
	private JTextField txtStartY;
	private JTextField txtEndY;
	private Color color = Color.black;
	private Line l;
	private int startX = 0;
	private int startY = 0;
	private int endX = 0;
	private int endY = 0;

	private JTextField txtColor;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineModification dialog = new DlgLineModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineModification() {
		setModal(true);
		setTitle("Line Modification");
		getContentPane().setBackground(new Color(135, 206, 250));
		setBounds(100, 100, 415, 310);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(135, 206, 250));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblLineModification = new JLabel("Line Modification");
		lblLineModification.setForeground(new Color(255, 0, 0));
		lblLineModification.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		
		JLabel lblStart = new JLabel("Start Point:");
		lblStart.setForeground(new Color(255, 0, 0));
		lblStart.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtStartX = new JTextField();
		txtStartX.setForeground(new Color(255, 0, 0));
		txtStartX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtStartX.setBackground(new Color(176, 196, 222));
		txtStartX.setColumns(10);
		
		JLabel lblEnd = new JLabel("End Point:");
		lblEnd.setForeground(Color.RED);
		lblEnd.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		JLabel lblStartX = new JLabel("X:");
		lblStartX.setForeground(Color.RED);
		lblStartX.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		JLabel lblEndX = new JLabel("X:");
		lblEndX.setForeground(Color.RED);
		lblEndX.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtEndX = new JTextField();
		txtEndX.setForeground(Color.RED);
		txtEndX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtEndX.setColumns(10);
		txtEndX.setBackground(new Color(176, 196, 222));
		
		JLabel lblStartY = new JLabel("Y:");
		lblStartY.setForeground(Color.RED);
		lblStartY.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		JLabel lblEndY = new JLabel("Y:");
		lblEndY.setForeground(Color.RED);
		lblEndY.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtStartY = new JTextField();
		txtStartY.setForeground(Color.RED);
		txtStartY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtStartY.setColumns(10);
		txtStartY.setBackground(new Color(176, 196, 222));
		
		txtEndY = new JTextField();
		txtEndY.setForeground(Color.RED);
		txtEndY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtEndY.setColumns(10);
		txtEndY.setBackground(new Color(176, 196, 222));
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color=JColorChooser.showDialog(null,"Edge Color",color);
				if(color==null)
				{
					color=Color.black;
					txtColor.setBackground(Color.black);
				}else
				{
					txtColor.setBackground(color);
				}
			}
		});
		btnColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		txtColor = new JTextField();
		txtColor.setEditable(false);
		txtColor.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblStart, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblStartX, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnColor))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblEndX, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
										.addComponent(txtColor, 0, 0, Short.MAX_VALUE)
										.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
							.addGap(23)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblEndY, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblStartY, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblLineModification, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addComponent(lblLineModification, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStart, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStartX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStartY, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndY, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnColor)
						.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			pnlSouth.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnOk = new JButton("OK");
				btnOk.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtStartX.getText().trim().equals("") || txtStartY.getText().trim().equals("") || txtEndX.getText().trim().equals("") || txtEndY.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						try {
							validate(txtStartX.getText(),txtStartY.getText(),txtEndX.getText(),txtEndY.getText());
						} catch ( NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Please insert a number", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						if(Integer.parseInt(txtStartX.getText())<0){
							JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
						}else{
							startX=Integer.parseInt(txtStartX.getText());
							startY=Integer.parseInt(txtStartY.getText());
							endX=Integer.parseInt(txtEndX.getText());
							endY=Integer.parseInt(txtEndY.getText());
							isOk = true;
							dispose();
							
						}
					}
				});
				btnOk.setActionCommand("OK");
				pnlSouth.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				pnlSouth.add(btnCancel);
			}
		}
	
	}
	public void fillFields(Line l){
		this.l = l;
		txtStartX.setText(String.valueOf(l.getStartPoint().getX()));
		txtStartY.setText(String.valueOf(l.getStartPoint().getY()));
		txtEndX.setText(String.valueOf(l.getEndPoint().getX()));
		txtEndY.setText(String.valueOf(l.getEndPoint().getY()));
		txtColor.setBackground(l.getColor());
		color=l.getColor();
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	public void validate(String x,String y,String x1,String y1) {
		String exp = "^(([1-9]{1})([0-9]+)?)$";
		if(x1.equals("")|| x.equals("") || y.equals("")|| y1.equals(""));
		else if(!x1.matches(exp) || !y1.matches(exp) || !x.matches(exp) || !y.matches(exp)){  
        	throw new NumberFormatException();
        }}
	
	public Line getLine(){
		return this.l;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public int getEndY(){
		return endY;
	}
	
	public Color getEdgeColor(){
		return color;
	}
}
