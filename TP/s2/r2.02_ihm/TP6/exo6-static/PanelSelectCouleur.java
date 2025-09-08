import java.awt.*;
import java.awt.event.*;

public class PanelSelectCouleur extends Panel implements AdjustmentListener, ActionListener
{
	public static final char ROUGE = 'R';
	public static final char VERT  = 'V';
	public static final char BLEU  = 'B';

	private static 



	private Scrollbar sbDefil1;
	private TextField txtDec;
	private TextField txtHex;
	private FrameAs frame;
	
	Panel panelScrol;
	Panel panelText;

	public PanelSelectCouleur(FrameAs frame)
	{
		this.setLayout ( new GridLayout(2,1) );

		/*-----------------------------*/
		/* Création des composants     */
		/*-----------------------------*/
		this.frame = frame;
		
		// PanelScrol
		panelScrol = new Panel(new BorderLayout());
		
		this.sbDefil1 = new Scrollbar ( Scrollbar.HORIZONTAL,0,10,0,255+10);
		
		this.sbDefil1.setUnitIncrement(16);
		//this.sbDefil1.setBlockIncremen​(32);
		
		
		// PanelText
		panelText = new Panel(new FlowLayout(FlowLayout.CENTER));
		
		this.txtDec = new TextField("000");
		this.txtHex = new TextField("00");
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/


		//PanelScrol
		panelScrol.add(new Label("00"), BorderLayout.WEST  );
		panelScrol.add(this.sbDefil1  , BorderLayout.CENTER);
		panelScrol.add(new Label("FF"), BorderLayout.EAST  );
		
		
		//PanelText
		panelText.add(new Label("dec :"));
		panelText.add(this.txtDec);
		panelText.add(new Label("hex :"));
		panelText.add(this.txtHex);
		
		//PanelSelectCouleur
		this.add(panelScrol);
		this.add(panelText);

		/*-----------------------------*/
		/* Activation des composants   */
		/*-----------------------------*/
		this.sbDefil1.addAdjustmentListener(this);
		this.txtDec.addActionListener(this);
		this.txtHex.addActionListener(this);

		//this.setVisible(true);
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

