public class Point
{
	private double x;
	private double y;
	private char nom;

	// Constructeur sans paramètre <==> au constructeur par défaut,
	// mais n'est pas le constructeur par défaut
	public Point()
	{
		this(0.0,0.0,' ');

	}

	// Constructeur avec coordonnées
	public Point(double x, double y, char nom)
	{
		this.x   = x;
		this.y   = y;
		this.nom = nom;
	}

	// Constructeur par recopie
	public Point(Point p)
	{
		this(p.x, p.y, ' ');
	}



	// Modificateurs
	public void setNom ( char   nom ){ if(this.nom == ' ' ) this.nom = nom; }
	public void setX   ( double x   ){ this.x   =   x;                      }
	public void setY   ( double y   ){ this.y   =   y;                      }


	// Accesseurs
	public char   getNom(){ return this.nom;}
	public double getX  (){ return this.x;  }
	public double getY  (){ return this.y;  }


	// Autres Méthodes
	public void deplacer ( double dx, double dy )
	{
		this.x += dx;
		this.y += dy;
	}

	public boolean estConfondu ( Point autrePoint )
	{
		return this.x == autrePoint.x && this.y == autrePoint.y;
	}


	// Retour sous forme textuelles des coordonnées du Points
	public String toString ()
	{
		String sRet = "";
		
		sRet += "Point " + this.nom + " (" + this.x + ";" + this.y + ")";
		
		return sRet;
	}
	
	public static void main(String[] a)
	{
		Point p1, p2, p3, p4, p5;
		
		p1 = new Point();
		p2 = new Point(2.0,3.0,'A');
		p3 = new Point(4.2,2.1,'B');
		p4 = new Point(p2);
		p5 = p2;
		
		System.out.println("a : " + (p1 == p2));
		System.out.println("b : " + (p2 == p5));
		System.out.println("c : " + (p2 == p4));
		
		System.out.println("a : " + p1.estConfondu(p2));
		System.out.println("b : " + p2.estConfondu(p3));
		System.out.println("c : " + p2.estConfondu(p5));
		System.out.println("d : " + p4.estConfondu(p2));
		
		
		
	}

}
