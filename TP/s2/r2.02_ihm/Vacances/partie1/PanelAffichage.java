import java.awt.*;
import javax.swing.*;

public class PanelAffichage extends JPanel
{
	private JLabel lblCode;
	private JLabel lblValide;

	public PanelAffichage()
	{
		this.setSize(500, 500);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.lblCode = new JLabel("");
		this.lblValide = new JLabel("");

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.lblValide);
		this.add(this.lblCode);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
	}
	public void setNum(int num)
	{
		String txt = this.lblCode.getText();
		this.lblCode.setText(txt + num);
	}

	public String getNum()
	{
		return this.lblCode.getText();
	}

	public void valide(boolean b)
	{
		if(b == true)
		{
			if(this.getNum().equals("8542"))
			{
				this.lblValide.setText("Code Valide");
				this.lblValide.setForeground(Color.GREEN);
			}
			else
			{
				this.lblValide.setText("Code Invalide");
				this.lblValide.setForeground(Color.RED);
			}
		}
		else
		{
			this.lblValide.setText("");
			this.lblCode.setText("");
		}
	}
}