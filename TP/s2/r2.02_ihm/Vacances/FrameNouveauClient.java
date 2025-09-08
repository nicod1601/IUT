import javax.swing.*;

public class FrameNouveauClient extends JFrame {
    private PanelNouveauClient panelNouveauClient;
    public FrameNouveauClient() {
        this.setTitle("Nouveau client");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.panelNouveauClient = new PanelNouveauClient();
        this.add(this.panelNouveauClient);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameNouveauClient();
    }
}