public class Exo1
{
    public static void main(String[] a)
    {

        /* Donnees */
        double petitDouble;
        double grandDouble;

        int petitInt;
        Integer grandInt;

        String uneChaine;

        /* Instruction */
        grandDouble = 1853.657;

        petitDouble = grandDouble;
        petitDouble = grandDouble;
    
        //petitDouble = grandDouble.doubleValue();// autre possibilité que nous pouvons aujourd'hui oublié
                                                 // grace à un mécanisme d'auto-boxing

        System.out.println( grandDouble );
        System.out.println( petitDouble );

        // 1.2 on vient déjà de le faire à la ligne  du programme
        petitDouble = 156.23;

        grandDouble = petitDouble;
        // grandDouble = new Double (petitDouble); impossible deprecated
        grandDouble = Double.valueOf(petitDouble); // certes stylé

        System.out.println( grandDouble );
        System.out.println( petitDouble );

        // 1.3
        uneChaine ="125.36";

        petitDouble = Double.parseDouble( uneChaine );

        System.out.println(petitDouble);

    }
}