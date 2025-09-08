public class Triangle extends Polygone
{
    public Triangle(double cote1, double cote2, double cote3)
    {
        super(3);
        super.cotes[1] = cote1;
        super.cotes[2] = cote2;
        super.cotes[3] = cote3;
    }

    public double getAire()
    {
        double p, S;

        p = super.getPerimetre()/2;

       return S = Math.sqrt(p*(p-this.cotes[1])*(p-this.cotes[2])*(p-this.cotes[3]));
    }

}
