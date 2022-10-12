	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
public class supprimer implements ActionListener{
		JButton ok;
		JTextField numero;
		JFrame cadre;
		chauffeur chauffeur1;
		//interface supprimer
	public supprimer(String nom,String prenom,String mail,int idchauffeur) {
		chauffeur1=new chauffeur(nom,prenom,mail,idchauffeur);
		cadre	=	new	JFrame();
		cadre.setTitle ("supprimer");
		cadre.setSize (300,200)	;
		JPanel fen =new JPanel(new GridLayout(2,2));
		fen.add ( new JLabel ("numero de trajet:") );
		fen.add ( new JLabel ("") );
		fen.add (numero=new JTextField ("") );
		fen.add(ok=new JButton("ok"));
		ok.addActionListener(this);
		cadre.getContentPane().add(fen);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadre.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		chauffeur1.del(Integer.parseInt(numero.getText()));
		cadre.dispose();
		
	}
	}


