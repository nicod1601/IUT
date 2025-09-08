import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDroite extends JPanel implements ActionListener
{
	private JButton btn;
	private Tirage frame;

	public PanelDroite(Tirage frame)
	{
		this.setLayout(new GridLayout(2,1));
		this.frame = frame;
		/*-----------------------*/
		/*Création des composants*/
		/*-----------------------*/
		this.btn = new JButton("R");
		this.btn.setBackground(Color.ORANGE);

		/*-----------------------*/
		/*Position des composants*/
		/*-----------------------*/
		this.add(this.btn);

		/*-------------------------*/
		/*Activation des composants*/
		/*-------------------------*/
		this.btn.addActionListener(this);

	}
	/*action des boutons pour les interractions */
	public void actionPerformed(ActionEvent e)
	{
		Color v = Color.GREEN;
		boolean t = true;

		if(e.getSource() == this.btn)
		{
			System.out.println("Redémarage");
			this.frame.setEnabled(t);
			this.frame.Background(v);
			this.frame.setText("");
		}
	}
}
