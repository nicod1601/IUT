import java.awt.*;
import javax.swing.*;

public class PanelNouveauClient extends JPanel
{
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JCheckBox chkPremium;
    private JTextField txtAnneeAdhesion;
    
    private JButton btnValider;
    private JButton btnAnnuler;

    private JPanel panelCentre;
    private JPanel panelBoutons;

    public PanelNouveauClient()
    {
        this.setLayout(new BorderLayout());

        /*---------------------------------*/
        /*     Création  des composants    */
        /*---------------------------------*/
        
        this.panelCentre = new JPanel(new GridLayout(4, 2, 5, 5));
        
        JLabel lblNom           = new JLabel("nom :"           , JLabel.RIGHT);
        JLabel lblPrenom        = new JLabel("prenom :"        , JLabel.RIGHT);
        JLabel lblPremium       = new JLabel("premium :"       , JLabel.RIGHT);
        JLabel lblAnneeAdhesion = new JLabel("année adhésion :", JLabel.RIGHT);

        txtNom = new JTextField(15);
        txtPrenom = new JTextField(15);
        chkPremium = new JCheckBox();

        txtAnneeAdhesion = new JTextField("2022", 5);
        txtAnneeAdhesion.setEnabled(false);
        txtAnneeAdhesion.setDisabledTextColor(Color.GRAY);

        this.panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.btnAnnuler = new JButton("Annuler");
        this.btnValider = new JButton("Valider");


        /*---------------------------------*/
        /*  Positionnement des composants  */
        /*---------------------------------*/
        
        this.panelCentre.add(lblNom);
        this.panelCentre.add(txtNom);

        this.panelCentre.add(lblPrenom);
        this.panelCentre.add(txtPrenom);
        
        this.panelCentre.add(lblPremium);
        this.panelCentre.add(chkPremium);
        
        this.panelCentre.add(lblAnneeAdhesion);
        this.panelCentre.add(this.txtAnneeAdhesion);
        
        this.add(panelCentre, BorderLayout.CENTER);
        
        
        this.panelBoutons.add(this.btnAnnuler);
        this.panelBoutons.add(this.btnValider);
        
        this.add(panelBoutons, BorderLayout.SOUTH);
    }
}