import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelNouveauClient extends JPanel implements ActionListener
{
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JCheckBox chkPremium;
    private JTextField txtAnneeAdhesion;
    
    private JButton btnValider;
    private JButton btnAnnuler;

    private JPanel panelCentre;
    private JPanel panelBoutons;
    private FrameNouveauClient frame;

    public PanelNouveauClient(FrameNouveauClient frame)
    {
        this.setLayout(new BorderLayout());
        this.frame = frame;
        /*---------------------------------*/
        /*     Création  des composants    */
        /*---------------------------------*/
        
        this.panelCentre = new JPanel(new GridLayout(4, 2, 5, 5));
        
        JLabel lblNom           = new JLabel("nom :"           , JLabel.RIGHT);
        JLabel lblPrenom        = new JLabel("prenom :"        , JLabel.RIGHT);
        JLabel lblPremium       = new JLabel("premium :"       , JLabel.RIGHT);
        JLabel lblAnneeAdhesion = new JLabel("année adhésion :", JLabel.RIGHT);

        lblPremium.setForeground(Color.LIGHT_GRAY);
        lblAnneeAdhesion.setForeground(Color.LIGHT_GRAY);

        txtNom = new JTextField(15);
        txtPrenom = new JTextField(15);
        chkPremium = new JCheckBox();
        this.chkPremium.setEnabled(false);

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


        /*--------------------------------- */
        //lblNom.setBounds(5,5,120,20); // expemple pour placer les composants à la dure

        /*---------------------------------*/
        /*     Activation  des composants  */
        /*---------------------------------*/
        this.btnAnnuler.addActionListener(this);
        this.btnValider.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.btnAnnuler)
        {
            this.frame.setVisible(false);
        }

        if(this.txtNom.getText().equals("") && this.txtPrenom.getText().equals(""))
        {
            if(e.getSource() == this.btnValider)
            {
                this.frame.setClient(this.txtNom.getText(), this.txtPrenom.getText(), this.chkPremium.isSelected(), Integer.parseInt(this.txtAnneeAdhesion.getText()));
                System.out.println(this.txtNom.getText() + " " + this.txtPrenom.getText() + " " + this.chkPremium.isSelected() + " " + this.txtAnneeAdhesion.getText());
            }
        }
    }


}