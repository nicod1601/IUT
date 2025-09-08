import iut.algo.Clavier;

public class Winner
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int note    ;
		int max, min;
		int nbMax   ;
       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
		
		System.out.print("Entrer une note : ");
		note = Clavier.lire_int();
		
		max = min = note;
		nbMax     = 0   ;
		
		while( note != 100)
		{
			if(note >= 0 && note <= 20)
			{
				if(note > max ){ nbMax += 1; max = note;}
				if(note == max){ nbMax += 1;}
			}
			System.out.print("Entrer une note : ");
			note = Clavier.lire_int();
		}
		
		System.out.println(max + " " + nbMax);
		
    }
}
