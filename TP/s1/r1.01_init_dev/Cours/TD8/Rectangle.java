public class Rectangle
{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;


	public Rectangle (Point ptOrigine, double tailleX, double tailleY)
	{

		this.pointA = new Point(ptOrigine);
		this.pointA.setNom('A');
		this.pointC = new Point(this.pointA);
		this.pointC.setNom('C');
		this.pointC.deplacer(tailleX,tailleY);

		this.construireBD();
	}


	public Point getPoint (int indice)
	{
		Point tmp = null;
		switch ( indice )
		{
			case 0 ->
			{
				tmp = new Point(this.pointA);
				tmp.setNom(this.pointA.getNom());
			}
			case 1 ->
			{
				tmp = new Point(this.pointB);
				tmp.setNom(this.pointB.getNom());
			}
			case 2 ->
			{
				tmp = new Point(this.pointC);
				tmp.setNom(this.pointC.getNom());
			}
			case 3 ->
			{
				tmp = new Point(this.pointD);
				tmp.setNom(this.pointD.getNom());
			}
		}

		return tmp;
	}


	public void deplacer ( double dx, double dy)
	{
		this.pointA.deplacer(dx, dy); 
		this.pointB.deplacer(dx, dy); 
		this.pointC.deplacer(dx, dy); 
		this.pointD.deplacer(dx, dy); 
	}

	public String toString ()
	{
		return "[ " + this.pointA.toString() + " : " +
		              this.pointB.toString() + " : " +
		              this.pointC.toString() + " : " +
		              this.pointD.toString() + " ]";
	}

	public void tourner (char sens)
	{
		Double deltaX, deltaY;


		deltaX = this.pointC.getX() - this.pointA.getX();
		deltaY = this.pointC.getY() - this.pointA.getY();

		if (sens == '+' )
		{
			this.pointC.setX(this.pointA.getX() + deltaY);
			this.pointC.setY(this.pointA.getY() - deltaX);
			
			
		}
		else
		{
			this.pointC.setX(this.pointA.getX() - deltaY);
			this.pointC.setY(this.pointA.getY() + deltaX);
		}


		// D�termination de b et d en fonction des positions de a par rapport à c  */
		this.construireBD();
	}

	private void construireBD()
	{
		// Parmi les quatre cas de figure afin de toujours positionner les points dans le
		// m�me sens, il y a deux solutions diff�rentes pour obtenir les coordonn�es de B et D
		// ==> @1

		if(this.pointC.getX() < this.pointA.getX())
		{
			if(this.pointC.getY() > this.pointA.getY())
			{
				this.pointB = new Point(this.pointC.getX() , this.pointA.getY(), 'B');
				this.pointD = new Point(this.pointA.getX() , this.pointC.getY(), 'D');
			}
			else
			{
				this.pointB = new Point(this.pointC.getY() , this.pointA.getX(), 'B');
				this.pointD = new Point(this.pointA.getY() , this.pointC.getX(), 'D');
			}
		}
		else
		{
			if(this.pointC.getY() > this.pointA.getY())
			{
				this.pointB = new Point(this.pointC.getY() , this.pointA.getX(), 'B');
				this.pointD = new Point(this.pointA.getY() , this.pointC.getX(), 'D');
			}
			else
			{
				this.pointB = new Point(this.pointC.getX() , this.pointA.getY(), 'B');
				this.pointD = new Point(this.pointA.getX() , this.pointC.getY(), 'D');
			}
		}
	
	}
	
	public static void main(String[] a)
	{
		Rectangle r1;
		Point pA,pB,pC,pD;
		
		pA = new Point(4.0,3.0,'A');
		//pA.setNom('A');
		
		r1 = new Rectangle(pA, 4.0,2.0);
		
		System.out.println(r1);
		
		r1.tourner('+');
		
		System.out.println(r1);
		
		r1.tourner('+');
		
		System.out.println(r1);
		
		r1.tourner('+');
		
		System.out.println(r1);
		
		r1.tourner('+');
		
		System.out.println(r1);
		
		r1.tourner('-');
		
		System.out.println(r1);
		
	}

}


/*----*/
/* @1 */
/*-------------------------------------------------------*/
/*                                                       */
/*   pointC.getX() |  pointC.getX()  |                   */
/*        <        |       >         |                   */
/*   pointA.getX() |  pointA.getX()  |                   */
/*  ---------------+-----------------+-----------------  */
/*  CAS 1 : SOL 1  | CAS 3 : SOL 2   |                   */
/*     C    D      |    B    C       |                   */
/*      .          |       .         |   pointC.getY()   */
/*       .         |      .          |        >          */
/*        .        |     .           |   pointA.getY()   */
/*     B    A      |    A    D       |                   */
/*                 |                 |                   */
/*  ---------------+-----------------+----------------   */
/*  CAS 2 : SOL 2  | CAS 4 : SOL 1   |                   */
/*     D    A      |    A    B       |                   */
/*        .        |     .           |   pointC.getY()   */
/*       .         |      .          |        <          */
/*      .          |       .         |   pointA.getY()   */
/*     C    B      |    D    C       |                   */
/*  ---------------+-----------------+----------------   */
/*                                                       */
/*-------------------------------------------------------*/
