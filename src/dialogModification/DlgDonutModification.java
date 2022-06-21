package dialogModification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class DlgDonutModification extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtY;
	private JTextField txtX;
	private JTextField txtRadius;
	private boolean isOk;
	private Donut d;
	private int x = 0;
	private int y = 0;
	private int radius = 0;
	private int innerRadius = 0;

	private Color edgeColor = Color.black;
	private Color innerColor = Color.black;
	private JTextField txtInnerRadius;
	private JTextField txtInner;
	private JTextField txtEdge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutModification dialog = new DlgDonutModification();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutModification() {
		setResizable(false);
		setModal(true);
		setTitle("Donut Modification");
		setBackground(Color.WHITE);
		setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenter = new JLabel("Center:");
		lblCenter.setForeground(new Color(255, 0, 0));
		lblCenter.setBackground(new Color(173, 255, 47));
		lblCenter.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		JLabel lblX = new JLabel("X:");
		lblX.setForeground(new Color(255, 0, 0));
		lblX.setBackground(new Color(255, 0, 0));
		lblX.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		JLabel lblY = new JLabel("Y:");
		lblY.setForeground(new Color(255, 0, 0));
		lblY.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		txtY = new JTextField();
		txtY.setForeground(new Color(255, 0, 0));
		txtY.setBackground(new Color(176, 196, 222));
		txtY.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtY.setColumns(10);
		txtX = new JTextField();
		txtX.setForeground(new Color(255, 0, 0));
		txtX.setBackground(new Color(176, 196, 222));
		txtX.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtX.setColumns(10);
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setForeground(new Color(255, 0, 0));
		lblRadius.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		txtRadius = new JTextField();
		txtRadius.setForeground(new Color(255, 0, 0));
		txtRadius.setBackground(new Color(176, 196, 222));
		txtRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtRadius.setColumns(10);

		JLabel lblDonutModification = new JLabel("Donut Modification");
		lblDonutModification.setForeground(Color.RED);
		lblDonutModification.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblDonutModification.setBackground(new Color(173, 255, 47));

		JLabel lblInnerRadius = new JLabel("Inner Radius:");
		lblInnerRadius.setForeground(Color.RED);
		lblInnerRadius.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));

		txtInnerRadius = new JTextField();
		txtInnerRadius.setForeground(Color.RED);
		txtInnerRadius.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		txtInnerRadius.setColumns(10);
		txtInnerRadius.setBackground(new Color(176, 196, 222));

		JButton btnInnerColor = new JButton("Inner color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Inner Color", innerColor);
				if (innerColor == null) {
					innerColor = Color.black;
					txtInner.setBackground(Color.black);
				} else {
					txtInner.setBackground(innerColor);
				}
			}
		});
		btnInnerColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));

		JButton btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Edge Color", edgeColor);
				if (edgeColor == null) {
					edgeColor = Color.black;
					txtEdge.setBackground(Color.black);
				} else {
					txtEdge.setBackground(edgeColor);
				}
			}
		});
		btnEdgeColor.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));

		txtInner = new JTextField();
		txtInner.setEditable(false);
		txtInner.setColumns(10);

		txtEdge = new JTextField();
		txtEdge.setEditable(false);
		txtEdge.setColumns(10);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
								.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
												.createSequentialGroup().addGroup(
														gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
																.addComponent(lblInnerRadius,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGroup(gl_contentPanel
																				.createParallelGroup(Alignment.TRAILING,
																						false)
																				.addComponent(lblRadius,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(lblCenter,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 57,
																						Short.MAX_VALUE))
																		.addGap(5).addComponent(lblX,
																				GroupLayout.PREFERRED_SIZE, 43,
																				GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(txtX, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtRadius, 0, 0, Short.MAX_VALUE)
														.addComponent(txtInnerRadius, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE))
												.addGap(94)
												.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 43,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtY,
														GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(Alignment.LEADING,
														gl_contentPanel.createSequentialGroup()
																.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE,
																		105, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(txtEdge, GroupLayout.PREFERRED_SIZE, 44,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.LEADING,
														gl_contentPanel.createSequentialGroup()
																.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE,
																		105, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, 44,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(lblDonutModification, Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(94, Short.MAX_VALUE)));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_contentPanel.createSequentialGroup()
								.addComponent(lblDonutModification, GroupLayout.PREFERRED_SIZE, 37,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCenter, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblX).addComponent(lblY)
										.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblRadius).addComponent(txtRadius, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInnerRadius, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 26,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEdge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))));

		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnEdit = new JButton("Edit");
				btnEdit.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							validate(txtX.getText(), txtY.getText(), txtRadius.getText(), txtInnerRadius.getText());
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "Wrong input", "Error", JOptionPane.ERROR_MESSAGE,
									null);
							isOk = false;
							return;
						}
						if (txtRadius.getText().trim().equals("") || txtX.getText().trim().equals("")
								|| txtY.getText().trim().equals("") || txtInnerRadius.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "Text fields cannot be empty!", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
						} else if (Integer.parseInt(txtRadius.getText()) < Integer.parseInt(txtInnerRadius.getText())) {
							JOptionPane.showMessageDialog(null,
									"Radius value needs to be greater than inner radius value!", "Error",
									JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						} else {
							x = Integer.parseInt(txtX.getText());
							y = Integer.parseInt(txtY.getText());
							radius = Integer.parseInt(txtRadius.getText());
							innerRadius = Integer.parseInt(txtInnerRadius.getText());

							isOk = true;
							dispose();
						}
					}
				});
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
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

	public void validate(String x, String y, String radius, String innerRadius) {
		String exp = "^(([1-9]{1})([0-9]+)?)$";
		if (radius.equals("") || x.equals("") || y.equals("") || innerRadius.equals(""))
			;
		else if (!radius.matches(exp) || !innerRadius.matches(exp) || !x.matches(exp) || !y.matches(exp)) {
			throw new NumberFormatException();
		}
	}

	public void fillFields(Donut d) {
		this.d = d;
		txtX.setText(String.valueOf(d.getCenter().getX()));
		txtY.setText(String.valueOf(d.getCenter().getY()));
		txtRadius.setText(String.valueOf(d.getRadius()));
		txtInnerRadius.setText(String.valueOf(d.getInnerRadius()));
		txtEdge.setBackground(d.getColor());
		txtInner.setBackground(d.getInnerColor());
		edgeColor = d.getColor();
		innerColor = d.getInnerColor();
	}

	public Donut getDonut() {
		return this.d;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public int getRadius() {
		return radius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

}
