package dialogDrawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHeight;
	private JTextField txtWidth;
	private boolean isOk;
	private Color innerColor;
	private Color edgeColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblRectangle = new JLabel("Rectangle");
		lblRectangle.setForeground(Color.RED);
		lblRectangle.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblRectangle.setBackground(new Color(173, 255, 47));
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setForeground(Color.RED);
		lblWidth.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.RED);
		lblHeight.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		txtHeight = new JTextField();
		txtHeight.setForeground(Color.RED);
		txtHeight.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtHeight.setColumns(10);
		txtHeight.setBackground(new Color(176, 196, 222));
		txtWidth = new JTextField();
		txtWidth.setForeground(Color.RED);
		txtWidth.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtWidth.setColumns(10);
		txtWidth.setBackground(new Color(176, 196, 222));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRectangle, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
					.addGap(216))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblRectangle)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnDraw = new JButton("Draw");
				btnDraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtHeight.getText().trim().equals("") || txtWidth.getText().trim().equals(""))
						{
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Some of the fields are empty!!","Error",JOptionPane.ERROR_MESSAGE,null);
							isOk=false;
							return;
						}
						try {
							validate(txtHeight.getText(),txtWidth.getText());
						} catch (NumberFormatException e3) {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Please insert number!","Error",JOptionPane.ERROR_MESSAGE,null);
							isOk=false;
							return;
						}
						if(Integer.parseInt(txtHeight.getText())<0 || Integer.parseInt(txtWidth.getText())<0 ){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Width or height cannot be  negative numbers!!","Error",JOptionPane.ERROR_MESSAGE,null);
							isOk=false;
							return;
						}
						else{
								isOk=true;
								dispose();
							}
					}
				});
				btnDraw.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnDraw.setActionCommand("OK");
				buttonPane.add(btnDraw);
				getRootPane().setDefaultButton(btnDraw);
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
	public void validate(String height,String width){
		String x="^(([+-])?([1-9]{1})([0-9]+)?)$";
		if(!height.matches(x) || !width.matches(x)){
			throw new NumberFormatException();
		}
	
}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}





}
