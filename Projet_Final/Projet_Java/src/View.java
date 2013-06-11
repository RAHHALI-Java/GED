import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;


import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.List;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;

import net.proteanit.sql.DbUtils;
import javax.swing.JSplitPane;
import java.awt.GridLayout;



public class View extends JFrame {

	JPanel contentPane;
	JButton btnAjouter;
	JButton btnModifier;
	JButton btnVisualiser;
	JButton btnRechercher;
	JButton btnStocker;
	ImageIcon img;
	JLabel lbl_vignette;
	JLabel lbl_titre;
	JLabel lbl_auteur;
	JLabel lbl_type;
	JTextField txt;
	Controller c;
	Container cp;
	JPanel panel_2_1,imagePanel;
	JPanel panel_4;
	JPanel panel_5;
	JPanel panel_6;
	JPanel panel_7;
	JTable table;
	TableRowSorter<TableModel> sorter;
	JPanel pane3;
	JFrame fr= new JFrame();
	TableModel model;
	String rows[][];
	Statement stm,stm1,stm2;
	Connection con,con1,con2;
	ResultSet rs,rs1,rs2;
	String queryString,queryString1;
	int i;
	static String chemin;
	public Vector data = new Vector();
	JProgressBar progressBar;
	JTextField txt1;
	JSplitPane splitPane;
	JPanel panel_8;
	JButton btnTag;
	JList list,list_1;
	JPanel panel_9;
	JButton btnSerie;
	String url,user,password;
	JButton btnPropos;
	Window w;
	String titre;
    String type;
    String date;
    String taille;
	

	
	View() {
		super("PROJET JAVA");
		initialize();
		c = new Controller(this);
		cp = getContentPane();
		setBounds(100, 100, 792, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		txt = new JTextField();
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setSize(new Dimension(280, 280));
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setMnemonic(KeyEvent.VK_A);
		btnAjouter.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/ajouter_appareil.png"));
		panel.add(btnAjouter);
		btnAjouter.addActionListener(c);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(c);
		btnModifier.setMnemonic(KeyEvent.VK_M);
		btnModifier.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/modifier.png"));
		panel.add(btnModifier);
		btnModifier.addActionListener(c);
			
		btnVisualiser = new JButton("Visualiser");
		btnVisualiser.setMnemonic(KeyEvent.VK_V);
		btnVisualiser.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/v2.jpg"));
		panel.add(btnVisualiser);
		btnVisualiser.addActionListener(c);
		
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setToolTipText("alt+r\n");
		btnRechercher.setMnemonic(KeyEvent.VK_R);
		btnRechercher.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/R2.png"));
		panel.add(btnRechercher);
		btnRechercher.addActionListener(c);
			
		btnStocker = new JButton("Stocker");
		btnStocker.setMnemonic(KeyEvent.VK_S);
		btnStocker.addActionListener(c);
		
		btnStocker.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/download-icone-6877-48.png"));
		panel.add(btnStocker);
		
		btnPropos = new JButton("\u00C0 Propos");
		btnPropos.setIcon(new ImageIcon("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/aide-point-interrogation-systeme-icone-9280-48.png"));
		panel.add(btnPropos);
		btnPropos.addActionListener(c);
		
		JPanel panell= new JPanel();
		panell.setBorder(new LineBorder(new Color(0, 0, 0)));
		JPanel panel_1 = new JPanel(new BorderLayout());
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.add(panell, BorderLayout.NORTH);
		
		splitPane = new JSplitPane();
		panell.add(splitPane);
		
		panel_8 = new JPanel();
		splitPane.setLeftComponent(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnTag = new JButton("Tag");
		panel_8.add(btnTag);
		btnTag.addActionListener(c);
		
		list = new JList();
		panel_8.add(list);
		list.addListSelectionListener(c);
		
		url = "jdbc:mysql://localhost:3306/java";
	    user = "root";
	    password = "";
		
		try {
			con2 = DriverManager.getConnection(url, user, password);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String sql="select distinct type from photo";
		try {
			stm2=con2.prepareStatement(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs2=stm2.executeQuery(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		DefaultListModel dlm = new DefaultListModel();
		try {
			while(rs2.next()){
				dlm.addElement(rs2.getString("type"));
				
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		list.setModel(dlm);
		panel_9 = new JPanel();
		splitPane.setRightComponent(panel_9);
		panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		
		btnSerie = new JButton("Serie");
		panel_9.add(btnSerie);
		
		list_1 = new JList();
		panel_9.add(list_1);
		contentPane.add(panel_1, BorderLayout.WEST);
		Panel panel_3 = new Panel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		rows = new String[20][5];
		// Specifier les noms des colomnes
		String columns[] = {"Titre","Type","Date","Taille"}; 
		
		//***********************************************************************************************
		      
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      queryString = "SELECT * FROM photo";
		    
			try {
				stm = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      try {
				rs = stm.executeQuery(queryString);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      //cont = new String[20][4];
		      try {
				while (rs.next()) {
				      String titre = rs.getString("titre");
				      String type = rs.getString("type");
				      String date = rs.getString("date");
				      String taille = rs.getString("taille");
				      rows[i][0] = titre;
				      rows[i][1] = type;
				      rows[i][2] = date;
				      rows[i][3] = taille;
				      i++;
				    }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
			//***********************************************************************************************
		model = new DefaultTableModel(rows,columns){
  		public Class getColumnClass(int column) {
  			Class returnValue;
  			if ((column >= 0) && (column < getColumnCount())) {
  					returnValue = getValueAt(0, column).getClass();
  				} 
  				else {
  					returnValue = Object.class;
  				}
  				return returnValue;
  			}
  		};
		  	//Creation de TableModel
		final JTable table = new JTable(model);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		JScrollPane pane = new JScrollPane(table);
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		table.setCellSelectionEnabled(true);
		ListSelectionModel cellSelection = table.getSelectionModel();
		cellSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelection.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        String selectedData = null;
		        int selectedRow = table.getSelectedRow();
		        int selectedColumns = table.getSelectedColumn();
		        selectedData = (String) table.getValueAt(selectedRow, selectedColumns);
		       
		        String url = "jdbc:mysql://localhost:3306/java";
			      String user = "root";
			      String password = "";
		    	try {
					con1 = DriverManager.getConnection(url, user, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      queryString1 = "SELECT * FROM photo where titre='"+selectedData+"'";
			    
				try {
					stm1 = con1.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      try {
					rs1 = stm1.executeQuery(queryString1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  
			      try {
						while (rs1.next()) {
						      titre = rs1.getString("titre");
						      type = rs1.getString("type");
						      date = rs1.getString("date");
						      taille = rs1.getString("taille");
						      chemin = rs1.getString("chemin");
						      img=new ImageIcon(chemin);
							  lbl_vignette.setIcon(img);
							  lbl_titre.setText("Titre : "+titre);
							  lbl_auteur.setText("Date : "+date);
							  lbl_type.setText("Type :"+type);
											      
						      i++;
						    }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
		      }

		    });
		panel_3.add(pane,BorderLayout.NORTH);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		JLabel lbl_recherche = new JLabel("Rechercher");
		lbl_recherche.setHorizontalAlignment(SwingConstants.LEFT);
		pane3 =new JPanel();
		pane3.add(lbl_recherche,FlowLayout.LEFT);		
	

		BorderLayout bl_pane2 = new BorderLayout();
		
		bl_pane2.setHgap(50);
		JPanel pane2=new JPanel(bl_pane2);
		pane2.add(pane3,BorderLayout.CENTER);
		
		txt = new JTextField();
		pane3.add(txt);
		txt.setColumns(10);
		pane2.add(progressBar,BorderLayout.SOUTH);
		
		panel_3.add(pane2,BorderLayout.CENTER);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		
		lbl_vignette = new JLabel();
		lbl_vignette.setHorizontalAlignment(SwingConstants.CENTER);
		Dimension dimension = new Dimension(250,150);
		lbl_vignette.setMaximumSize(dimension);
		lbl_vignette.setMinimumSize(dimension);
		lbl_vignette.setPreferredSize(dimension);
		panel_4.add(lbl_vignette);
	
		panel_4.setBorder(new TitledBorder(null, "Vignette", TitledBorder.LEADING, TitledBorder.TOP, null, null));	
		
		panel_2_1 = new JPanel();
		panel_2_1.setLayout(new BorderLayout(0, 0));
		panel_2.add(panel_2_1);
		
		panel_5 = new JPanel();
		panel_2_1.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lbl_titre = new JLabel();
		panel_6 = new JPanel();
		panel_6.add(lbl_titre);
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		lbl_type = new JLabel();
		panel_5.add(lbl_type, BorderLayout.SOUTH);
		
		lbl_type.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_type.setVerticalAlignment(SwingConstants.TOP);
		
		panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		
		lbl_auteur = new JLabel();
		panel_7.add(lbl_auteur);
		
		
		this.setLocationRelativeTo(null);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
/*	protected void Update_table(){
		try{
			String url = "jdbc:mysql://localhost:3306/java";
			String user = "root";
			String password = "";
		    con2 = DriverManager.getConnection(url, user, password);
			String sql="select distinct type from photo";
			stm2=con2.prepareStatement(sql);
			rs2=stm2.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs2));
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}*/
	
	private void initialize() {
		cp = getContentPane();
		imagePanel = new JPanel() {
			public void paint(Graphics g) {
				try {
					BufferedImage image = ImageIO.read(new File("/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/Images_Pour_Projet-ID/background.jpg"));
					g.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		imagePanel.setPreferredSize(new Dimension(640, 480));
		cp.add(imagePanel);
	}

}





