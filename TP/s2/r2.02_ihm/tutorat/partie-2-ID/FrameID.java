import javax.swing.*;

public class FrameID extends JFrame
{
    private PanelID panelID;

    public FrameID()
    {
        this.setTitle("Page Identification");
        this.setSize(450, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*--------------------------*/
        /* Création des composants  */
        /*--------------------------*/
        this.panelID = new PanelID();


        /*---------------------------*/
        /*   Position des composants */
        /*---------------------------*/
        this.add(this.panelID);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        FrameID frame = new FrameID();
    }
}