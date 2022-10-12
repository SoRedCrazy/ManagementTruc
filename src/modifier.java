import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class modifier implements ActionListener {
	JButton ok;
	JTextField idtrajet,depart,arriver,datedepart,datearriver,poids,prix,statue;
	JFrame cadre;
	chauffeur chauffeur1;
	//modifier pour les dispatcheur
public modifier(String nom,String prenom,String mail,int idchauffeur) {
	chauffeur1=new chauffeur(nom,prenom,mail,idchauffeur);
	cadre	=	new	JFrame();
	cadre.setTitle ("modifier");
	cadre.setSize (1200,200)	;
	JPanel fen =new JPanel(new GridLayout(2,9));
	
	fen.add ( new JLabel ("id trajet:") );
	fen.add ( new JLabel ("ville de depart:") );
	fen.add ( new JLabel ("ville d'arriver:") );
	fen.add ( new JLabel ("date de depart:") );
	fen.add ( new JLabel ("date d'arriver") );
	fen.add ( new JLabel ("poids:") );
	fen.add ( new JLabel ("prix:") );
	fen.add ( new JLabel ("statue:") );
	fen.add ( new JLabel ("") );
	
	
	fen.add (idtrajet=new JTextField ("") );
	fen.add (depart=new JTextField ("") );
	fen.add (arriver=new JTextField ("") );
	fen.add (datedepart=new JTextField ("") );
	fen.add (datearriver=new JTextField ("") );
	fen.add (poids=new JTextField ("") );
	fen.add (prix=new JTextField ("") );
	fen.add (statue=new JTextField ("") );

	fen.add(ok=new JButton("ok"));
	
	
	ok.addActionListener(this);
	cadre.getContentPane().add(fen);
	cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cadre.setVisible(true);
	
	
}

public void actionPerformed(ActionEvent arg0) {

	chauffeur1.modification(Integer.parseInt(idtrajet.getText()) ,depart.getText(), arriver.getText(), datedepart.getText(), datearriver.getText(), Double.parseDouble(poids.getText()), Integer.parseInt(prix.getText()), Integer.parseInt(statue.getText()));
		cadre.dispose();
}
}
