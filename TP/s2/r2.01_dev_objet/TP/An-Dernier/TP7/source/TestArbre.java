import arbre.Personne;
import java.util.ArrayList;

public class TestArbre
{
	private static ArrayList<Personne> tabPersonne;


	public static void main ( String[] arg )
	{

		                   //   sex  nom                     mere  pere
		String[][] sData = {  { "M", "Léodagan"            , ""   , ""   },         //  0
		                      { "M", "Uther Pendragon     ", ""   , ""   },         //  1
		                      { "F", "Ygraine"             , ""   , ""   },         //  2
							  { "M", "Gorlois de Tintagel" , ""   , ""   },
							  { "M", "Guenièvre          " , ""   , "0"  },
							  { "M", "Arthur Pendragon   " , "2"  , "1"  },
							  { "F", "Morgane            " , "2"  , "3"  },
							  { "F", "Elaine             " , "2"  , "3"  },
							  { "F", "Anna               " , "2"  , "3"  },
							  { "M", "Roi de Lot         " , ""   ,  ""  },
							  { "F", "Viviane            " , "2"  , "3"  },
							  { "M", "Mordred            " , "6"  , "5"  },
							  { "M", "Gauvin             " , "9"  , "8"  },
							  { "M", "Agravain           " , "9"  , "8"  },
							  { "M", "Gareth             " , "9"  , "8"  },
							  { "M", "Gaheris            " , "9"  , "8"  },
							  { "M", "Hoël               " , "9"  , "8"  } };


		tabPersonne = new ArrayList<Personne>();

		/*----------------------------------------------*/
		/* Création des Personnes                       */
		/*----------------------------------------------*/
		for (int cpt=0;cpt<sData.length;cpt++)
		{
			tabPersonne.add(new Personne(sData[cpt][0].charAt(0),
			                             sData[cpt][1]));
		}


		/*----------------------------------------------*/
		/* 1er Affichage de l'ensemble des Personnes    */
		/*----------------------------------------------*/
		for ( Personne p : tabPersonne )
			System.out.println ( p );


		/*----------------------------------------------*/
		/* Affectation des liens de parenté             */
		/*----------------------------------------------*/
		Personne mere, pere;
		for (int cpt=0;cpt<sData.length;cpt++)
		{
			mere = pere = null;

			if( !sData[cpt][2].equals("") ) mere = tabPersonne.get ( Integer.parseInt(sData[cpt][2]) );
			if( !sData[cpt][2].equals("") ) pere = tabPersonne.get ( Integer.parseInt(sData[cpt][2]) );

			tabPersonne.get(cpt).setParents(mere, pere);

		}


		/*----------------------------------------------*/
		/* 2ème Affichage de l'ensemble des Personnes   */
		/*----------------------------------------------*/
		for ( Personne p : tabPersonne )
			System.out.println ( p );


		/*----------------------------------------------*/
		/* Tests                                        */
		/*----------------------------------------------*/
		System.out.println(test(1, 0, 1, "estFrere", false));
		System.out.println(test(2, 0, 2, "estFrere", true));
		System.out.println(test(3, 1, 3, "estParent", true));
		System.out.println(test(4, 2, 4, "estGrandParent", true));
		System.out.println(test(5, 3, 5, "estPetitEnfant", true));
		System.out.println(test(6, 4, 6, "estOncle", true));
		System.out.println(test(7, 5, 7, "estNeveu", true));
		System.out.println(test(8, 6, 8, "estCousin", true));
		System.out.println(test(9, 7, 9, "estEnfant", true));

	}


	private static String test (int numTest, int source, int dest, String methode, boolean resAttendu )
		{
			String chaine = "";
			boolean bEval = false;
			Personne pOrig, pDest;

			pOrig = tabPersonne.get(source);
			if ( dest ==-1 ) pDest = null; else pDest = tabPersonne.get(dest);

			if ( methode.equals("estFrere") )
			{
				chaine = " est frere        de ";
				bEval  = pOrig.estFrere (pDest );
			}
 
			if ( methode.equals("estDemiFrere") )
			{
				chaine = " est demi-frere   de ";
				bEval  = pOrig.estDemiFrere (pDest );
			}

			if ( methode.equals("estParent")  )
			{
				chaine = " est parent       de ";
				bEval  = pOrig.estParent (pDest );
			}

			if ( methode.equals("estGrandParent") )
			{
				chaine = " est grand-parent de ";
				bEval  = pOrig.estGrandParent (pDest );
			}

			if ( methode.equals("estPetitEnfant") )
			{
				chaine = " est petit-enfant de ";
				bEval  = pOrig.estPetitEnfant (pDest );
			}

			if ( methode.equals("estOncle") )
			{
				chaine = " est oncle        de ";
				bEval  = pOrig.estOncle (pDest );
			}

			if ( methode.equals("estNeveu") )
			{
				chaine = " est neveu        de ";
				bEval  = pOrig.estNeveu (pDest );
			}

			if ( methode.equals("estCousin") )
			{
				chaine = " est cousin       de ";
				bEval  = pOrig.estCousin (pDest );
			}

			if ( methode.equals("estEnfant") )
			{
				chaine = " est enfant       de ";
				bEval  = pOrig.estEnfant (pDest );
			}



			return String.format ("%3d",   numTest )                         +
				   "  ==> "                                                   +
				   String.format ("%-20s", tabPersonne.get(source).getNom() ) +
				   chaine                                                     +
				   (dest==-1?String.format ("%-20s","null"):
				             String.format ("%-20s", pDest.getNom() ) )       +
				   " : "                                                      +
				   String.format ( "%-5s", bEval)                             +
				   (bEval==resAttendu?"  ok ":"  ERREUR");

		}


}