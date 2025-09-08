public class Colis
{
	private static int numeroStk = 203;
	
	private int numColis;
	private char destination;
	
	public Colis(char destination)
	{
		this.destination = destination;
		this.numColis = Colis.numeroStk++;
	}
	
	public int getNumColis()   { return this.numColis   ;}
	public int getDestination(){ return this.destination;}
	
	public String toString()
	{
		return " [ ( " + this.numColis + ") " + this.destination +" ] ";
	}
}
