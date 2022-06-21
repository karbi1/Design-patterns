package dialogDrawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangleSortStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private Exception exc;
	
	protected int x, y, width, height;
	protected String innerColor, borderColor;
	private Rectangle rect;
	private boolean accepted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleSortStack dialog = new DlgRectangleSortStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleSortStack() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblX = new JLabel("Coordinate X:");
		lblX.setForeground(new Color(255, 0, 0));
		lblX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		JLabel lblY = new JLabel("Coordinate Y:");
		lblY.setForeground(new Color(255, 0, 0));
		lblY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setForeground(new Color(255, 0, 0));
		lblWidth.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(new Color(255, 0, 0));
		lblHeight.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		
		txtX = new JTextField();
		txtX.setForeground(new Color(255, 0, 0));
		txtX.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		txtX.setBackground(new Color(176, 196, 222));
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		txtY.setForeground(new Color(255, 0, 0));
		txtY.setBackground(new Color(176, 196, 222));
		txtY.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setForeground(new Color(255, 0, 0));
		txtWidth.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		txtWidth.setBackground(new Color(176, 196, 222));
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		txtHeight.setForeground(new Color(255, 0, 0));
		txtHeight.setBackground(new Color(176, 196, 222));
		txtHeight.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try 
						{
							setAccepted(true);
							x = Integer.parseInt(txtX.getText());
							y = Integer.parseInt(txtY.getText());
							width = Integer.parseInt(txtWidth.getText());
							height = Integer.parseInt(txtHeight.getText());
							
							
							if (x>=0 && y>=0 && width>0 && height>0) 
							{
								setRect(new Rectangle(new Point(x,y), height, width));
							}							
							else throw exc;
							
							setVisible(false);
						} 
						catch (Exception exc) 
						{
							JOptionPane.showMessageDialog(null, "Please, fill the fields with integers!!", "Error", JOptionPane.ERROR_MESSAGE);
							
						}

					}
				});
				btnOk.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setAccepted(false);
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
