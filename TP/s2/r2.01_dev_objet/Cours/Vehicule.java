public class Vehicule
{
	private String nom;
	private Train train;
	
	public Vehicule( String nom)
	{
		
	}
	
	public Train getTrain()
	{
	
	}
	
	public boolean ajouterTrain(Train t)
	{
		if(t == null){return false;}
		
		this.train = t;
		return true;
		
	}
}
