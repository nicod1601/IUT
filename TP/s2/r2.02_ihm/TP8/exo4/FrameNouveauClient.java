import java.awt.Dimension;
import java.awt.Point;
import javax.swing.*;

public class FrameNouveauClient extends JFrame 
{
    private PanelNouveauClient panelNouveauClient;
    private Controleur ctrl;

    private FrameTable frame;

    public FrameNouveauClient(Controleur ctrl, FrameTable frame) 
    {
        this.frame = frame;
        this.setTitle("Nouveau client");
        this.setSize(500, 200);
        Point point = this.frame.getLocation();
        Dimension dimension = this.frame.getSize();
        this.setLocation(point.x, point.y + this.frame.getHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.panelNouveauClient = new PanelNouveauClient(this);
        this.ctrl = ctrl;


        this.add(this.panelNouveauClient);


        this.setVisible(false);
    }

    public void setClient(String nom, String prenom, boolean premium, int anneeAdhesion) 
    {
       this.ctrl.setClient(nom, prenom, premium, anneeAdhesion);
    }
}