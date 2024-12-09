import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsSwing extends JFrame implements ActionListener {
    private JLabel promptLabel, computerChoiceLabel, resultLabel, scoreLabel;
    private JButton rockButton, paperButton, scissorsButton;

    private int playerScore = 0;
    private int computerScore = 0;

    public RockPaperScissorsSwing() {
        setTitle("Rock-Paper-Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Prompt label
        promptLabel = new JLabel("Choose Rock, Paper, or Scissors:", SwingConstants.CENTER);
        add(promptLabel);

        // Buttons
        JPanel buttonPanel = new JPanel();
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        add(buttonPanel);

        // Computer choice label
        computerChoiceLabel = new JLabel("Computer chose: ", SwingConstants.CENTER);
        add(computerChoiceLabel);

        // Result label
        resultLabel = new JLabel("", SwingConstants.CENTER);
        add(resultLabel);

        // Score label
        scoreLabel = new JLabel("Score - You: 0 | Computer: 0", SwingConstants.CENTER);
        add(scoreLabel);

        // Add action listeners
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
    }

    private String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (playerChoice.equals("Scissors") && computerChoice.equals("Paper")) ||
                   (playerChoice.equals("Paper") && computerChoice.equals("Rock"))) {
            playerScore++;
            return "You win!";
        } else {
            computerScore++;
            return "Computer wins!";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = "";
        if (e.getSource() == rockButton) {
            playerChoice = "Rock";
        } else if (e.getSource() == paperButton) {
            playerChoice = "Paper";
        } else if (e.getSource() == scissorsButton) {
            playerChoice = "Scissors";
        }

        String computerChoice = getComputerChoice();
        computerChoiceLabel.setText("Computer chose: " + computerChoice);

        String result = determineWinner(playerChoice, computerChoice);
        resultLabel.setText(result);

        scoreLabel.setText("Score - You: " + playerScore + " | Computer: " + computerScore);
    }

    public static void main(String[] args) {
        RockPaperScissorsSwing game = new RockPaperScissorsSwing();
        game.setVisible(true);
    }
}

