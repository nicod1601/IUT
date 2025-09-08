import iut.algo.Clavier;


public class CarrePair10V2
{
    public static void main(String[] args) 
    {
       /*------------*/
       /* Variables  */
       /*------------*/
       int    nb       ;
       int    totalNb  ;
       int    nbPair   ;
       int    nbImpaire;
       String affichage;
       
       /*--------------*/
       /* Instruction  */
       /*--------------*/
		System.out.print("Entrer un nombre :  ");
		nb = Clavier.lire_int();
	
	
		nbPair    = 0  ;
		nbImpaire = 0  ;
		totalNb   = 0  ;
		affichage = " ";
	
       	while(nb >= 0)
       	{
       		totalNb = totalNb + 1;
		
			if(nb % 2 == 0)
			{
				affichage = affichage + "[" + nb*nb + "]  " ;
				nbPair = nbPair + 1;
			}
			else
			{
				affichage = affichage + "(" + 2*nb + ")  " ;
				nbImpaire = nbImpaire + 1;
			}

			System.out.print("Entrer un nombre :  ");
			nb = Clavier.lire_int();
       	}
       	System.out.println(affichage);
       	System.out.println("nombre de saisies Pair    : " + nbPair   );
       	System.out.println("nombre de saisies Impaire : " + nbImpaire);
       	System.out.println("nombre de saisies totales : " + totalNb  );
    }
}
