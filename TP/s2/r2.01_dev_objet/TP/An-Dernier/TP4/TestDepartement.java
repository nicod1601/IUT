public class TestDepartement 
{
	public static void main(String[] args)
	{
		/*----Donnee----- */
		Departement Departement;

		/*----Instruction---- */

		Departement = new Departement("69", "Rhône", 1500000, 3240);

		System.out.println("Informations sur le département " + Departement.getNom() + " ("
		+ Departement.getNumero() + "):");
		System.out.println("Population : " + Departement.getPopulation());
		System.out.println("Superficie : " + Departement.getSuperficie() + " km²");
		System.out.println("Densité : " + Departement.densite() + " hab/km²");
	}
}
