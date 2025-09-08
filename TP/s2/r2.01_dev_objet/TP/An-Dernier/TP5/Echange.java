public class Echange                                     
{                                                 
	public static void echange (Entier val1, Entier val2)         
	{                                                
		int temp = val1.getEntier();                                                                         
		val1.setEntier(val2.getEntier());;                                    
		val2.setEntier(temp);                                    
	}                                                
}

