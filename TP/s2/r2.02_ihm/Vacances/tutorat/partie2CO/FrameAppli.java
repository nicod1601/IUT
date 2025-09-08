package partie2CO;

import javax.swing.*;

public class FrameAppli extends JFrame
{

    private FrameConnexion frameCo;

    public FrameAppli(FrameConnexion frameCo)
    {
        this.setTitle("Accueil");
        this.setSize(800,600);

        this.frameCo = frameCo;
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/

        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/


        this.setVisible(false);
    }
}
