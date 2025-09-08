package appli.ihm;

import javax.swing.*;

public class FrameConnexion extends JFrame
{
    private PanelConnexion panelConnexion;

    private FrameID frameID;

    public FrameConnexion(FrameID frameID)
    {
        this.setTitle("Page Connexion");
        this.setSize(450, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.frameID = frameID;

        /*--------------------------*/
        /* Création des composants  */
        /*--------------------------*/
        this.panelConnexion = new PanelConnexion(this);


        /*---------------------------*/
        /*   Position des composants */
        /*---------------------------*/
        this.add(this.panelConnexion);


        this.setVisible(false);
    }

    public boolean  connecter(String nom, String prenom)
    {
        return this.frameID.connecter(nom, prenom);
    }

    public void creerCompte()
    {
        this.frameID.setVisible(true);
        this.setVisible(false);
    }

    public void frameAppli()
    {
        this.frameID.frameAppli();
    }

    public void setProfile(String nom, String prenom)
    {
        this.frameID.setProfile(nom, prenom);
    }
  
}
