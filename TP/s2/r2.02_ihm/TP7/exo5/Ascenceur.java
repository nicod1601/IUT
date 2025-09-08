import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Ascenceur extends JFrame implements AdjustmentListener, ActionListener
{
	JPanel panel;

	private JScrollBar sbDefil1;
	
	private JLabel lblDroite;
	private JLabel lblGauche;
	
	private JTextField txtDec;
	private JTextField txtHex;

	public Ascenceur()
	{
		this.setTitle   ("Scrollbar");
		this.setSize    (400,100);
		this.setLocation(50,50);

		this.setLayout ( new BorderLayout() );

		/*-----------------------------*/
		/* Création des composants     */
		/*-----------------------------*/
		this.lblDroite = new JLabel("FF");
		this.lblGauche = new JLabel("00");
		
		this.sbDefil1 = new JScrollBar ( Scrollbar.HORIZONTAL,0,10,0,255+10);
		
		this.sbDefil1.setUnitIncrement(16);
		//this.sbDefil1.setBlockIncrement​(32);
		
		panel = new JPanel();
		
		this.txtDec = new JTextField("000");
		this.txtHex = new JTextField("00");
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		panel.add(new Label("dec :"));
		panel.add(this.txtDec);
		panel.add(new Label("hex :"));
		panel.add(this.txtHex);
		
		
		this.add( this.sbDefil1 , BorderLayout.CENTER);
		this.add( this.lblGauche, BorderLayout.WEST);
		this.add( this.lblDroite, BorderLayout.EAST);
		this.add( panel, BorderLayout.SOUTH);


		/*-----------------------------*/
		/* Activation des composants   */
		/*-----------------------------*/
		this.sbDefil1.addAdjustmentListener(this);
		this.txtDec.addActionListener(this);
		this.txtHex.addActionListener(this);

		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int hex2;
	
		int dec;
		String hex = "";
	
		if(e.getSource() == this.txtDec)
		{
			dec = Integer.parseInt(this.txtDec.getText());
			hex = Integer.toHexString(dec);
			this.txtHex.setText(hex);
			
		}
		
		if(e.getSource() == this.txtHex)
		{
			hex2 = Integer.parseInt(this.txtHex.getText(), 16);
			this.txtDec.setText(" " + hex2);
		}
	}


	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		String    sMess = "";
		String    base10= "";
		String    hexe  = "";
		JScrollBar tmp   = null;

		if ( e.getSource() == this.sbDefil1 )
		{
			sMess += "barre n°1 : ";
			tmp = this.sbDefil1;

			/*sMess += String.format ( "%5d", tmp.getValue() );*/

			base10 = Integer.toString ( tmp.getValue() );
			hexe = Integer.toHexString(tmp.getValue());
			sMess += " " + base10 + " " + hexe;

			//this.txtDec.setText(base10);   C'est possible mais je préfère le setTextField qui est ma méthode
			//.txtHex.setText(hexe);

			this.setTextField(base10, hexe);
		}

		
		
		System.out.println ( sMess );
	}

	public void setTextField(String base10, String hexe)
	{
		this.txtDec.setText(base10);
		this.txtHex.setText(hexe);
	}

	public static void main(String [] args)
	{
		new Ascenceur();
	}
}

