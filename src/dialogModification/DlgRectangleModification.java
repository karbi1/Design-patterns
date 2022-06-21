package dialogModification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangleModification extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtY;
	private Color edgeColor;
	private Color innerColor;
	private boolean isOk;
	private Rectangle r;
	private JTextField txtInnerColor;
	private JTextField txtEdgeColor;
	private int x=0;
	private int y=0;
	private int widthI=0;
	private int heightI=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleModification dialog = new DlgRectangleModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleModification() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		JLabel lblRectangleModification = new JLabel("Rectangle Modification");
		lblRectangleModification.setForeground(Color.RED);
		lblRectangleModification.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblRectangleModification.setBackground(new Color(173, 255, 47));
		JLabel lblPoint = new JLabel("Upper left point");
		lblPoint.setForeground(Color.RED);
		lblPoint.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblPoint.setBackground(new Color(173, 255, 47));
		JLabel label_1 = new JLabel("X:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		label_1.setBackground(Color.RED);
		
		txtX = new JTextField();
		txtX.setForeground(Color.RED);
		txtX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtX.setColumns(10);
		txtX.setBackground(new Color(176, 196, 222));
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setForeground(Color.RED);
		lblWidth.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));

		
		txtWidth = new JTextField();
		txtWidth.setForeground(Color.RED);
		txtWidth.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtWidth.setColumns(10);
		txtWidth.setBackground(new Color(176, 196, 222));
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.RED);
		lblHeight.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtHeight = new JTextField();
		txtHeight.setForeground(Color.RED);
		txtHeight.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtHeight.setColumns(10);
		txtHeight.setBackground(new Color(176, 196, 222));
		
		JLabel label_4 = new JLabel("Y:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		label_4.setBackground(Color.RED);
		
		txtY = new JTextField();
		txtY.setForeground(Color.RED);
		txtY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtY.setColumns(10);
		txtY.setBackground(new Color(176, 196, 222));
		
		JButton btnInnerColor = new JButton("Inner color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor=JColorChooser.showDialog(null,"Inner Color",innerColor);
				if(innerColor==null)
				{
					innerColor=Color.black;
					txtInnerColor.setBackground(Color.black);
				}else
				{
					txtInnerColor.setBackground(innerColor);
				}
			}
		});
		btnInnerColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		JButton btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null,"Edge Color",edgeColor);
				if(edgeColor==null)
				{
					edgeColor=Color.black;
					txtEdgeColor.setBackground(Color.black);
				}else
				{
					txtEdgeColor.setBackground(edgeColor);
				}
			}
		});
		btnEdgeColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		txtInnerColor = new JTextField();
		txtInnerColor.setEditable(false);
		txtInnerColor.setForeground(Color.RED);
		txtInnerColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtInnerColor.setColumns(10);
		txtInnerColor.setBackground(new Color(255, 255, 255));
		
		txtEdgeColor = new JTextField();
		txtEdgeColor.setEditable(false);
		txtEdgeColor.setForeground(Color.RED);
		txtEdgeColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtEdgeColor.setColumns(10);
		txtEdgeColor.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRectangleModification)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEdgeColor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(txtX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtY, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblRectangleModification, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInnerColor)
						.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEdgeColor, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							validate(txtWidth.getText(),txtX.getText(),txtY.getText(),txtHeight.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Invalid data type inserted!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
							return;
						}
						if(txtWidth.getText().trim().equals("")|| txtX.getText().trim().equals("") || txtY.getText().trim().equals("") || txtHeight.getText().trim().equals("") )
						{
							JOptionPane.showMessageDialog(null, "Text fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
						}else if(Integer.parseInt(txtWidth.getText()) < 0 || Integer.parseInt(txtHeight.getText()) < 0){
							JOptionPane.showMessageDialog(null, "Height or width cannot be negative numbers!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
							
						}else
						{
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							widthI=Integer.parseInt(txtWidth.getText());
							heightI=Integer.parseInt(txtHeight.getText());

							dispose();
							isOk=true;
						}
					}
					
				});
				btnEdit.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
	}
	}

	public void validate(String tWidth, String x, String y, String tHeight) {
		String exp = "^(([1-9]{1})([0-9]+)?)$";
		if (tHeight.equals("") || x.equals("") || y.equals("") || tWidth.equals(""))
			;
		else if (!tHeight.matches(exp) || !tWidth.matches(exp) || !x.matches(exp) || !y.matches(exp)) {
			throw new NumberFormatException();
		}
	}
	public void fillFields(Rectangle r)
	{
		this.r = r;
		txtX.setText(String.valueOf(r.getUpperLeftPoint().getX()));
		txtY.setText(String.valueOf(r.getUpperLeftPoint().getY()));
		txtWidth.setText(String.valueOf(r.getWidth()));
		txtHeight.setText(String.valueOf(r.getHeight()));
		txtEdgeColor.setBackground(r.getColor());
		txtInnerColor.setBackground(r.getInnerColor());
		edgeColor=r.getColor();
		innerColor=r.getInnerColor();
		
	}
	


	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	public Rectangle getRectangle() {
		return this.r;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getWidthI(){
		return this.widthI;
	}
	
	public int getHeightI(){
		return this.heightI;
	}
}
