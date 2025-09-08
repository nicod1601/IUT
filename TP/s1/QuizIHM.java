import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizIHM {

    // Questions et réponses avec explications
    private static final String[][] questions = {
            {"Que signifie 'public' en Java ?", "Une méthode visible par toutes les classes", "Une méthode visible uniquement dans le package", "Une méthode visible dans la classe", "Une méthode privée", "1", "'public' signifie que la méthode ou la variable est accessible depuis toutes les classes."},
            {"Quelle est la méthode principale d'exécution en Java ?", "start()", "main()", "execute()", "run()", "2", "La méthode 'main()' est le point d'entrée de tout programme Java."},
            {"Que fait la commande 'javac' ?", "Exécute un programme Java", "Compile un fichier Java en bytecode", "Teste un programme Java", "Débogue un fichier Java", "2", "La commande 'javac' transforme le code source Java en bytecode exécutable."},
            {"Comment déclare-t-on un tableau en Java ?", "int[] tab;", "int tab[];", "tab int[];", "Les deux premières réponses", "4", "En Java, on peut déclarer un tableau avec 'int[] tab;' ou 'int tab[];'."},
            {"Quelle est la valeur par défaut d'une variable de type 'boolean' ?", "true", "false", "0", "null", "2", "En Java, la valeur par défaut d'un 'boolean' est 'false'."}
    };

    // Indice de la question actuelle
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Composants de l'interface
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton nextButton;

    public QuizIHM() {
        // Configurer la fenêtre principale
        frame = new JFrame("Quiz sur le Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Titre du quiz
        JLabel titleLabel = new JLabel("Quiz sur le Java", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel central pour la question et les options
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel("Question", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(questionLabel);

        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();

        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            centerPanel.add(options[i]);
        }

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bouton Suivant
        nextButton = new JButton("Suivant");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        frame.add(nextButton, BorderLayout.SOUTH);

        loadQuestion();

        frame.setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            String[] questionData = questions[currentQuestionIndex];
            questionLabel.setText(questionData[0]);

            for (int i = 0; i < options.length; i++) {
                options[i].setText(questionData[i + 1]);
                options[i].setSelected(false);
            }
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        String correctAnswer = questions[currentQuestionIndex][5];
        int selectedOption = -1;

        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i + 1;
                break;
            }
        }

        if (selectedOption == Integer.parseInt(correctAnswer)) {
            score++;
        } else {
            JOptionPane.showMessageDialog(frame, "Mauvaise réponse !\nExplication : " + questions[currentQuestionIndex][6], "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        currentQuestionIndex++;
        loadQuestion();
    }

    private void showResult() {
        JOptionPane.showMessageDialog(frame, "Quiz terminé !\nVotre score : " + score + " / " + questions.length, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizIHM::new);
    }
}
