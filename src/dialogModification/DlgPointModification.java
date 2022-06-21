package dialogModification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class DlgPointModification extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JTextField txtPointX;
	private boolean isOk;
	private JTextField txtPointY;
	private Point point;
	private Color color;
	private JTextField txtColor;
	private int x = 0;
	private int y = 0;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPointModification dialog = new DlgPointModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPointModification() {
		setResizable(false);
		setModal(true);
		setTitle("Point Modification");
		getContentPane().setBackground(new Color(135, 206, 250));
		setBounds(100, 100, 415, 310);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(135, 206, 250));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblPointModification = new JLabel("Point Modification");
		lblPointModification.setForeground(new Color(255, 0, 0));
		lblPointModification.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		
		JLabel lblPoint = new JLabel("Point:");
		lblPoint.setForeground(new Color(255, 0, 0));
		lblPoint.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtPointX = new JTextField();
		txtPointX.setForeground(new Color(255, 0, 0));
		txtPointX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtPointX.setBackground(new Color(176, 196, 222));
		txtPointX.setColumns(10);
		
		JLabel lblPointX = new JLabel("X:");
		lblPointX.setForeground(Color.RED);
		lblPointX.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		JLabel lblPointY = new JLabel("Y:");
		lblPointY.setForeground(Color.RED);
		lblPointY.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtPointY = new JTextField();
		txtPointY.setForeground(Color.RED);
		txtPointY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtPointY.setColumns(10);
		txtPointY.setBackground(new Color(176, 196, 222));
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						.addComponent(lblPointModification, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnColor)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPointX, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPointX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGap(34)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(lblPointY, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtPointY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addComponent(lblPointModification, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPointX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPointY, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointY, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnColor)
						.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
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
						if(txtPointX.getText().trim().equals("") || txtPointY.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Some of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						try {
							validate(txtPointX.getText(), txtPointY.getText());
						} catch ( NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Please insert number", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						if(Integer.parseInt(txtPointX.getText())<0 || Integer.parseInt(txtPointY.getText())<0){
							JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
						}else{

							x=Integer.parseInt(txtPointX.getText());
							y=Integer.parseInt(txtPointY.getText());
							isOk=true;
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
	
	public void fillFields(Point p){
		this.point = p;
		txtPointX.setText(String.valueOf(p.getX()));
		txtPointY.setText(String.valueOf(p.getY()));
		txtColor.setBackground(color);
		color=p.getColor();
	}


	public boolean isOk() {
		return isOk;
	}
	
	public Point getPoint() {
		return this.point;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void validate(String x, String y){
		String s="^(([+-])?([1-9]{1})([0-9]+)?)$";
		if(!x.matches(s) || !y.matches(s)){
			throw new NumberFormatException();
		}
	}
}
