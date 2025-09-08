public class Permute
{
     static void permuter(int[] tab, int ind1, int ind2) 
    {
        int temp = tab[ind1];
        tab[ind1] = tab[ind2];
        tab[ind2] = temp;
    }
}