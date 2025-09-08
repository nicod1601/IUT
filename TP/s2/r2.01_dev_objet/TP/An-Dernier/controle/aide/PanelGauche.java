import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;


public class PanelGauche extends JPanel implements ActionListener
{
	private JLabel lbljoueur1;
	private JLabel lbljoueur2;
	private JLabel lblScoreNico;
	private JLabel lblScoreMarc;
	private int pointN;
	private int pointM;
	private JButton btnNico;
	private JButton btnMarc;

	public PanelGauche()
	{
		this.setLayout(new GridLayout(3,2));

		/*-----------------------*/
		/*Création des composants*/
		/*-----------------------*/
		this.lbljoueur1 = new JLabel("Nicolas");
		this.lbljoueur2 = new JLabel("Marceau");
		this.lblScoreNico = new JLabel("" + this.pointN +"/"+ "59");
		this.lblScoreMarc = new JLabel("" + this.pointM +"/"+ "59");
		this.btnNico = new JButton();
		this.btnMarc = new JButton();

		/*-----------------------*/
		/*Position des composants*/
		/*-----------------------*/
		this.add(this.lbljoueur1);
		this.add(this.lblScoreNico);
		this.add(this.lbljoueur2);
		this.add(this.lblScoreMarc);
		this.add(this.btnNico);
		this.add(this.btnMarc);

		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		this.btnNico.addActionListener(this);
		this.btnMarc.addActionListener(this);
	}

	private void modification(int point)
	{
		if(point == 1)
		{
			this.pointN++;
			this.lblScoreNico.setText(this.pointN + "/" + "59");
		}
		if(point == 2)
		{
			this.pointM++;
			this.lblScoreMarc.setText(this.pointM + "/" + "59");
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnNico)
		{
			this.modification(1);
		}

		if(e.getSource() == this.btnMarc)
		{
			this.modification(2);
		}
	}


}