import iut.algo.Clavier;

public class VilleDistance 
{
    public static void main(String[] args) 
    {

        /*-----------------*/
		/*    Constante    */
		/*-----------------*/

        /*-----------------*/
		/*    Variables    */
		/*-----------------*/
        String[] tabVille;
        int[][] tabDistance;

        /*-----------------*/
		/*   Instructions  */
		/*-----------------*/
        tabVille = new String[]{"Rouen", "Havre", "Fecamp", "Paris"};

        tabDistance = new int[tabVille.length][tabVille.length];

        for(int cpt=0; cpt<tabVille.length; cpt++)
        {
            for(int cpt2=0; cpt2<=cpt; cpt2++)
            {
                if(tabVille[cpt].equals(tabVille[cpt2]))
                {
                    tabDistance[cpt][cpt2] = 0;
                }
                else
                {
                    System.out.println("Entrez la distance entre "+tabVille[cpt]+" et "+tabVille[cpt2]);
                    tabDistance[cpt][cpt2] = Clavier.lire_int();

                    tabDistance[cpt2][cpt] = tabDistance[cpt][cpt2];
                    
                }
            }
        }

        for(int cpt=0; cpt<tabVille.length; cpt++)
        {
            for(int cpt2=0; cpt2<tabVille.length; cpt2++)
            {
                System.out.println(tabVille[cpt]+" -> "+tabVille[cpt2]+" : "+tabDistance[cpt][cpt2]);
            }
        }
    }
}   
