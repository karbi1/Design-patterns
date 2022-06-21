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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgCircle extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JTextField txtRadius;
	private boolean isOk;
	private JButton btnOk;
	private JButton btnCancel;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setResizable(false);
		setModal(true);
		setTitle("Circle");
		getContentPane().setBackground(new Color(135, 206, 250));
		setBounds(100, 100, 415, 310);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(135, 206, 250));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.NORTH);
		
		JLabel lblCircle = new JLabel("Circle");
		lblCircle.setForeground(new Color(255, 0, 0));
		lblCircle.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setForeground(new Color(255, 0, 0));
		lblRadius.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtRadius = new JTextField();
		txtRadius.setForeground(new Color(255, 0, 0));
		txtRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtRadius.setBackground(new Color(176, 196, 222));
		txtRadius.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCircle, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addComponent(lblCircle, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			pnlSouth.setLayout(new GridLayout(0, 2, 0, 0));
			{
				btnOk  = new JButton("OK");
				btnOk.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtRadius.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Some of the fields are empty, insert radius", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						try {
							validate(txtRadius.getText());
						} catch ( NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Please insert number", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						if(Integer.parseInt(txtRadius.getText())<0){
							JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
						}else{
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
	
	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}
	
	public void validate(String radius){
		String x="^(([+-])?([1-9]{1})([0-9]+)?)$";
		if(!radius.matches(x)){
			throw new NumberFormatException();
		}
	}
}
