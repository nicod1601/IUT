
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAjouter extends JPanel 
{
    private JButton btnAjouter;

    public PanelAjouter() 
    {
        /*-------------------------- */
        /*Création des composants    */
        /*-------------------------- */
        this.btnAjouter = new JButton("Ajouter");

        /*-------------------------- */
        /*Positon des composants     */
        /*-------------------------- */
        this.add(this.btnAjouter);
    }
}
