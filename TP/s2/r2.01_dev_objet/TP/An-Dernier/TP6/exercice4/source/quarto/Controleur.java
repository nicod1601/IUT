package quarto;
import quarto.ihm.FramePlateau;
import quarto.metier.Plateau;
import java.util.*;

/** Classe Passerelle entre Métier et IHM.
  * @author Philippe Le Pivert.
  */
public class Controleur
{
	private static String repQuarto ="";


	private   Plateau                   metier;         // Classe Metier
	private   FramePlateau              framePlateau;   // Classes Vue
	private   HashMap<String,String>    hmImage;       	// Correspondance pour fichier Image

	public Controleur(String[] nomJoueur)
	{
		metier            = new Plateau(nomJoueur);
		framePlateau      = new FramePlateau ( this );
		hmImage           = new HashMap<String,String>();

		this.initHashMap();

		framePlateau.setSize     ( 800, 800   );
		framePlateau.setLocation ( 1,  1      );
		framePlateau.setTitle    ( "Quarto"   );
		framePlateau.setVisible  ( true       );

	}

	public String getImage (String zone, int lig, int col)
	{
		String sImage = Controleur.repQuarto + "image"+"/";

		if ( zone.equals ( "plateau" ) ) sImage += hmImage.get ( metier.getPiecePlateau ( lig, col ) );
		if ( zone.equals ( "pioche"  ) ) sImage += hmImage.get ( metier.getPioche       ( lig      ) );
		if ( zone.equals ( "enCours" ) ) sImage += hmImage.get ( metier.getPieceAJouer  (          ) );

		sImage += ".gif";

		return sImage;
	}

	public int getNbLigne()
	{
		return metier.getNbLigne();
	}

	public int getNbColonne()
	{
		return metier.getNbColonne();
	}

	public int getTaillePioche()
	{
		return metier.getTaillePioche();
	}

	public String getMessage()
	{
		return  metier.getNomJoueurEnCours() + " : " + metier.getMessage();
	}

	public void  bouton (int btn )
	{
		if ( btn >= 0  && btn <= 15 ) metier.piocher ( btn );
		if ( btn == 20              ) metier.quarto  ();

		framePlateau.majIHM();
	}

	public void cliquer (int lig, int col)
	{
		metier.placer ( lig, col);
		framePlateau.majIHM();
	}

	private void initHashMap()
	{
		hmImage.put ( "BlCrGdCa","bleu_creux_grand_carre" );
		hmImage.put ( "BlCrGdRd","bleu_creux_grand_rond"  );
		hmImage.put ( "BlCrPtCa","bleu_creux_petit_carre" );
		hmImage.put ( "BlCrPtRd","bleu_creux_petit_rond"  );
		hmImage.put ( "BlPlGdCa","bleu_plein_grand_carre" );
		hmImage.put ( "BlPlGdRd","bleu_plein_grand_rond"  );
		hmImage.put ( "BlPlPtCa","bleu_plein_petit_carre" );
		hmImage.put ( "BlPlPtRd","bleu_plein_petit_rond"  );
		hmImage.put ( "RgCrGdCa","rouge_creux_grand_carre");
		hmImage.put ( "RgCrGdRd","rouge_creux_grand_rond" );
		hmImage.put ( "RgCrPtCa","rouge_creux_petit_carre");
		hmImage.put ( "RgCrPtRd","rouge_creux_petit_rond" );
		hmImage.put ( "RgPlGdCa","rouge_plein_grand_carre");
		hmImage.put ( "RgPlGdRd","rouge_plein_grand_rond" );
		hmImage.put ( "RgPlPtCa","rouge_plein_petit_carre");
		hmImage.put ( "RgPlPtRd","rouge_plein_petit_rond" );
		hmImage.put ( null,      "vide"                   );

	}
	

	public static void main(String[] arg)
	{
		/*if(arg.length != 1)
		{
			System.out.println("Commande invalide");
		}
		else
		{
			Controleur.repQuarto = arg[0];
			new Controleur( new String[]{"Gaston", "Spirou"});
		}*/

		Controleur.repQuarto = System.getenv("REP_QUARTO");
		new Controleur( new String[]{"Gaston", "Spirou"});
	}

}
