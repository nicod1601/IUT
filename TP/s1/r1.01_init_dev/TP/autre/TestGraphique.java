import iut.algo.*;

public class TestGraphique
{

	public static void main(String[] a)
	{
		/*-----------------*/
		/* Variables       */
		/*-----------------*/
		ControleGraphique ct;

		int ecart;


		/*-----------------*/
		/* Instructions    */
		/*-----------------*/

		/* initialisation de la zone de dessin */

		ct = new ControleGraphique();
		ct.setTaille( 600,500 );


		/* dessin */

		// dessines des traits bleu clairs

		ct.prendreStylo ( Couleur.BLEU_CLAIR );
		ct.ligne ( 100,  10, 200,  10 );
		ct.ligne ( 210,  20, 210, 120 );
		ct.ligne ( 200, 130, 100, 130 );
		ct.ligne (  90, 120,  90,  20 );


		// 4 Rectangles

		ct.prendreStylo ( Couleur.NOIR );
		ct.rectangle ( 50, 180, 120, 220);
		ct.rectanglePeint ( 50, 230, 120, 260, Couleur.BLEU_ROYAL );

		ct.prendreStylo ( Couleur.ROUGE );
		ct.rectangle ( 140, 220, 180,  180 );
		ct.rectanglePeint ( 180, 260, 140, 230, Couleur.CORAIL_CLAIR );


		// 2 Cercles

		ct.prendreStylo ( Couleur.JAUNE_DORE );
		ct.cercle       ( 100, 350, 20 );
		ct.cerclePeint  ( 100, 400, 20, Couleur.JAUNE_DORE_PALE );


		// Trois carrés en dégradé de gris

		ct.prendreStylo ( Couleur.GRIS_MAT );

		ecart = 0;
		ct.rectanglePeint ( 100+ecart, 300, 120+ecart, 320, Couleur.GRIS_GAINSBORO );

		ecart = 30;
		ct.rectanglePeint ( 100+ecart, 300, 120+ecart, 320, Couleur.GRIS_ARGENT    );

		ecart = ecart + 30;
		ct.rectanglePeint ( 100+ecart, 300, 120+ecart, 320, Couleur.GRIS           );

	}
}