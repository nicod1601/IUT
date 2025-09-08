package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelMenu extends JPanel implements ActionListener
{
	private JButton btnQuitter;
	private JButton btnParam;

	//private JFrame frameParam;

	public PanelMenu()
	{
		this.setLayout(new FlowLayout() );
		this.setSize(500,500);

		/* Créations des composants */
		this.btnQuitter = new JButton("Quitter");
		this.btnQuitter.setBackground(Color.RED);

		this.btnParam = new JButton("Param");
		this.btnParam.setBackground(Color.BLUE);

		/* Ajout des composants */
		this.add(this.btnParam , FlowLayout.LEFT);
		this.add(this.btnQuitter , FlowLayout.LEFT);
		

		/* Activation des composants */
		this.btnQuitter.addActionListener(this);
		this.btnParam.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnQuitter)
		{
			System.exit(0);
		}
		else if(e.getSource() == this.btnParam)
		{
			// TODO
		}
	}
}