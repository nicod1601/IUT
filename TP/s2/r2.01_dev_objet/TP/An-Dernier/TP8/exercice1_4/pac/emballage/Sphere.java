package pac.emballage;
import pac.inter.IPeinture;

public class Sphere implements IPeinture
{
    private double rayonInterne;
	private double rayonExterne;

    public Sphere(double rayonInterne,double rayonExterne)
    {
        this.rayonExterne = rayonExterne;
        this.rayonInterne = rayonInterne;
    }

    public double getSurfaceExterne()
	{
		return Sphere.surface(this.rayonExterne);
	}

	public double getSurfaceInterne()
	{
		return Sphere.surface(this.rayonInterne);
	}

    public static double surface(double rayon)
	{
		return  4* Math.PI * rayon * rayon  ;
				
	}

	public static double volume(double rayon)
	{
		return  4.0/3 * Math.PI * rayon * rayon * rayon;
	}
}
