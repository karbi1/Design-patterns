package sortStack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import dialogDrawing.DlgRectangleSortStack;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class FrmSort extends JFrame 
{
	private JPanel contentPane;

	private Rectangle rect;
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
					FrmSort frame = new FrmSort();
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
	public FrmSort() 
	{
		setTitle("IT 76-2018 Bikar Nikola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel pnlButtons = new Panel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DlgRectangleSortStack DlgRectangleSortStack = new DlgRectangleSortStack();
				DlgRectangleSortStack.setVisible(true);

				if(DlgRectangleSortStack.isAccepted())
				{
					rect = DlgRectangleSortStack.getRect();
					dlm.addElement(rect);
					numOfElem = dlm.getSize();
				}
			}
		});
		pnlButtons.setLayout(new GridLayout(0, 2, 0, 0));
		pnlButtons.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		btnSort.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(numOfElem> 1)
				{
					for(int i = 0 ; i < numOfElem ; i++)
					{
						Rectangle rect1 = (Rectangle) dlm.get(i);
						
						for(int j = i+1 ; j < numOfElem ; j++)
						{
							Rectangle rect2 = (Rectangle) dlm.get(j);
							
							if(rect1.area()> rect2.area())
							{
								dlm.set(i, rect2);
								dlm.set(j, rect1);
							}
						}
					}
				}
			}
		});
		pnlButtons.add(btnSort);
		
		Panel pnlList = new Panel();
		getContentPane().add(pnlList, BorderLayout.CENTER);
		GridBagLayout gbl_pnlLista = new GridBagLayout();
		gbl_pnlLista.columnWidths = new int[]{0, 0};
		gbl_pnlLista.rowHeights = new int[]{0, 0};
		gbl_pnlLista.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlLista.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlList.setLayout(gbl_pnlLista);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlList.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(255, 0, 0));
		list.setBackground(new Color(135, 206, 250));
		list.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		list.setModel(dlm);
		scrollPane.setViewportView(list);
	}
}
