package pac.emballage;

public class Cylindre
{
	private double rayonInterne;
	private double rayonExterne;

	private double hauteurInterne;
	private double hauteurExterne;

	public Cylindre (double rayonInterne, double rayonExterne, double hauteurInterne, double hauteurExterne )
	{
		this.rayonInterne   = rayonInterne;
		this.rayonExterne   = rayonExterne;
		this.hauteurInterne = hauteurInterne;
		this.hauteurExterne = hauteurExterne;
	}

	public double getSurfaceExterne()
	{
		return Cylindre.surface(this.rayonExterne,this.hauteurExterne);
	}

	public double getSurfaceInterne()
	{
		return Cylindre.surface(this.rayonInterne,this.hauteurInterne);
	}

	public double getVolumeExterne()
	{
		return Cylindre.volume(this.rayonExterne,this.hauteurExterne);
	}

	public double getVolumeInterne()
	{
		return Cylindre.volume(this.rayonInterne,this.hauteurInterne);
	}

	public static double surface(double rayon, double hauteur)
	{
		return  2 * Math.PI * rayon * rayon   +
				2 * Math.PI * rayon * hauteur;
	}

	public static double volume(double rayon, double hauteur)
	{
		return Math.PI * rayon * rayon * hauteur;
	}

}
