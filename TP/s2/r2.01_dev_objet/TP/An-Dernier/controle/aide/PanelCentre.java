import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Color;

public class PanelCentre extends JPanel implements ActionListener
{
	private JButton[] tabBoutons;
	private String[] tabperso = {"Omen"   ,"Vatu"   ,"Ying"    ,"Seris" ,"Zhin"     ,"Yagorath" ,"Victor"        ,"Skye"    ,
								 "Kasumi" ,"Raum"   ,"Maeve"   ,"Lian"  ,"Furia"    ,"Mal'Damba","Vora"          ,"Androxus",
								 "Rei"    ,"Grover" ,"Io"      ,"Vivian","Jenos"    ,"Willo"    ,"Barik"         ,"Imani"   ,
								 "Cassie" ,"Strix"  ,"Drogoz"  ,"Corvus","Azaan"    ,"Atlas"    ,"Octavia"       ,"Evie"    ,
								 "Lillith","Talus"  ,"Makoa"   ,"VII"   ,"Khan"     ,"Koga"     ,"Betty la Bomba","Lex"     ,
								 "Kinessa","Saati"  ,"Terminus","Dredge","Bomb King","Moji"     ,"Fernando"      ,"Ruckus"  ,
								 "Tyra"   ,"Pip"    ,"Inara"   ,"Grohk" ,"Ash"      ,"Tiberius" ,"Buck"          ,"Nyx"     ,
								 "Sha Lin","Caspian","Torvald" };
	private Tirage frame;

	public PanelCentre(Tirage frame)
	{
		this.frame = frame;

		this.setLayout(new GridLayout(3,2,5,5));
		this.setBackground(Color.yellow);

		/*-----------------------*/
		/*Création des composants*/
		/*-----------------------*/
		tabBoutons = new JButton[this.tabperso.length];

		for(int cpt = 0; cpt < this.tabBoutons.length; cpt++)
		{
			this.tabBoutons[cpt] = new JButton(""+(cpt+1));
			this.tabBoutons[cpt].setBackground(Color.GREEN);
			this.tabBoutons[cpt].setSize(10,10);
		}

		/*-----------------------*/
		/*Position des composants*/
		/*-----------------------*/
		for(int cpt = 0; cpt < this.tabBoutons.length; cpt++)
		{
			this.add(tabBoutons[cpt]);
		}

		/*-------------------------*/
		/*Activation des composants*/
		/*-------------------------*/
		for(int cpt = 0; cpt < this.tabBoutons.length; cpt++)
		{
			this.tabBoutons[cpt].addActionListener(this);
		}
	}

	/*méthode pour faire les persos aléatoire */
	public static void perso(String[] tabperso)
	{
		for (int cpt1 = tabperso.length - 1; cpt1 > 0; cpt1--)
		{
			int random = (int) (Math.random() * (cpt1 + 1));


			String temp = tabperso[cpt1];
			tabperso[cpt1] = tabperso[random];
			tabperso[random] = temp;
		}
	}

	/*action des boutons pour les interractions */
	public void actionPerformed(ActionEvent e)
	{
		PanelCentre.perso(tabperso);

		for(int cpt = 0; cpt < this.tabperso.length; cpt++)
		{
			if(e.getSource() == this.tabBoutons[cpt])
			{
				this.tabBoutons[cpt].setEnabled(false);
				this.tabBoutons[cpt].setBackground(Color.RED);
				System.out.println(tabperso[cpt]);
				this.frame.setText ( tabperso[cpt] );
			}
		}
	}

	public void Background(Color c)
	{
		for(int cpt = 0; cpt < this.tabBoutons.length; cpt++)
		{
			this.tabBoutons[cpt].setBackground(c);
		}
	}

	public void setEnabled(boolean t)
	{
		for(int cpt = 0; cpt < this.tabBoutons.length; cpt++)
		{
			this.tabBoutons[cpt].setEnabled(t);
		}
	}
}