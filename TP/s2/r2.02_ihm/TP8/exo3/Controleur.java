import java.util.List;

public class Controleur
{
	private FrameTable ihm;
	private Clientele  metier;

	public Controleur ()
	{
		this.metier = new Clientele ();
		this.ihm    = new FrameTable(this);
	}


	// Accesseurs
	public List<Client> getClients() { return this.metier.getClients(); }


	// Modificateurs
	public boolean majPremiumClient ( int ligne, boolean val ) { return this.metier.majPremiumClient ( ligne, val ); }


	// Autres MÃ©thodes
	public void sauvegarder()
	{
		this.metier.sauvegarder();
	}



	public static void main(String[] a){ new Controleur(); }
}