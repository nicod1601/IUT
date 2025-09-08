import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class FrameEntete extends JFrame implements ActionListener
{
	private PanelEntete[] tabEntetes;
	private JButton btnEntete;
	private JButton btnValider;

	private PanelTable panelTable;

	public FrameEntete(PanelTable panelTable)
	{
		this.setTitle("Application");
		this.setSize(200, 600);
		this.setLayout(new GridLayout(11,1,3,3));
		this.panelTable = panelTable;
		
		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.btnEntete = new JButton("+");
		this.tabEntetes = new PanelEntete[10];
		this.btnValider = new JButton("Valider");

		
		
		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.btnValider);
		this.add(this.btnEntete);

		for(int cpt = 0; cpt < this.tabEntetes.length; cpt++)
		{
			if(this.tabEntetes[cpt] != null)
			{
				this.add(this.tabEntetes[cpt]);
			}
		}
		
		

		
		
		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnEntete.addActionListener(this);
		this.btnValider.addActionListener(this);
		
		
		
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnEntete)
		{
			System.out.println("btnEntete");

			for(int cpt = 0; cpt < this.tabEntetes.length; cpt ++)
			{
				if(this.tabEntetes[cpt] == null)
				{
					this.tabEntetes[cpt] = new PanelEntete();
					System.out.println("creer");
					this.updateUI();
					return;
				}
			}
		}

		if(e.getSource()==this.btnValider)
		{					this.updateUI();
			this.updateUI();
			this.panelTable.setEntete(this.tabEntetes);
		}
	}


	private void updateUI()
    {
        this.getContentPane().removeAll(); // Supprime tous les composants
		this.add(this.btnValider);
        this.add(this.btnEntete);

        // Réajoute les éléments du tableau
        for (PanelEntete panel : this.tabEntetes)
        {
            if (panel != null)
            {
                this.add(panel);
            }
        }

        this.revalidate();
        this.repaint();
    }
}