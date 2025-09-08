
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelSaisie extends JPanel implements ItemListener
{
    private JTextField txtSaisie;
    private JTextField txtEditeur;


    private JPanel panelType;
    private JRadioButton rbCoperatife;
    private JRadioButton rbCompetitife;
    private ButtonGroup groupeType;


    private JPanel panelCategorie;
    private JCheckBox rbFamillial;
    private JCheckBox rbInite;
    private JCheckBox rbExpert;



    public PanelSaisie()
    {
        this.setLayout(new GridLayout(4,2,4,4));
        this.setBackground(Color.YELLOW);

        /*-------------------------- */
        /*Création des composants    */
        /*-------------------------- */
        JLabel lblSaisie    = new JLabel("Saisie :"   , JLabel.RIGHT);
        JLabel lblEditeir   = new JLabel("Editeur :"  , JLabel.RIGHT);
        JLabel lblType      = new JLabel("Type :"     , JLabel.RIGHT);
        JLabel lblCategorie = new JLabel("Categorie :", JLabel.RIGHT);

        this.txtSaisie  = new JTextField(22);
        this.txtEditeur = new JTextField(22);

        this.panelType     = new JPanel();
        this.panelType.setOpaque(false);
        this.groupeType    = new ButtonGroup();
        this.rbCoperatife  = new JRadioButton("Categorie");
        this.rbCoperatife.setOpaque(false);
        this.rbCompetitife = new JRadioButton("Auteur");
        this.rbCompetitife.setOpaque(false);

        this.panelCategorie = new JPanel();
        this.panelCategorie.setOpaque(false);
        this.rbFamillial    = new JCheckBox("Famillial");
        this.rbFamillial.setOpaque(false);
        this.rbInite        = new JCheckBox("Inite");
        this.rbInite.setOpaque(false);
        this.rbExpert       = new JCheckBox("Expert");
        this.rbExpert.setOpaque(false);

        /*-------------------------- */
        /*Positon des composants     */
        /*-------------------------- */

        /*Panel Type */
        this.groupeType.add(this.rbCoperatife);
        this.groupeType.add(this.rbCompetitife);

        this.panelType.add(this.rbCoperatife);
        this.panelType.add(this.rbCompetitife);

        /*Panel Categorie */
        this.panelCategorie.add(this.rbFamillial);
        this.panelCategorie.add(this.rbInite);
        this.panelCategorie.add(this.rbExpert);


        this.add(lblSaisie);
        this.add(txtSaisie);

        this.add(lblEditeir);
        this.add(txtEditeur);

        this.add(lblType);
        this.add(panelType);

        this.add(lblCategorie);
        this.add(panelCategorie);

        /*-------------------------- */
        /*Activation des composants  */
        /*-------------------------- */
        this.rbCoperatife.addItemListener(this);
        this.rbCompetitife.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == this.rbCoperatife)
        {
            System.out.println("vous venez de séléctionner le type         coopératif");
        }
        
        
        if (e.getSource() == this.rbCompetitife)
        {
            System.out.println("vous venez de séléctionner le type         compétitif");
        }
    }

}
