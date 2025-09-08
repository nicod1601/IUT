public class Train
{
	private int num;
	private Vehicule tabVehicule;
	private int nbVehicule;
	
	public Train( int num)
	{
		
	}
	
	public int getNumero(){return this.num;}
	
	public boolean ajouterVehicule( Vehicule v)
	{
		if(v == null){return false;}
		if(this.nbVehicule == this.tabVehicule.length){return false;}
		
		this.tabVehicule[nbVehicule++] = v;
		return true;
	}
}
