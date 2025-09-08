package partie1CO;

import javax.swing.*;

public class FrameConnexion extends JFrame
{
    private PanelConnexion panelConnexion;


    public FrameConnexion()
    {
        this.setTitle("Page de Connexion");
        this.setSize(500,200);
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/

        this.panelConnexion = new PanelConnexion(this);

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.add(this.panelConnexion);

        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/


        this.setVisible(true);
    }
}
