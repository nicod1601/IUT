package multiapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.text.DecimalFormat;

public class MultiApp extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private HashMap<String, Double> accounts = new HashMap<>();
    private String currentDirectory = System.getProperty("user.home") + File.separator + "MultiAppFiles";
    
    public MultiApp() {
        // Configuration de la fenêtre principale
        setTitle("Application Multifonctionnelle");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initialisation du gestionnaire de cartes
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        // Création du menu principal
        createMainMenu();
        
        // Création des modules
        createAccountsModule();
        createCalculatorModule();
        createAppLauncherModule();
        createFileStorageModule();
        
        // Ajouter le panel principal
        add(cardPanel);
        
        // Créer le répertoire de l'application si nécessaire
        createAppDirectory();
        
        // Charger les données sauvegardées
        loadAccountData();
    }
    
    private void createMainMenu() {
        JPanel menuPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Application Multifonctionnelle", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        menuPanel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        
        addMenuButton(buttonsPanel, "Gérer mes comptes", "accounts");
        addMenuButton(buttonsPanel, "Calculatrice", "calculator");
        addMenuButton(buttonsPanel, "Lanceur d'applications", "launcher");
        addMenuButton(buttonsPanel, "Stockage de fichiers", "storage");
        
        menuPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        cardPanel.add(menuPanel, "menu");
    }
    
    private void addMenuButton(JPanel panel, String text, String destination) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.addActionListener(e -> cardLayout.show(cardPanel, destination));
        panel.add(button);
    }
    
    // Module de gestion des comptes
    private void createAccountsModule() {
        JPanel accountsPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Gestion de Comptes", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        accountsPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Panel central pour la liste des comptes
        JPanel centerPanel = new JPanel(new BorderLayout());
        JList<String> accountsList = new JList<>();
        DefaultListModel<String> accountsModel = new DefaultListModel<>();
        accountsList.setModel(accountsModel);
        
        JScrollPane scrollPane = new JScrollPane(accountsList);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel pour les opérations
        JPanel operationsPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        operationsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextField accountNameField = new JTextField();
        JTextField amountField = new JTextField();
        
        operationsPanel.add(new JLabel("Nom du compte:"));
        operationsPanel.add(accountNameField);
        operationsPanel.add(new JLabel("Montant:"));
        operationsPanel.add(amountField);
        
        JButton addAccountButton = new JButton("Ajouter/Modifier compte");
        addAccountButton.addActionListener(e -> {
            try {
                String name = accountNameField.getText().trim();
                double amount = Double.parseDouble(amountField.getText().trim());
                if (!name.isEmpty()) {
                    accounts.put(name, amount);
                    updateAccountsList(accountsModel);
                    saveAccountData();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Montant invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton deleteAccountButton = new JButton("Supprimer compte");
        deleteAccountButton.addActionListener(e -> {
            String selected = accountsList.getSelectedValue();
            if (selected != null) {
                String accountName = selected.split(":")[0].trim();
                accounts.remove(accountName);
                updateAccountsList(accountsModel);
                saveAccountData();
            }
        });
        
        operationsPanel.add(addAccountButton);
        operationsPanel.add(deleteAccountButton);
        
        JButton backButton = new JButton("Retour au menu");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        operationsPanel.add(backButton);
        
        centerPanel.add(operationsPanel, BorderLayout.SOUTH);
        accountsPanel.add(centerPanel, BorderLayout.CENTER);
        
        cardPanel.add(accountsPanel, "accounts");
    }
    
    private void updateAccountsList(DefaultListModel<String> model) {
        model.clear();
        DecimalFormat df = new DecimalFormat("#,##0.00 €");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            model.addElement(entry.getKey() + ": " + df.format(entry.getValue()));
        }
    }
    
    // Module de calculatrice
    private void createCalculatorModule() {
        JPanel calculatorPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Calculatrice", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        calculatorPanel.add(titleLabel, BorderLayout.NORTH);
        
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        calculatorPanel.add(display, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Variables pour stocker les opérations
        final StringBuilder currentInput = new StringBuilder();
        final double[] firstNumber = {0};
        final String[] currentOperator = {""};
        
        // Fonction pour ajouter les boutons numériques
        ActionListener numButtonAction = e -> {
            String digit = ((JButton) e.getSource()).getText();
            currentInput.append(digit);
            display.setText(currentInput.toString());
        };
        
        // Créer les boutons numériques
        for (int i = 7; i <= 9; i++) {
            addCalculatorButton(buttonPanel, String.valueOf(i), numButtonAction);
        }
        addCalculatorButton(buttonPanel, "/", e -> {
            if (currentInput.length() > 0) {
                performOperation(currentInput, firstNumber, currentOperator, display);
                currentOperator[0] = "/";
            }
        });
        
        for (int i = 4; i <= 6; i++) {
            addCalculatorButton(buttonPanel, String.valueOf(i), numButtonAction);
        }
        addCalculatorButton(buttonPanel, "*", e -> {
            if (currentInput.length() > 0) {
                performOperation(currentInput, firstNumber, currentOperator, display);
                currentOperator[0] = "*";
            }
        });
        
        for (int i = 1; i <= 3; i++) {
            addCalculatorButton(buttonPanel, String.valueOf(i), numButtonAction);
        }
        addCalculatorButton(buttonPanel, "-", e -> {
            if (currentInput.length() > 0) {
                performOperation(currentInput, firstNumber, currentOperator, display);
                currentOperator[0] = "-";
            } else {
                // Permettre les nombres négatifs
                currentInput.append("-");
                display.setText(currentInput.toString());
            }
        });
        
        addCalculatorButton(buttonPanel, "0", numButtonAction);
        addCalculatorButton(buttonPanel, ".", e -> {
            if (!currentInput.toString().contains(".")) {
                if (currentInput.length() == 0) {
                    currentInput.append("0");
                }
                currentInput.append(".");
                display.setText(currentInput.toString());
            }
        });
        addCalculatorButton(buttonPanel, "C", e -> {
            currentInput.setLength(0);
            firstNumber[0] = 0;
            currentOperator[0] = "";
            display.setText("");
        });
        addCalculatorButton(buttonPanel, "+", e -> {
            if (currentInput.length() > 0) {
                performOperation(currentInput, firstNumber, currentOperator, display);
                currentOperator[0] = "+";
            }
        });
        
        // Bouton égal et retour
        addCalculatorButton(buttonPanel, "=", e -> {
            if (currentInput.length() > 0 && !currentOperator[0].isEmpty()) {
                double secondNumber = Double.parseDouble(currentInput.toString());
                double result = 0;
                
                switch (currentOperator[0]) {
                    case "+":
                        result = firstNumber[0] + secondNumber;
                        break;
                    case "-":
                        result = firstNumber[0] - secondNumber;
                        break;
                    case "*":
                        result = firstNumber[0] * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber[0] / secondNumber;
                        } else {
                            display.setText("Erreur: Division par zéro");
                            currentInput.setLength(0);
                            return;
                        }
                        break;
                }
                
                display.setText(String.valueOf(result));
                firstNumber[0] = result;
                currentInput.setLength(0);
                currentOperator[0] = "";
            }
        });
        
        calculatorPanel.add(buttonPanel, BorderLayout.CENTER);
        
        JButton backButton = new JButton("Retour au menu");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        calculatorPanel.add(backButton, BorderLayout.SOUTH);
        
        cardPanel.add(calculatorPanel, "calculator");
    }
    
    private void performOperation(StringBuilder currentInput, double[] firstNumber, String[] currentOperator, JTextField display) {
        if (currentOperator[0].isEmpty()) {
            firstNumber[0] = Double.parseDouble(currentInput.toString());
        } else {
            double secondNumber = Double.parseDouble(currentInput.toString());
            switch (currentOperator[0]) {
                case "+":
                    firstNumber[0] += secondNumber;
                    break;
                case "-":
                    firstNumber[0] -= secondNumber;
                    break;
                case "*":
                    firstNumber[0] *= secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        firstNumber[0] /= secondNumber;
                    } else {
                        display.setText("Erreur: Division par zéro");
                        currentInput.setLength(0);
                        return;
                    }
                    break;
            }
        }
        display.setText(String.valueOf(firstNumber[0]));
        currentInput.setLength(0);
    }
    
    private void addCalculatorButton(JPanel panel, String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.addActionListener(action);
        panel.add(button);
    }
    
    // Module de lanceur d'applications
    private void createAppLauncherModule() {
        JPanel launcherPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Lanceur d'Applications", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        launcherPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Liste des applications
        DefaultListModel<ApplicationEntry> appListModel = new DefaultListModel<>();
        JList<ApplicationEntry> appList = new JList<>(appListModel);
        appList.setCellRenderer(new AppListRenderer());
        
        // Ajouter quelques applications par défaut
        appListModel.addElement(new ApplicationEntry("Bloc-notes", "notepad.exe", "Éditeur de texte simple"));
        appListModel.addElement(new ApplicationEntry("Calculatrice Windows", "calc.exe", "Calculatrice système"));
        appListModel.addElement(new ApplicationEntry("Explorateur de fichiers", "explorer.exe", "Navigateur de fichiers"));
        
        JScrollPane appScrollPane = new JScrollPane(appList);
        launcherPanel.add(appScrollPane, BorderLayout.CENTER);
        
        // Panel de contrôle
        JPanel controlPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton launchButton = new JButton("Lancer l'application");
        launchButton.addActionListener(e -> {
            ApplicationEntry selected = appList.getSelectedValue();
            if (selected != null) {
                try {
                    Runtime.getRuntime().exec(selected.getPath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, 
                        "Impossible de lancer l'application: " + ex.getMessage(), 
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton addAppButton = new JButton("Ajouter une application");
        addAppButton.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField pathField = new JTextField();
            JTextField descField = new JTextField();
            
            JButton browseButton = new JButton("Parcourir...");
            JPanel pathPanel = new JPanel(new BorderLayout());
            pathPanel.add(pathField, BorderLayout.CENTER);
            pathPanel.add(browseButton, BorderLayout.EAST);
            
            browseButton.addActionListener(ev -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    pathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            });
            
            Object[] message = {
                "Nom:", nameField,
                "Chemin:", pathPanel,
                "Description:", descField
            };
            
            int option = JOptionPane.showConfirmDialog(this, message, "Ajouter une application", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
            if (option == JOptionPane.OK_OPTION && !nameField.getText().trim().isEmpty() 
                && !pathField.getText().trim().isEmpty()) {
                appListModel.addElement(new ApplicationEntry(
                    nameField.getText().trim(),
                    pathField.getText().trim(),
                    descField.getText().trim()
                ));
            }
        });
        
        JButton backButton = new JButton("Retour au menu");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        
        controlPanel.add(launchButton);
        controlPanel.add(addAppButton);
        controlPanel.add(backButton);
        
        launcherPanel.add(controlPanel, BorderLayout.SOUTH);
        
        cardPanel.add(launcherPanel, "launcher");
    }
    
    // Module de stockage de fichiers
    private void createFileStorageModule() {
        JPanel storagePanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Stockage de Fichiers", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        storagePanel.add(titleLabel, BorderLayout.NORTH);
        
        // Panel d'information
        JPanel infoPanel = new JPanel(new BorderLayout());
        JLabel currentDirLabel = new JLabel("Répertoire actuel: " + currentDirectory);
        infoPanel.add(currentDirLabel, BorderLayout.NORTH);
        
        // Liste des fichiers
        DefaultListModel<FileEntry> fileListModel = new DefaultListModel<>();
        JList<FileEntry> fileList = new JList<>(fileListModel);
        fileList.setCellRenderer(new FileListRenderer());
        JScrollPane fileScrollPane = new JScrollPane(fileList);
        
        // Mise à jour de la liste des fichiers
        updateFileList(fileListModel, currentDirectory);
        
        infoPanel.add(fileScrollPane, BorderLayout.CENTER);
        storagePanel.add(infoPanel, BorderLayout.CENTER);
        
        // Panel des actions
        JPanel actionPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton openButton = new JButton("Ouvrir");
        openButton.addActionListener(e -> {
            FileEntry selected = fileList.getSelectedValue();
            if (selected != null) {
                if (selected.isDirectory()) {
                    currentDirectory = selected.getPath();
                    currentDirLabel.setText("Répertoire actuel: " + currentDirectory);
                    updateFileList(fileListModel, currentDirectory);
                } else {
                    try {
                        Desktop.getDesktop().open(new File(selected.getPath()));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, 
                            "Impossible d'ouvrir le fichier: " + ex.getMessage(), 
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        JButton uploadButton = new JButton("Importer");
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    Path source = selectedFile.toPath();
                    Path destination = Paths.get(currentDirectory, selectedFile.getName());
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    updateFileList(fileListModel, currentDirectory);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, 
                        "Erreur lors de l'importation: " + ex.getMessage(), 
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton newFolderButton = new JButton("Nouveau dossier");
        newFolderButton.addActionListener(e -> {
            String folderName = JOptionPane.showInputDialog(this, 
                "Nom du nouveau dossier:", "Créer un dossier", JOptionPane.PLAIN_MESSAGE);
            if (folderName != null && !folderName.trim().isEmpty()) {
                try {
                    Path newFolder = Paths.get(currentDirectory, folderName.trim());
                    Files.createDirectory(newFolder);
                    updateFileList(fileListModel, currentDirectory);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, 
                        "Erreur lors de la création du dossier: " + ex.getMessage(), 
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> {
            FileEntry selected = fileList.getSelectedValue();
            if (selected != null) {
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Êtes-vous sûr de vouloir supprimer \"" + selected.getName() + "\"?", 
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Files.delete(Paths.get(selected.getPath()));
                        updateFileList(fileListModel, currentDirectory);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, 
                            "Erreur lors de la suppression: " + ex.getMessage(), 
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        JButton parentButton = new JButton("Dossier parent");
        parentButton.addActionListener(e -> {
            File current = new File(currentDirectory);
            File parent = current.getParentFile();
            if (parent != null) {
                currentDirectory = parent.getAbsolutePath();
                currentDirLabel.setText("Répertoire actuel: " + currentDirectory);
                updateFileList(fileListModel, currentDirectory);
            }
        });
        
        JButton backButton = new JButton("Retour au menu");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        
        actionPanel.add(openButton);
        actionPanel.add(uploadButton);
        actionPanel.add(newFolderButton);
        actionPanel.add(deleteButton);
        actionPanel.add(parentButton);
        actionPanel.add(backButton);
        
        storagePanel.add(actionPanel, BorderLayout.SOUTH);
        
        cardPanel.add(storagePanel, "storage");
    }
    
    private void updateFileList(DefaultListModel<FileEntry> model, String directory) {
        model.clear();
        File dir = new File(directory);
        File[] files = dir.listFiles();
        
        if (files != null) {
            // Trier les fichiers: dossiers d'abord, puis fichiers
            Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && !f2.isDirectory()) {
                    return -1;
                } else if (!f1.isDirectory() && f2.isDirectory()) {
                    return 1;
                } else {
                    return f1.getName().compareToIgnoreCase(f2.getName());
                }
            });
            
            for (File file : files) {
                model.addElement(new FileEntry(file.getName(), file.getAbsolutePath(), file.isDirectory()));
            }
        }
    }
    
    private void createAppDirectory() {
        File appDir = new File(currentDirectory);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
    }
    
    private void saveAccountData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(currentDirectory + File.separator + "accounts.dat"))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Erreur lors de la sauvegarde des comptes: " + e.getMessage(), 
                "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadAccountData() {
        File accountsFile = new File(currentDirectory + File.separator + "accounts.dat");
        if (accountsFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(accountsFile))) {
                accounts = (HashMap<String, Double>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                accounts = new HashMap<>();
            }
        }
    }
    
    // Classes internes pour les entrées de listes
    static class ApplicationEntry {
        private String name;
        private String path;
        private String description;
        
        public ApplicationEntry(String name, String path, String description) {
            this.name = name;
            this.path = path;
            this.description = description;
        }
        
        public String getName() {
            return name;
        }
        
        public String getPath() {
            return path;
        }
        
        public String getDescription() {
            return description;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    static class FileEntry {
        private String name;
        private String path;
        private boolean isDirectory;
        
        public FileEntry(String name, String path, boolean isDirectory) {
            this.name = name;
            this.path = path;
            this.isDirectory = isDirectory;
        }
        
        public String getName() {
            return name;
        }
        
        public String getPath() {
            return path;
        }
        
        public boolean isDirectory() {
            return isDirectory;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    // Renderers personnalisés pour les listes
    static class AppListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof ApplicationEntry) {
                ApplicationEntry entry = (ApplicationEntry) value;
                setText(entry.getName() + " - " + entry.getDescription());
            }
            
            return this;
        }
    }
    
    static class FileListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof FileEntry) {
                FileEntry entry = (FileEntry) value;
                if (entry.isDirectory()) {
                    setText("[Dossier] " + entry.getName());
                } else {
                    setText(entry.getName());
                }
            }
            
            return this;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Utiliser le look and feel du système
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            MultiApp app = new MultiApp();
            app.setVisible(true);
        });
    }
}
