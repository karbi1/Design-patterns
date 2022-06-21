package sortStack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dialogDrawing.DlgRectangleSortStack;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private String rect;
	private int numOfElem;
	DefaultListModel dlm = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() 
	{
		setTitle("IT 76-2018 Bikar Nikola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
								
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
								
		Panel pnlButtons = new Panel();
		panel.add(pnlButtons);
								
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DlgRectangleSortStack dlgadd = new DlgRectangleSortStack();
				dlgadd.setVisible(true);
				
				if (dlgadd.isAccepted())
				{
					rect = dlgadd.getRect().toString();
					dlm.add(0, rect);
					numOfElem = dlm.getSize();
				}
			}
		});
		pnlButtons.setLayout(new GridLayout(0, 2, 0, 0));
		pnlButtons.add(btnAdd);
								
		JButton btnDelete = new JButton("Remove");
		btnDelete.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (numOfElem > 0)
				{
					rect = dlm.remove(0).toString();
					
					JOptionPane.showMessageDialog(null,rect  , "Deleted element:",
							JOptionPane.INFORMATION_MESSAGE);
					numOfElem = dlm.getSize();
				}
				else 					
					JOptionPane.showMessageDialog(null, "Stack is empty",
							"Error", JOptionPane.ERROR_MESSAGE);

			}
		});
		pnlButtons.add(btnDelete);
								
		JPanel pnlStack = new JPanel();
		getContentPane().add(pnlStack, BorderLayout.CENTER);
		GridBagLayout gbl_pnlStack = new GridBagLayout();
		gbl_pnlStack.columnWidths = new int[]{0, 0};
		gbl_pnlStack.rowHeights = new int[]{0, 0};
		gbl_pnlStack.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlStack.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlStack.setLayout(gbl_pnlStack);
								
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlStack.add(scrollPane, gbc_scrollPane);
								
		JList list = new JList();
		list.setBackground(new Color(135, 206, 250));
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}
}

