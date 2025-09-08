public class Point
{
    private int x;
    private int y;
    private char nom;

    public Point()
    {
        this.x = 0;
        this.y = 0;
        this.nom = 'A';
    }

    public Point(int x, int y, char nom)
    {
        this.x = x;
        this.y = y;
        this.nom = nom;
    }

    public Point(Point p)
    {
        this.x = p.x;
        this.y = p.y;
        this.nom = p.nom;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public char getNom()
    {
        return this.nom;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setNom(char nom)
    {
        this.nom = nom;
    }

    public String toString()
    {
        return "(" + this.x + "," + this.y + ")";
    }
}