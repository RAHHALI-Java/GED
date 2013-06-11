import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;


public class Window extends JFrame{
	JLabel lblTitre;
	JLabel lblType;
	JLabel lblDate;
	JLabel lblTaille;
	GridLayout gl;
	JTextField txtTitre;
	JTextField txtDate;
	JTextField txtType;
	JTextField txtTaille;
	View v;
	Controller c;
	String titre,type,date,taille;
	
	
	Window(String titre,String type,String date,String taille){
		super("Modifier");
		titre=this.titre;
		type=this.type;
		date=this.date;
		taille=this.taille;
		c=new Controller(this);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTitre_1 = new JLabel("Titre :");
		panel.add(lblTitre_1);
		
		txtTitre = new JTextField();
		txtTitre.setText(titre);
		panel.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lblDateDeCration = new JLabel("Date de Cr\u00E9ation :");
		panel.add(lblDateDeCration);
		
		txtDate = new JTextField();
		txtDate.setText(date);
		panel.add(txtDate);
		txtDate.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblType_1 = new JLabel("Type :");
		panel_1.add(lblType_1);
		
		txtType = new JTextField();
		txtType.setText(type);
		panel_1.add(txtType);
		txtType.setColumns(10);
		
		JLabel lblTaille_1 = new JLabel("Taille :");
		panel_1.add(lblTaille_1);
		
		txtTaille = new JTextField();
		txtTaille.setText(taille);
		panel_1.add(txtTaille);
		txtTaille.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		panel_1.add(btnOk);
		this.setLocationRelativeTo(null);
		this.setSize(600,350);
		this.setVisible(true);
		
		

		
	}

}
