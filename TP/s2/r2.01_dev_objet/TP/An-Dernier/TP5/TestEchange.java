public class TestEchange                          
{                                                 
	public static void main (String args[])          
	{                                                
		Entier a = new Entier(5) ;
        Entier b = new Entier(8);
        
		Echange.echange(a,b);                      
		System.out.println ( "a :" + a.getEntier() + " b :" + b.getEntier() );  
	}                                                
}