public class MiroireTourner 
{

    public static void main(String[] args) {
        char[][] tab;

        if (args.length != 2) {
            System.out.println("Usage: java MirroirImage sourcePath destinationPath");
            return;
        }

        String sourcePath = args[0];
        String destinationPath = args[1];

        tab = ImageUtil.Image2Tab(sourcePath);

        // Appliquer une rotation de 90° sur l'image
        tab = rotate90Clockwise(tab);

        ImageUtil.tabToImage(tab, destinationPath);
    }

    // Méthode pour tourner une image de 90° dans le sens horaire
    public static char[][] rotate90Clockwise(char[][] tab) {
        int rows = tab.length;
        int cols = tab[0].length;
        char[][] rotated = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = tab[i][j];
            }
        }

        return rotated;
    }
}
