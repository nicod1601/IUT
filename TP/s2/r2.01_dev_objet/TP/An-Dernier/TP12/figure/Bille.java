package figure;
import figure.couleur.CouleurK;

public class Bille
{
    private static final int rouge = 65536;
    private static final int vert  = 256  ;
    private static final int bleu  = 1    ;

    private int couleur;

    public Bille(int couleur)
    {
        this.couleur = couleur;
    }

    public Bille(int r, int v, int b)
    {
       this((r*Bille.rouge + v*Bille.vert + b*Bille.bleu));
    }

    public String toString()
    {
        String srt = "";

        srt += "[" + this.couleur + "]";
        return srt;
        
    }
}
