public class Mult3
{
    public static void main(String[] args) 
    {
       /*------------*/
       /* Variables  */
       /*------------*/
       int    nb       ;
       
       /*--------------*/
       /* Instruction  */
       /*--------------*/
		nb = 0;
	
		while(nb < 100)
		{
			if(nb % 3 == 0)
			{
			System.out.println(nb);
			}
		
			nb++;
		}
    }
}
