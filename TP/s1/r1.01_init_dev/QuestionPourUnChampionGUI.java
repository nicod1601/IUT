import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class QuestionPourUnChampionGUI {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel questionLabel, scoreLabel, timerLabel;
    private static JButton[] answerButtons;
    private static JButton startButton;
    private static JComboBox<String> themeComboBox, modeComboBox;
    private static Timer timer;
    private static int score = 0;
    private static int timeLimit = 15;
    private static int timeRemaining;
    private static int currentQuestionIndex = 0;
    
    private static String[] themes = {"Histoire", "Géographie", "Science", "Culture Générale"};
    private static String[][] questions = {
        {"Qui a découvert l'Amérique?", "Christophe Colomb", "Henri IV", "Napoléon", "Louis XIV"},
        {"Quelle est la capitale de la France?", "Paris", "Berlin", "Madrid", "Rome"},
        {"Quel est l'élément chimique H2O?", "Eau", "Oxygène", "Hydrogène", "Azote"},
        {"Qui a écrit 'Les Misérables'?", "Victor Hugo", "Molière", "Zola", "Balzac"},
        {"Quel est le plus grand pays du monde?", "Russie", "Canada", "Chine", "États-Unis"},
        {"Quel est le plus grand océan?", "Pacifique", "Atlantique", "Indien", "Arctique"},
        {"Qui a peint la Mona Lisa?", "Léonard de Vinci", "Picasso", "Van Gogh", "Dali"},
        {"Quel est l'élément chimique du sel?", "Chlore", "Oxygène", "Hydrogène", "Carbone"},
        {"Dans quel pays se trouve la Tour Eiffel?", "France", "Italie", "Espagne", "Royaume-Uni"},
        {"Quel est le plus grand désert du monde?", "Sahara", "Gobi", "Karakum", "Atacama"}
    };
    
    private static String[][] answers = {
        {"Christophe Colomb"},
        {"Paris"},
        {"Eau"},
        {"Victor Hugo"},
        {"Russie"},
        {"Pacifique"},
        {"Léonard de Vinci"},
        {"Chlore"},
        {"France"},
        {"Sahara"}
    };
    
    private static String theme;
    private static String mode;
    private static Map<Integer, String> userAnswers = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Créer la fenêtre de jeu
            frame = new JFrame("Questions pour un Champion");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            // Créer un panneau principal
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            frame.add(panel);

            // Créer les éléments de l'interface
            createMenu();
            frame.setVisible(true);
        });
    }

    private static void createMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // Titre
        JLabel titleLabel = new JLabel("Questions pour un Champion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0x0066CC));  // Bleu de l'émission
        menuPanel.add(titleLabel);

        // Choisir le thème
        themeComboBox = new JComboBox<>(themes);
        menuPanel.add(new JLabel("Choisissez un thème :"));
        menuPanel.add(themeComboBox);

        // Choisir le mode de jeu
        String[] modes = {"Carré", "Cache", "Duo"};
        modeComboBox = new JComboBox<>(modes);
        menuPanel.add(new JLabel("Choisissez un mode :"));
        menuPanel.add(modeComboBox);

        // Bouton pour démarrer le jeu
        startButton = new JButton("Démarrer");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBackground(new Color(0x009900));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> startGame());
        menuPanel.add(startButton);

        panel.add(menuPanel, BorderLayout.CENTER);
    }

    private static void startGame() {
        // Récupérer le thème et le mode choisis
        theme = (String) themeComboBox.getSelectedItem();
        mode = (String) modeComboBox.getSelectedItem();

        // Configurer les composants de jeu
        panel.removeAll();
        panel.repaint();

        // Créer les nouveaux éléments du jeu
        questionLabel = new JLabel("Question :", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(new Color(0x0066CC));
        scoreLabel = new JLabel("Score : " + score, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setForeground(new Color(0x0066CC));
        timerLabel = new JLabel("Temps restant : " + timeLimit, SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        timerLabel.setForeground(new Color(0x0066CC));

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 1, 10, 10));
        gamePanel.setBackground(new Color(0xF5F5F5));
        gamePanel.add(questionLabel);
        gamePanel.add(scoreLabel);
        gamePanel.add(timerLabel);

        panel.add(gamePanel, BorderLayout.NORTH);

        answerButtons = new JButton[4];
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        answerPanel.setBackground(new Color(0xF5F5F5));

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            answerButtons[i].setBackground(new Color(0xFFFFFF));
            answerButtons[i].setForeground(new Color(0x0066CC));
            answerButtons[i].setFocusPainted(false);
            final int index = i;
            answerButtons[i].addActionListener(e -> checkAnswer(index));
            answerPanel.add(answerButtons[i]);
        }

        panel.add(answerPanel, BorderLayout.CENTER);

        // Lancer la première question
        nextQuestion();
    }

    private static void nextQuestion() {
        if (currentQuestionIndex >= questions.length) {
            endGame();
            return;
        }

        // Afficher la question et les réponses
        int themeIndex = Arrays.asList(themes).indexOf(theme);
        String[] currentQuestion = questions[themeIndex];
        String correctAnswer = answers[themeIndex][currentQuestionIndex];

        questionLabel.setText("Question : " + currentQuestion[0]);
        scoreLabel.setText("Score : " + score);

        // Mettre à jour les réponses
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(currentQuestion[i + 1]);
        }

        // Démarrer le timer pour la question
        timeRemaining = timeLimit;
        timerLabel.setText("Temps restant : " + timeRemaining);
        startTimer();

        currentQuestionIndex++;
    }

    private static void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Temps restant : " + timeRemaining);
                if (timeRemaining <= 0) {
                    timer.stop();
                    timeOut();
                }
            }
        });
        timer.start();
    }

    private static void checkAnswer(int index) {
        String correctAnswer = answers[Arrays.asList(themes).indexOf(theme)][currentQuestionIndex - 1];
        String playerAnswer = answerButtons[index].getText();

        if (playerAnswer.equals(correctAnswer)) {
            score++;
            userAnswers.put(currentQuestionIndex, "Bonne réponse");
        } else {
            userAnswers.put(currentQuestionIndex, "Mauvaise réponse");
        }

        nextQuestion();
    }

    private static void timeOut() {
        userAnswers.put(currentQuestionIndex, "Temps écoulé");
        nextQuestion();
    }

    private static void endGame() {
        panel.removeAll();
        panel.repaint();

        // Afficher le récapitulatif
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        resultPanel.add(new JLabel("Votre score final : " + score));
        resultPanel.add(new JLabel("Réponses :"));

        for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
            resultPanel.add(new JLabel("Question " + entry.getKey() + ": " + entry.getValue()));
        }

        panel.add(resultPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
