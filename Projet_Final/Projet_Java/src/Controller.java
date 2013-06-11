import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.nio.*;

public class Controller implements ActionListener,ListSelectionListener{
	View v;
	Window w;
	ArrayList<String> l = new ArrayList<String>();
	Connection	con;
	Statement stm;
	ResultSet rs;
	int i;
	
	public Controller(View v){
		super();
		this.v=v;
	}
	public Controller(Window w){
		super();
		this.w=w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj=e.getSource();
		String url = "jdbc:mysql://localhost:3306/java";
	      String user = "root";
	      String password = "";
	      
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      String queryString = "SELECT * FROM photo";
	    
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
	    
	    //****************À PROPOS*****************
	      if(obj.equals(v.btnPropos)){
	    	  JOptionPane.showMessageDialog(v, "*******************************************\n****************CALIBRINI****************\n*******************************************\nDéveloppé Par : \n\tRAHHALI Mohammed Amine\n\tBENREGHAI Mohamed El Mehdi\n\tHAMEUR Youssef\n\tLeini Dima" +
	    			  "\n*******************************************\n    Encadré Par: Mr Lopes & Mr Yeh \n*******************************************\n\t ISTY-INI1 2013 ");
	      }
	    //****************TAG***************** 
	      if(obj.equals(v.btnTag)){
	    	  String text = (String) v.list.getSelectedValue();
				if (text.length() == 0) {
					v.sorter.setRowFilter(null);
				} 
				else {
					try {
						v.sorter.setRowFilter(
						RowFilter.regexFilter(text));
						} 
						catch (PatternSyntaxException pse) {
							System.err.println("Bad regex pattern");
						}
					}
	      }
	    //****************STOCKER*****************  
	    if(obj.equals(v.btnStocker)){
	    String destination="/Users/mohammedaminerahhali/Desktop/workspace/Projet_Java/les images/";
		File from = new File(v.chemin.toString());
		File to = new File(destination.toString()); 
		task t = new task(from,to);
		t.start();


	}
		
		//****************VISUALISER*****************
	      if(obj.equals(v.btnVisualiser)){
	      try
			{
				Desktop myDesktop = null;
					if (Desktop.isDesktopSupported())
						myDesktop = Desktop.getDesktop();
					if (myDesktop != null)
					{
						File myFile = new File(v.chemin); 
						if (myFile.exists())
							myDesktop.open(myFile);
						else
							System.out.println("This file is not a valid one");
					}
					else
						JOptionPane.showMessageDialog(v, "aucun fichier selectioné");
					
					
			}
			catch (IOException ee)
			{
				ee.printStackTrace();
			}

		}
	    //****************RECHERCHER*****************
			
	      if(obj.equals(v.btnRechercher)){
				String text = v.txt.getText();
				if (text.length() == 0) {
					v.sorter.setRowFilter(null);
				} 
				else {
					try {
						v.sorter.setRowFilter(
						RowFilter.regexFilter(text));
						} 
						catch (PatternSyntaxException pse) {
							System.err.println("Bad regex pattern");
						}
					}
				}
			
			
	    //****************MODIFIER*****************
	      if(obj.equals(v.btnModifier)){
	    	  new Window("coco",v.type,v.date,v.taille);
	    	 // System.out.println(v.taille+" "+v.type+" "+v.date+" "+v.titre);
	    	// w.txtTitre.setText("amine");
	    	// w.txtTitre.setText(v.titre);
	    	// w.txtType.setText(v.type);
	    	// w.txtTaille.setText(v.taille);
	    	// w.txtDate.setText(v.date);
	   
	      }
		//****************AJOUTER******************
			
		
		if(obj.equals(v.btnAjouter)){
			JFileChooser ch= new JFileChooser();
			int returnval = ch.showDialog(v, "OK");		     
			if(returnval==0){
				File file=ch.getSelectedFile();	
				String titre;
				String str=file.getPath();
				String nom=file.getName();
				
				long taille=file.length();
				int dif=(nom.length()-nom.indexOf("."));
				if(dif==4)
					titre=nom.substring(0,nom.length()-4);
				else
					titre=nom.substring(0,nom.length()-5);
				Date creationDate = new Date(file.lastModified());
				String ext = str.substring(str.lastIndexOf(".")); 				 
	
		
					if(str.endsWith("txt")||str.endsWith("pdf")||str.endsWith("gif")||str.endsWith("jpg")||str.endsWith("jpeg")||str.endsWith("png")||str.endsWith("doc")||str.endsWith("mp3")||str.endsWith("mp4")||str.endsWith("avi")||str.endsWith("xls")){
						v.img=new ImageIcon(str);
						
						v.lbl_vignette.setIcon(v.img);
						
						v.lbl_titre.setText("Titre : "+titre);
						v.lbl_auteur.setText("Date : "+creationDate);
						v.lbl_type.setText("Type :"+ext);

String url1 = "jdbc:mysql://localhost:3306/java";
String user1 = "root";
String password1 = "";
 
try {
	con = DriverManager.getConnection(url1, user1, password1);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}						
String queryString1 = "INSERT INTO photo VALUES('"+titre+"','"+ext+"','"+creationDate+"','"+taille+" octes','"+str+"')";				    

	try {
		stm = con.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		stm.executeUpdate(queryString1);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

							
						//v.list.setListData(l.toArray());
						
					}
					else
						JOptionPane.showMessageDialog(v, "Mauvais Format");
			}
		}
		//v.Update_table();
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

			
		}

		
	}

	




