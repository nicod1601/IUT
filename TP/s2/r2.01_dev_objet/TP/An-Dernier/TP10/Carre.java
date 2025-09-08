public class Carre extends Rectangle
{
    public Carre(int x)
    {
        super(x,x);
    }

    public boolean setLargeur(int x)
    {
        super.setLargeur(x);
        super.setLargeur(x);
        super.setLargeur(x);
        return true;
    }

    public boolean setLongueur(int x)
    {
        super.setLongueur(x);
        super.setLargeur(x);
        super.setLargeur(x);
        return true;
    }

    public String toString()
    {
        return super.toString();
    }

}
