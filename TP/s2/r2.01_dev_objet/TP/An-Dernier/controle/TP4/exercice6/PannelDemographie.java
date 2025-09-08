import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;


class PannelDemographie extends JPanel
{
	private ControleurDemographie ctrl;

	// Les trois controles présents sur le Pannel
	private JComboBox<String>     cbRegion;
	private JButton               btnBouton;
	private ChartPanel            chartPanel;


	// Objet chart pour ChartPanel
	private JFreeChart            chart;


	public PannelDemographie (ControleurDemographie  ctrl)
	{
		setLayout  (null);      // Suppression de la gestion des layouts,
		                        // pas très conseillée par la littérature, mais bien pratique
		this.ctrl = ctrl;

		/*--------------------------------------------------*/
		/* Positionnement de la liste déroulante des Region */
		/*--------------------------------------------------*/
		cbRegion = new JComboBox<String> ();

		String[] listeRegion = ctrl.listerRegion();
		for ( int cpt = 0; cpt < listeRegion.length; cpt++ )
			cbRegion.addItem ( listeRegion[cpt] );

		add ( cbRegion );
		cbRegion.setBounds ( 10,10,150,30);


		/*--------------------------------------------------*/
		/* Positionnement du Bouton de Commande             */
		/*--------------------------------------------------*/
		btnBouton = new JButton ( "Action" );
		add ( btnBouton );
		btnBouton.setBounds ( 10, 200, 150, 30 );
		btnBouton.addActionListener( new BoutonAction ( 1 ) );


		/*--------------------------------------------------*/
		/* Positionnement du ChartPannel                    */
		/*--------------------------------------------------*/
		initDataChart();

		chartPanel = new ChartPanel(chart);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(800, 500));

		add(chartPanel);
		chartPanel.setBounds ( 160,10,800,500);

	}


	public void maj()
	{
		initDataChart();

		chartPanel.setChart(chart);
		chartPanel.repaint();
	}


	// Dans la mesure où ce traintement est fait à deux endroits disctincts (Constructeur et maj)
	// il est préférable de déporter ce code dans une méthode privé
	private void initDataChart()
	{
		DefaultCategoryDataset ensData = new DefaultCategoryDataset();

		for (int cpt=0; cpt < ctrl.getNbDeptRegionActive(); cpt++ )
			ensData.addValue ( ctrl.getPopulationDeptRegionActive(cpt),
									 ctrl.getNomDeptRegionActive(cpt),
									 ""
									);
		String titre = "Données Démographiques : " + ctrl.getNomRegionActive();

		chart = ChartFactory.createBarChart(
					 titre,                     // titre du chart
					 "Département",             // label sur l'axe des x
					 null,                      // label sur l'axe des y
					 ensData,                   // les données
					 PlotOrientation.VERTICAL,  // orientation
					 true,                      // affichage de la légende
					 false,                     // tooltips
					 false                      // URL
		);
	}

	// Class Interne pour la gestion des Boutons de Commande
	private class BoutonAction implements ActionListener
	{
		private int act;       // identifiant du bouton cliquer au cas
		                       // où l'interface comporterait plusieurs boutons

		public BoutonAction(int act)
		{
			this.act = act;
		}

		public void actionPerformed(ActionEvent event)
		{
			if ( this.act == 1 )
			{
				ctrl.bouton ( cbRegion.getSelectedIndex() );
				PannelDemographie.this.requestFocusInWindow();
			}
		}
	}
}
