public class Quadrilaterre extends Polygone
{
    public Quadrilaterre(double a, double b, double c, double d, double angle)
    {
        super(4);
        this.cotes[0] = a;
        this.cotes[1] = b;
        this.cotes[2] = c;
        this.cotes[3] = d;
    }

    public double getAire()
    {
        double diag;
        diag = sqrt( this.cotes[0]*this.cotes[0] + this.cotes[1]*this.cotes[1] -2*this.cotes[0]*this.cotes[1].cos(this.angle));

        return new Triangle(this.cotes[0], this.cotes[1],diag).getAire()+
               new Triangle(this.cotes[2], this.cotes[3],diag).getAire();
    }

    public String toString()
    {
        String s = super.toString();

        s += " a pour angle : " + this.angle / Math.PI + "pi";

        return s;
    }
}
