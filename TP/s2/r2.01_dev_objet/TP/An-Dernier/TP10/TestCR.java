public class TestCR 
{
    public static void main(String[] a)
    {
        Rectangle r1,r2;
        Carre c1,c2;

        r1 = new Rectangle(15, 9);
        r2 = new Rectangle(8,12);

        c1 = new Carre(4);
        c2 = new Carre(6);

        System.out.println("------------");
        System.out.println("Rectangle r1");
        System.out.println("------------");

        System.out.println(r1.toString());

        System.out.println("------------");
        System.out.println("Rectangle r2");
        System.out.println("------------");

        System.out.println(r2.toString());

        System.out.println("--------");
        System.out.println("Carre c1");
        System.out.println("--------");

        System.out.println(c1.toString());

        System.out.println("--------");
        System.out.println("Carre c2");
        System.out.println("--------");

        System.out.println(c2.toString());
    }
}
