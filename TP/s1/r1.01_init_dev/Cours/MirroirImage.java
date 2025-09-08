/**
 * MirroirImage
 * @version 1.0
 * @author Delpech Nicolas, Damestoy Ethan, Grangeon Alan et Bermendora Pol Armand
 * @date 22/11/2024
 */

public class MirroirImage 
{

    public static void main(String[] args)
    {
        /*----------------- */
        /*    Variables     */
        /*----------------- */
        char[][] tab;

        /*----------------- */
        /*    Instructions  */
        /*----------------- */

        if(args.length != 2)
        {
            System.out.println("Usage: java MirroirImage sourcePath destinationPath");
            return;
        }

        String sourcePath = args[0];
        String destinationPath = args[1];

        tab = ImageUtil.Image2Tab(sourcePath);
        Symetrie.symetrie1(tab);
        ImageUtil.tabToImage(tab, destinationPath);

    }

}