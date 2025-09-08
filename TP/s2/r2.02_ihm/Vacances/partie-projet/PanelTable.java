import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelTable extends JPanel implements ActionListener
{
	private JTable table;
	private String[] tabEntete;
	private Object[][] tabDonnees;

	private JScrollPane scroll;

	private JPanel panelBtn;
	private JButton[] tabBtn;

	private FrameEntete frameEntete;
	private FrameDonnee frameDonnee;

	public PanelTable()
	{
		this.setLayout(new BorderLayout());

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.tabEntete = new String[0]; // Initialisation vide
		this.tabDonnees = new Object[0][0];
		this.table = new JTable(this.tabDonnees, this.tabEntete);
		this.scroll = new JScrollPane(this.table); // Ajout d'un scroll

		this.panelBtn = new JPanel();
		this.tabBtn = new JButton[2];
		this.tabBtn[0] = new JButton("Entête");
		this.tabBtn[1] = new JButton("Données");

		this.frameEntete = new FrameEntete(this);
		this.frameDonnee = new FrameDonnee(this);

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelBtn.add(this.tabBtn[0]);
		this.panelBtn.add(this.tabBtn[1]);

		this.add(this.panelBtn, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER); // Ajout du scroll au centre

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.tabBtn[0].addActionListener(this);
		this.tabBtn[1].addActionListener(this);

		this.setVisible(false);
	}

	public boolean getSetTable()
	{
		return this.isVisible();
	}

	public void setEntete(PanelEntete[] panel)
	{
		int count = 0;

		// Compter le nombre d'entêtes non null
		for (PanelEntete p : panel)
		{
			if (p != null) count++;
		}

		// Créer un tableau uniquement de la taille des éléments non null
		this.tabEntete = new String[count];

		int index = 0;
		for(int cpt = 0; cpt < panel.length; cpt++)
		{
			if (panel[cpt] != null) // Vérifier que l'objet existe
			{
				this.tabEntete[index] = panel[cpt].getEntete();
				index++;
			}
		}

		updateTable(); // Mettre à jour l'affichage
	}

	public String[] getTabEntete()
	{
		return this.tabEntete;
	}

	private void updateTable()
	{
		// Crée une nouvelle JTable avec les nouvelles données et entêtes
		this.table.setModel(new javax.swing.table.DefaultTableModel(this.tabDonnees, this.tabEntete));

		// Met à jour l'affichage
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== this.tabBtn[0])
		{
			System.out.println("Entête");
			this.frameEntete.setVisible(true);
		}

		if(e.getSource()== this.tabBtn[1])
		{
			System.out.println("Données");
			this.frameDonnee.setVisible(true);
			this.frameDonnee.update();
		}
	}
}
