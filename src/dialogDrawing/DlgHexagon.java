package dialogDrawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adapter.HexagonAdapter;
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

public class DlgHexagon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private boolean isOk;
	private Point center;
	private int radius;
	private int centerX;
	private int centerY;
	private HexagonAdapter hexagon;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgHexagon dialog = new DlgHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgHexagon() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblHexagon = new JLabel("Hexagon");
		lblHexagon.setForeground(Color.RED);
		lblHexagon.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setForeground(Color.RED);
		lblRadius.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		
		txtRadius = new JTextField();
		txtRadius.setForeground(Color.RED);
		txtRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtRadius.setColumns(10);
		txtRadius.setBackground(new Color(176, 196, 222));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblHexagon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRadius, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(227, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblHexagon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(152, Short.MAX_VALUE))
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
							validate(txtRadius.getText());
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Wrong input", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
							return;
						}
						if(txtRadius.getText().trim().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Text fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk=false;
						}else if(Integer.parseInt(txtRadius.getText()) <= 0){
							JOptionPane.showMessageDialog(null, "Radius value needs to be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE, null);
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
	public void validate(String radius) {
		String exp = "^(([1-9]{1})([0-9]+)?)$";
		if (radius.equals("") )
			;
		else if (!radius.matches(exp)) {
			throw new NumberFormatException();
		}
	}
	


	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
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


}
