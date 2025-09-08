package ihm;

import javax.swing.*;

public class FrameAppli extends JFrame
{
    private PanelAppli panelAppli;
    private PanelParametre panelParametre;

    private FrameConnexion frameCo;

    public FrameAppli(FrameConnexion frameCo)
    {
        this.setTitle("Accueil");
        this.setSize(800,600);

        this.frameCo = frameCo;
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/
        this.panelParametre = new PanelParametre(this);
        this.panelAppli = new PanelAppli(this, this.frameCo, this.panelParametre);

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.add(this.panelAppli);

        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/


        this.setVisible(false);
    }

    public void setId(String nom, String prenom, String sexe)
    {
        this.panelParametre.setId(nom, prenom, sexe);
    }

    public void setParametre()
    {
        if(this.panelParametre.isVisible() == true)
        {
            this.panelParametre.setVisible(false);
        }
        else
        {
            this.panelParametre.setVisible(true);
        }
    }
}
