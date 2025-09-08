import java.awt.*;
import java.awt.event.*;                                         

public class Exo1V2 extends Frame implements ActionListener 
{
	private static int nbList = 0;
	private int numList;
	private Button btn1;
	private Button btn2;
	private Label lblAppliquer;
	private Label lblAnnuler;
	private List lstChoix;

	Panel panel;
	int cptAppliquer = 0;
	int cptAnnuler = 0;  

	public Exo1V2()
	{
		this.setTitle("2 Boutons");
		this.setLocation(50,50);
		this.setLayout(new GridLayout(4,1));

		/* ------------------------------ */
		/* Création des composants        */
		/* ------------------------------ */
		this.btn1 = new Button( " Appliquer" );
		this.btn2 = new Button( " Annuler" );

		panel = new Panel();
		this.lblAppliquer = new Label("Appliquer : 0");
		this.lblAnnuler = new Label("Annuler : 0");

		this.lstChoix = new List();

		this.lstChoix.add("premier"  );
		this.lstChoix.add("second"   );
		this.lstChoix.add("troisième");
		this.lstChoix.add("quatrième");
		this.lstChoix.add("cinquième");
		this.lstChoix.add("sixième"  );
		this.lstChoix.add("septième" );
		this.lstChoix.add("huitième" );
		this.lstChoix.add("neuvième" );


		/* ------------------------------ */
		/* Positionnement des composants  */
		/* ------------------------------ */

		panel.add(this.lblAppliquer);
		panel.add(this.lblAnnuler);


		this.add(this.btn1);
		this.add(this.btn2);
		this.add(panel);
		this.add(this.lstChoix);


		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		this.btn1.addActionListener( this );
		this.btn2.addActionListener( this );
		this.lstChoix.addActionListener(this);


		this.pack();                          
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e)
	{
		      

		if (e.getSource() == this.btn1)
		{
			this.lblAppliquer.setText("Appliquer : " + ++cptAppliquer);
			//System.out.println(cptAppliquer);
		}
		if (e.getSource() == this.btn2)
		{
			this.lblAnnuler.setText("Annuler : " + ++cptAnnuler);
		}

		if(e.getSource() == this.lstChoix)
		{
			System.out.println(this.lstChoix.getSelectedItem() + " ("+ this.numList + "/" + Exo1V2.nbList + ") ");
		}
		
	}

	public static void main(String [] args) { new Exo1V2(); }
}