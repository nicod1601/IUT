import iut.algo.Clavier;

public class Suite
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int cpt1, cpt2, cpt3;
		int pat ;
		int val;
       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
		
		System.out.println("suite 1: ");
		System.out.println("========" );
		
		cpt3 = cpt2 = cpt1 = 1;
		
		pat = 2;
		val = 1;
		
		while(cpt1 < 100)
		{
			System.out.print(val + " ");
			
			val += pat;
			
			cpt1++;
		}
		
		System.out.println();
		
		pat = 1;
		val = 1;
		
		System.out.println("suite 2: ");
		System.out.println("========" );
		
		while(cpt2 < 100)
		{
			System.out.print(val + " ");
			
			
			val += pat;
			pat = pat + 1;
			
			cpt2++;
		}
		
		
		System.out.println();
		
		pat = 2;
		val = 1;
		
		System.out.println("suite 3: ");
		System.out.println("========" );
		
		while(cpt3 < 100)
		{
			System.out.print(val + " ");
			
			val += pat;
			pat = 3 - pat;
			
			cpt3++;
		}
		
		System.out.println();
		
    }
}
