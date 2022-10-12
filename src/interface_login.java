import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class interface_login implements MouseListener,ActionListener{
	JButton connexion;
	JTextField mail,password;
	JLabel message,erreur;
	JFrame cadre;
public interface_login(){
	//initialisation des cadre
	cadre	=	new	JFrame();
	cadre.setTitle ("GestionJuju");
	cadre.setSize (400,400)	;
	JPanel fen =new JPanel();
	fen.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	// message d'arriver
	message= new JLabel("Bienvenue dans l'application GestionJuju");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 3;
	c.ipady = 40;  
	c.gridx = 0;
	c.gridy = 0;
	fen.add(message,c);
	
	//message en cas d'erreur
	erreur= new JLabel ("");
	erreur.setForeground(Color.red);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.ipady = 40;  
	c.gridx = 0;
	c.gridy = 1;
	fen.add (erreur,c);
	
	//entrer des mail
	mail=new JTextField("Entrer un Email");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 0;
	c.ipady = 40;  
	c.gridx = 0;
	c.gridy = 2;
	fen.add(mail,c);
	mail.addMouseListener(new mouse());
	
	//entrer du mots de passe
	password=new JTextField("Entrer un mots de passes");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.insets = new Insets(10,0,0,0);
	c.gridwidth = 0;
	c.ipady = 40;  
	c.gridx = 0;
	c.gridy = 3;
	fen.add(password,c);
	password.addMouseListener(new mouse());
	
	//boutton de connexion
	connexion=new JButton("connexion");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.insets = new Insets(10,0,0,0);
	c.gridwidth = 0;
	c.ipady = 40;  
	c.gridx = 0;
	c.gridy = 4;
	fen.add(connexion,c);
	connexion.addActionListener(this);
	
	// ajoute a frame
	cadre.getContentPane().add(fen);
	cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cadre.setVisible(true);           

}
//mousselistener et action listener
	class mouse implements MouseListener{
    public void mouseReleased(MouseEvent e) {}         
    public void mousePressed(MouseEvent e) {}          
    public void mouseExited(MouseEvent e) {}           
    public void mouseEntered(MouseEvent e) {}          
    public void mouseClicked(MouseEvent e) {
        JTextField texteField = ((JTextField)e.getSource());
        texteField.setText("");
        texteField.removeMouseListener( this);
    }
}
	public void mouseClicked(MouseEvent arg0) {	
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileReader reader=new FileReader("login.txt");
			BufferedReader reader1=new BufferedReader(reader);
			Scanner in=new Scanner(reader1);
			while(in.hasNextLine()) {
				String[] id=in.nextLine().split(":");
				if(id[0].equals(mail.getText())) {
					if(id[1].equals(password.getText())) {
						if(id[2].equals("Chauffeur")) {
							interface_chauffeur n=new interface_chauffeur(mail.getText());
							cadre.dispose();
						}
						else {
							if(id[2].equals("dispatcheur")) {
								interface_dispatcheur n=new interface_dispatcheur(mail.getText());
								cadre.dispose();
							}
							else {
								interface_admins n=new interface_admins(mail.getText());
								cadre.dispose();
							}
						}
					}
					else {
						erreur.setText("Erreur dans le mots de passe veuillez ressayer");
						
					}
				}
				
			}
			erreur.setText("Erreur aucun mail correspondant");
		} catch (FileNotFoundException e) {
		
		}
		
	}
}
