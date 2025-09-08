package pac.emballage;

public class Cube
{
	private double coteInterne;
	private double coteExterne;


	public Cube (double coteInterne, double coteExterne )
	{
		this.coteInterne   = coteInterne;
		this.coteExterne   = coteExterne;
	}

	public double getSurfaceExterne()
	{
		return   this.coteExterne * this.coteExterne * 6;
	}

	public double getSurfaceInterne()
	{
		return   this.coteInterne * this.coteExterne * 6;
	}

	public double getVolumeExterne()
	{
		return Math.pow ( this.coteExterne, 3 );
	}

	public double getVolumeInterne()
	{
		return Math.pow ( this.coteInterne, 3 );
	}

}
