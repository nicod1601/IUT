package appli.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelStrategie extends JPanel implements ActionListener, MouseListener {
    private JLabel[][] tabLabel;
    private JButton retourButton;

    private FrameAppli frame;

    public PanelStrategie(FrameAppli frame) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(30, 30, 30));

        JPanel gridPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        gridPanel.setBackground(new Color(30, 30, 30));

        this.frame = frame;

        /*--------------------------*/
        /* Création des composants  */
        /*--------------------------*/
        String[][] strategies = {
            {"./img/Orbital_Napalm_Barrage.png", "Barrage de Napalm Orbital", "Un bombardement orbital qui enflamme une large zone, infligeant des dégâts continus aux ennemis pris dans les flammes."},
            {"./img/Orbital_Gatling_Barrage.png", "Barrage Gatling Orbital", "Un tir de suppression rapide depuis l'orbite, efficace contre les groupes d'ennemis légers."}
            /*{"./img/Orbital_Airburst_Strike.png", "Frappe Aérienne Orbitale", "Une frappe précise qui explose au-dessus du sol, idéale pour éliminer l'infanterie ennemie retranchée."},
            {"./img/Orbital_380mm_HE_Barrage.png", "Barrage Orbital 380mm HE", "Un puissant bombardement utilisant des obus explosifs de 380mm, causant des dégâts massifs sur une zone ciblée."},
            {"./img/Orbital_Walking_Barrage.png", "Barrage Ambulant Orbital", "Un bombardement progressif qui avance dans une direction spécifiée, nettoyant les zones ennemies sur son passage."},
            {"./img/Orbital_Laser_Strike.png", "Frappe Laser Orbitale", "Un laser orbital concentré infligeant des dégâts élevés à une cible unique, efficace contre les véhicules blindés."},
            {"./img/Orbital_Railcannon_Strike.png", "Frappe Railcannon Orbitale", "Un tir de canon électromagnétique depuis l'orbite, pénétrant les blindages lourds et infligeant des dégâts considérables."},
            {"./img/Orbital_EMS_Strike.png", "Frappe EMS Orbitale", "Une impulsion électromagnétique depuis l'orbite qui neutralise temporairement les systèmes électroniques ennemis dans la zone ciblée."},
            {"./img/Orbital_Smoke_Strike.png", "Frappe Fumigène Orbitale", "Déploie un écran de fumée depuis l'orbite, offrant une couverture visuelle pour les mouvements tactiques."},
            {"./img/Eagle_Strafing_Run.png", "Passage en Rase-Mottes de l'Aigle", "Un avion de soutien effectue une passe de mitraillage, infligeant des dégâts aux ennemis en ligne droite."},
            {"./img/Eagle_Napalm_Airstrike.png", "Frappe Aérienne au Napalm de l'Aigle", "Un largage de napalm depuis un avion de soutien, enflammant une zone spécifique."},
            {"./img/Eagle_Cluster_Bomb.png", "Bombe à Sous-Munitions de l'Aigle", "Un bombardement dispersant de multiples petites bombes, efficace contre les groupes d'ennemis."},
            {"./img/Eagle_110mm_Rocket_Pods.png", "Pods de Roquettes 110mm de l'Aigle", "Un tir de roquettes depuis un avion de soutien, infligeant des dégâts significatifs sur une zone ciblée."},
            {"./img/Eagle_500kg_Bomb.png", "Bombe de 500kg de l'Aigle", "Une bombe lourde larguée depuis un avion de soutien, causant une explosion massive."},
            {"./img/Jump_Pack.png", "Pack de Saut", "Un équipement dorsal permettant des sauts propulsés, offrant une mobilité accrue sur le champ de bataille."},
            {"./img/Shield_Generator_Pack.png", "Pack Générateur de Bouclier", "Un dispositif portable qui génère un bouclier énergétique, protégeant le porteur des dégâts."},
            {"./img/Resupply_Pack.png", "Pack de Ravitaillement", "Fournit des munitions supplémentaires et des grenades aux alliés proches."},
            {"./img/Ammo_Backpack.png", "Sac à Dos de Munitions", "Augmente la capacité de munitions transportées par le porteur."},
            {"./img/Heavy_Armor.png", "Armure Lourde", "Une armure renforcée offrant une protection supérieure contre les dégâts, au détriment de la mobilité."},
            {"./img/Anti-Personnel_Mines.png", "Mines Antipersonnel", "Déploie des mines au sol qui explosent au contact des ennemis, efficaces contre l'infanterie."},
            {"./img/Anti-Tank_Mines.png", "Mines Antichar", "Des mines conçues pour infliger de lourds dégâts aux véhicules blindés ennemis."},
            {"./img/Autocannon_Turret.png", "Tourelle Autocanon", "Une tourelle automatique équipée d'un autocanon, fournissant un soutien feu continu contre les ennemis."},
            {"./img/Gatling_Turret.png", "Tourelle Gatling", "Une tourelle automatique avec une mitrailleuse Gatling, efficace contre les vagues d'infanterie."},
            {"./img/Mortar_Sentry.png", "Sentinelle Mortier", "Une tourelle déployable qui tire des obus de mortier sur les positions ennemies."},
            {"./img/Guard_Dog_Rover.png", "Chien de Garde Rover", "Un drone terrestre autonome qui patrouille et attaque les ennemis à proximité."},
            {"./img/Shield_Generator_Relay.png", "Relais Générateur de Bouclier", "Crée un champ de force protégeant les alliés dans une zone définie."},
            {"./img/EMS_Mortar_Sentry.png", "Sentinelle Mortier EMS", "Une tourelle mortier qui tire des obus à impulsion électromagnétique, neutralisant les systèmes électroniques ennemis."},
            {"./img/Ballistic_Shield_Backpack.png", "Sac à Dos Bouclier Balistique", "Fournit un bouclier balistique portable, augmentant la défense frontale du porteur."},
            {"./img/Incendiary_Mines.png", "Mines Incendiaires", "Des mines qui déclenchent une explosion enflammée, infligeant des dégâts de feu aux ennemis."},
            {"./img/Smoke_Grenade_Launcher.png", "Lance-Grenades Fumigènes", "Un lanceur portable tirant des grenades fumigènes pour masquer les mouvements alliés."},
            {"./img/Recoilless_Rifle.png", "Fusil Sans Recul", "Une arme lourde portable efficace contre les véhicules et les structures fortifiées."},
            {"./img/Stalwart.png", "Stalwart", "Une mitrailleuse légère offrant une cadence de tir élevée pour le soutien d'infanterie."}*/
        };
         
        
        int rows = strategies.length;
        this.tabLabel = new JLabel[rows][2];
        
        for (int i = 0; i < rows; i++) {
            // Colonne 1 : Image + Nom
            ImageIcon icon = new ImageIcon (getClass().getResource(strategies[i][0]));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            this.tabLabel[i][0] = new JLabel(strategies[i][1], icon, SwingConstants.LEFT);
            this.tabLabel[i][0].setForeground(Color.WHITE);
            this.tabLabel[i][0].setFont(new Font("Arial", Font.BOLD, 14));
            this.tabLabel[i][0].setOpaque(true);
            this.tabLabel[i][0].setBackground(new Color(50, 50, 50));
            gridPanel.add(this.tabLabel[i][0]);
            
            // Colonne 2 : Description
            this.tabLabel[i][1] = new JLabel("<html>" + strategies[i][2] + "</html>", SwingConstants.LEFT);
            this.tabLabel[i][1].setForeground(Color.WHITE);
            this.tabLabel[i][1].setFont(new Font("Arial", Font.PLAIN, 12));
            gridPanel.add(this.tabLabel[i][1]);
        }
        
        // Bouton de retour à l'accueil
        retourButton = new JButton("Retour à l'accueil");
        retourButton.setFont(new Font("Arial", Font.BOLD, 14));
        retourButton.setBackground(new Color(70, 70, 70));
        retourButton.setForeground(Color.YELLOW);
        retourButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        retourButton.setFocusPainted(false);
        retourButton.addActionListener(this);
        
        // Ajout des composants
        this.add(new JScrollPane(gridPanel), BorderLayout.CENTER);
        this.add(retourButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retourButton) {
            System.out.println("Retour à l'accueil...");
            this.frame.panelStrategie(false);
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
