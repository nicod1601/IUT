package ihm;

import javax.swing.*;

public class FrameConnexion extends JFrame
{
    private PanelConnexion panelConnexion;

    private FrameAppli frameAppli;

    public FrameConnexion()
    {
        this.setTitle("Page de Connexion");
        this.setSize(500,200);
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/
        this.frameAppli = new FrameAppli(this);

        this.panelConnexion = new PanelConnexion(this.frameAppli, this);

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.add(this.panelConnexion);

        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/


        this.setVisible(true);
    }

    public void setId(String nom, String prenom, String sexe)
    {
        this.frameAppli.setId(nom, prenom, sexe);
    }
}
