import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PanelSelectCouleur extends JPanel implements AdjustmentListener, ActionListener
{
	JPanel panelScrol;
	JPanel panelText;
	
	private JLabel lblDec;
	private JLabel lblHex;
	private JLabel lblDebut;
	private JLabel lblFin;


	private JScrollBar sbDefil1;
	private JTextField txtDec;
	private JTextField txtHex;
	private FrameAs    frame;
	
	
	public PanelSelectCouleur(FrameAs frame)
	{
		this.setLayout ( new GridLayout(2,1) );

		/*-----------------------------*/
		/* Création des composants     */
		/*-----------------------------*/
		this.frame = frame;
		
		// PanelScrol
		panelScrol    = new JPanel(new BorderLayout());
		this.sbDefil1 = new JScrollBar( Scrollbar.HORIZONTAL,0,10,0,255+10);
		this.lblDebut = new JLabel("00");
		this.lblFin   = new JLabel("FF");

		this.sbDefil1.setUnitIncrement(16);
		//this.sbDefil1.setBlockIncremen​(32);

		this.panelScrol.setOpaque(false);
		this.lblDebut  .setOpaque(true);
		this.lblFin    .setOpaque(true);

		
		// PanelText
		panelText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		this.lblDec = new JLabel("dec  :");
		this.lblHex = new JLabel("hex  :");

		this.txtDec = new JTextField("000");
		this.txtHex = new JTextField("00" );
		
		
		this.lblDec   .setOpaque(false);
		this.lblHex   .setOpaque(false);
		this.panelText.setOpaque(false);
		
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/


		//PanelScrol
		panelScrol.add(this.lblDebut  , BorderLayout.WEST  );
		panelScrol.add(this.sbDefil1  , BorderLayout.CENTER);
		panelScrol.add(this.lblFin    , BorderLayout.EAST  );
		
		
		//PanelText
		panelText.add(this.lblDec);
		panelText.add(this.txtDec);
		panelText.add(this.lblHex);
		panelText.add(this.txtHex);
		
		//PanelSelectCouleur
		this.add(panelScrol);
		this.add(panelText);

		/*-----------------------------*/
		/* Activation des composants   */
		/*-----------------------------*/
		this.sbDefil1.addAdjustmentListener(this);
		this.txtDec  .addActionListener    (this);
		this.txtHex  .addActionListener    (this);

	}
	
	public void actionPerformed(ActionEvent e)
	{
		int valeur = 0;
		
		try
		{
			if(e.getSource() == this.txtDec)
			{
				valeur = Integer.parseInt(this.txtDec.getText());
			}
			
			if(e.getSource() == this.txtHex)
			{
				valeur = Integer.parseInt(this.txtHex.getText(), 16);
				
			}
		}
		catch(Exception ex)
		{
			valeur = 0;
		}
		
		this.majTout(valeur);
		this.frame.couleur();
	}


	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if ( e.getSource() == this.sbDefil1 )
		{
			this.majTout(this.sbDefil1.getValue());
			this.frame.couleur();
		}
	}

	private void majTout(int val)
	{
		this.sbDefil1.setValue(val);
		val = this.sbDefil1.getValue(); // correction pour remettre à la valeur par rapport à la scrollbar
		
		this.txtDec.setText(String.format("%02d",val));
		this.txtHex.setText(String.format("%02X",val));
	}
	
	public int getVal()
	{
		return this.sbDefil1.getValue();
	}
}

