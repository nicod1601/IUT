import javax.swing.*;

public class Test extends JFrame
{
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;

    public Test()
    {
        this.setSize(800, 600);

        this.tabbedPane = new JTabbedPane();
        this.setContentPane(tabbedPane);

        this.panel1 = new JPanel();
        this.panel1.add(new JLabel("coucou"));

        this.panel2 = new JPanel();
        this.panel2.add(new JLabel("salut connard"));

        this.tabbedPane.addTab("Onglet 1", this.panel1);
        this.tabbedPane.addTab("Onglet 2", this.panel2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}