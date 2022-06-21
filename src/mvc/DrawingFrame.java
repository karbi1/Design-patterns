package mvc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dialogDrawing.DlgCircle;
import dialogDrawing.DlgDonut;
import dialogDrawing.DlgRectangle;
import dialogModification.DlgCircleModification;
import dialogModification.DlgDonutModification;
import dialogModification.DlgLineModification;
import dialogModification.DlgPointModification;
import dialogModification.DlgRectangleModification;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;

import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup shapes = new ButtonGroup();
	private final ButtonGroup actions = new ButtonGroup();
	private Color edgeColor = Color.black;
	private Color innerColor = Color.black;

	private Point pointer;

	private JButton btnInnerColor = new JButton("Inner Color");
	private JButton btnEdgeColor = new JButton("Edge Color");
	
	private JButton btnLoadNext;
	
	private JButton btnRedo = new JButton("Redo");
	private JButton btnUndo = new JButton("Undo");
	
	private JButton bbtnToBack;
	private JButton bbtnToFront;
	private JButton bbtnBringToBack;
	private JButton bbtnBringToFront;
	private JButton bbtnModify;
	private JButton bbtnDelete;
	
	

	private final ButtonGroup drawSelect = new ButtonGroup();
	private final ButtonGroup undoRedo = new ButtonGroup();
	
	JList list;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	
	private DrawingController controller = new DrawingController();
	private DrawingView view = new DrawingView();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Nikola Bikar IT 76/2018");
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel pnlShapes = new JPanel();
		pnlShapes.setBackground(new Color(135, 206, 250));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));

		view.setBackground(Color.WHITE);

		
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.edgeC(e);
			}
		});

		
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.innerC(e);
			}
		});
		btnUndo.setEnabled(false);
		
		
		btnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.undo();
			}
		});
		undoRedo.add(btnUndo);
		btnRedo.setEnabled(false);
		
		
		btnRedo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.redo();
			}
		});
		undoRedo.add(btnRedo);
		
		JPanel pnlPosition = new JPanel();
		pnlPosition.setBackground(new Color(135, 206, 250));
		
		JButton btnToFront = new JButton("To Front");
		btnToFront.setEnabled(false);
		btnToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.toFront();
			}
		});
		btnToFront.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		
		JButton btnToBack = new JButton("To Back");
		btnToBack.setEnabled(false);
		btnToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.toBack();
			}
		});
		btnToBack.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		
		JButton btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.setEnabled(false);
		btnBringToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.bringToFront();
			}
		});
		btnBringToFront.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		
		JButton btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.setEnabled(false);
		btnBringToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.bringToBack();
			}
		});
		btnBringToBack.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		GroupLayout gl_pnlPosition = new GroupLayout(pnlPosition);
		gl_pnlPosition.setHorizontalGroup(
			gl_pnlPosition.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPosition.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnToFront, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnToBack, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBringToFront)
					.addGap(18)
					.addComponent(btnBringToBack, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(295, Short.MAX_VALUE))
		);
		gl_pnlPosition.setVerticalGroup(
			gl_pnlPosition.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPosition.createSequentialGroup()
					.addGroup(gl_pnlPosition.createParallelGroup(Alignment.LEADING)
						.addComponent(btnToFront)
						.addComponent(btnToBack, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlPosition.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBringToFront, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBringToBack, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlPosition.setLayout(gl_pnlPosition);
	
		
		JButton btnSaveDrawing = new JButton("Save Drawing");
		btnSaveDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.saveDrawing();
			}
		
		});
		
		JButton btnLoadDrawing = new JButton("Load Drawing");
		btnLoadDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.loadDrawing();
			}
		});
		
		JButton btnSaveLog = new JButton("Save Log");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.saveLog();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnLoadNext = new JButton("Load Next");
		btnLoadNext.setEnabled(false);
		btnLoadNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.loadNext();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
		});
		btnLoadNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnLoadLog = new JButton("Load Log");
		btnLoadLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.loadLog();
			}
		});
		
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRedo)
						.addComponent(btnUndo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoadNext))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(pnlPosition, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSaveLog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLoadLog, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnLoadDrawing)
										.addComponent(btnSaveDrawing)))
								.addComponent(pnlShapes, GroupLayout.PREFERRED_SIZE, 799, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(44)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(28)
											.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE))
										.addComponent(view, GroupLayout.PREFERRED_SIZE, 803, GroupLayout.PREFERRED_SIZE))))))
					.addGap(29))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnUndo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRedo))
						.addComponent(pnlShapes, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSaveDrawing)
								.addComponent(btnSaveLog))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLoadDrawing)
								.addComponent(btnLoadLog)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnLoadNext, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlPosition, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(view, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addGap(38))
		);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		list.setModel(dlm);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.delete(e);
			}
		});
		actions.add(btnDelete);
		btnDelete.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));

		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.clear();
			}
		});
		actions.add(btnClear);
		btnClear.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		
				JButton btnModify = new JButton("Modify");
				btnModify.setEnabled(false);
				btnModify.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						controller.modify(e);
					}
				});
				actions.add(btnModify);
				btnModify.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addGap(9))
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addComponent(btnDelete)
								.addContainerGap()))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JRadioButton rbtnDraw = new JRadioButton("Draw");

		rbtnDraw.setBackground(new Color(176, 196, 222));
		drawSelect.add(rbtnDraw);
		rbtnDraw.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));


		JRadioButton rbtnSelect = new JRadioButton("Select");
		rbtnSelect.setBackground(new Color(176, 196, 222));
		drawSelect.add(rbtnSelect);
		rbtnSelect.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_panel.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbtnSelect).addGap(18))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(rbtnDraw).addContainerGap(24,
						Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(rbtnDraw, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(rbtnSelect, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(82, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JToggleButton btnPoint = new JToggleButton("Point");
		shapes.add(btnPoint);
		btnPoint.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));

		JToggleButton btnLine = new JToggleButton("Line");
		shapes.add(btnLine);
		btnLine.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));

		JToggleButton btnRectangle = new JToggleButton("Rectangle");
		shapes.add(btnRectangle);
		btnRectangle.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));

		JToggleButton btnCircle = new JToggleButton("Circle");
		shapes.add(btnCircle);
		btnCircle.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));

		JToggleButton btnDonut = new JToggleButton("Donut");
		shapes.add(btnDonut);
		btnDonut.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));
		
		JToggleButton btnHexagon = new JToggleButton("Hexagon");
		shapes.add(btnHexagon);
		btnHexagon.setFont(new Font("Segoe UI Historic", Font.PLAIN, 23));
		GroupLayout gl_pnlShapes = new GroupLayout(pnlShapes);
		gl_pnlShapes.setHorizontalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPoint, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLine, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDonut)
					.addGap(18)
					.addComponent(btnHexagon)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_pnlShapes.setVerticalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addGroup(gl_pnlShapes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPoint)
						.addComponent(btnLine, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRectangle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCircle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDonut, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHexagon, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		pnlShapes.setLayout(gl_pnlShapes);
		contentPane.setLayout(gl_contentPane);
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				controller.mouseClicked(e);
			}
		});
		rbtnDraw.addItemListener(new ItemListener() {
			@SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					view.setCursor(new Cursor(CROSSHAIR_CURSOR));
				}
			}
		});
		
		bbtnModify = btnModify;
		bbtnToBack = btnToBack;
		bbtnToFront = btnToFront;
		bbtnBringToBack = btnBringToBack;
		bbtnBringToFront = btnBringToFront;
		bbtnDelete = btnDelete;
	}
	public JButton getBbtnToBack() {
		return bbtnToBack;
	}

	public void setBbtnToBack(JButton bbtnToBack) {
		this.bbtnToBack = bbtnToBack;
	}

	public JButton getBbtnToFront() {
		return bbtnToFront;
	}

	public void setBbtnToFront(JButton bbtnToFront) {
		this.bbtnToFront = bbtnToFront;
	}

	public JButton getBbtnBringToBack() {
		return bbtnBringToBack;
	}

	public void setBbtnBringToBack(JButton bbtnBringToBack) {
		this.bbtnBringToBack = bbtnBringToBack;
	}

	public JButton getBbtnBringToFront() {
		return bbtnBringToFront;
	}

	public void setBbtnBringToFront(JButton bbtnBringToFront) {
		this.bbtnBringToFront = bbtnBringToFront;
	}

	public JButton getBbtnModify() {
		return bbtnModify;
	}

	public void setBbtnModify(JButton bbtnModify) {
		this.bbtnModify = bbtnModify;
	}

	public JButton getBbtnDelete() {
		return bbtnDelete;
	}

	public void setBbtnDelete(JButton bbtnDelete) {
		this.bbtnDelete = bbtnDelete;
	}

	public ButtonGroup getButtonGroup() {
		return drawSelect;
	}

	public ButtonGroup getShapes() {
		return shapes;
	}

	public ButtonGroup getActions() {
		return actions;
	}
	
	public JList getList(){
		return list;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}
	
	public JButton getBtnLoadNext(){
		return btnLoadNext;
	}
	
	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public ButtonGroup getDrawSelect() {
		return drawSelect;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public DrawingView getView() {
		return view;
	}
}
