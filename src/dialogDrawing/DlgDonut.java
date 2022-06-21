package dialogDrawing;

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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private boolean isOk;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblDonut = new JLabel("Donut");
		lblDonut.setForeground(Color.RED);
		lblDonut.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("Radius:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		JLabel label_2 = new JLabel("Inner Radius:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtRadius = new JTextField();
		txtRadius.setForeground(Color.RED);
		txtRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtRadius.setColumns(10);
		txtRadius.setBackground(new Color(176, 196, 222));
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setForeground(Color.RED);
		txtInnerRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtInnerRadius.setColumns(10);
		txtInnerRadius.setBackground(new Color(176, 196, 222));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDonut, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(52)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblDonut, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(96, Short.MAX_VALUE))
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
						try {
							validate(txtRadius.getText(), txtInnerRadius.getText());
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Wrong input", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
							return;
						}
						if(txtRadius.getText().trim().equals("")||  txtInnerRadius.getText().trim().equals("") )
						{
							JOptionPane.showMessageDialog(null, "Text fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
						}else if(Integer.parseInt(txtRadius.getText()) < Integer.parseInt(txtInnerRadius.getText())){
							JOptionPane.showMessageDialog(null, "Radius value needs to be greater than inner radius value!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
							return;
						}else
						{
							isOk=true;
							dispose();
					}}
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
				btnCancel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
	}
	public void validate(String radius, String innerRadius) {
		String exp = "^(([1-9]{1})([0-9]+)?)$";
		if (radius.equals("")  || innerRadius.equals(""))
			;
		else if (!radius.matches(exp) || !innerRadius.matches(exp)) {
			throw new NumberFormatException();
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

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	
}
