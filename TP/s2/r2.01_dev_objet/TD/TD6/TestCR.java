public class TestCR 
{
    public static void main(String[] args)
    {
        Carre c1 = new Carre(5);
        Carre c2 = new Carre(4);
        Carre c3 = new Carre(2);
        Carre c4 = new Carre(9);

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5,6);
        Rectangle r3 = new Rectangle(9,4);
        Rectangle r4 = new Rectangle(2,2);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

    }
}
