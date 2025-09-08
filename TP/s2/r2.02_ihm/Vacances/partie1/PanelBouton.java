import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelBouton extends JPanel implements ActionListener
{
	private JButton[] tabBouton;
	private int[]     tabCode;
	private JButton    btnValide;
	private JButton    btnNonValide;


	private ImageIcon   valide;
	private Image     imgValide;
	private ImageIcon   nonValide;
	private Image     imgNonValide;




	private FrameCode frame;

	public PanelBouton(FrameCode frame)
	{
		this.setLayout(new GridLayout(4,3, 5,5));
		this.setBackground(Color.GRAY);
		this.frame = frame;

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.tabCode = new int[]{7,8,9,4,5,6,1,2,3,0};
		this.tabBouton = new JButton[this.tabCode.length];

		for(int cpt=0; cpt < this.tabCode.length; cpt++)
		{
			this.tabBouton[cpt] = new JButton(""+ this.tabCode[cpt]);
			this.tabBouton[cpt].setBackground(Color.LIGHT_GRAY);
		}

		valide = new ImageIcon("valide.png");

		imgValide = valide.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		valide = new ImageIcon(imgValide);


		this.btnValide = new JButton(valide);
		this.btnValide.setBackground(Color.GREEN);


		nonValide = new ImageIcon("non-valide.png");

		imgNonValide = nonValide.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);		
		nonValide = new ImageIcon(imgNonValide);


		this.btnNonValide = new JButton(nonValide);
		this.btnNonValide.setBackground(Color.RED);

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		for(int cpt=0; cpt < this.tabBouton.length; cpt++)
		{
			this.add(this.tabBouton[cpt]);
		}
		this.add(this.btnNonValide);
		this.add(this.btnValide);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		for(int cpt=0; cpt < this.tabBouton.length; cpt++)
		{
			this.tabBouton[cpt].addActionListener(this);
		}

		this.btnValide.addActionListener(this);
		this.btnNonValide.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int cpt=0; cpt < this.tabBouton.length; cpt++)
		{
			if(e.getSource() == this.tabBouton[cpt])
			{
				this.frame.setNum(this.tabCode[cpt]);

				System.out.println("" + this.tabCode[cpt]);
			}
		}

		if(e.getSource() == this.btnValide)
		{
			this.frame.valide(true);
			System.out.println("true");
		}

		if(e.getSource() == this.btnNonValide)
		{
			this.frame.valide(false);
			System.out.println("false");
		}

	}
}