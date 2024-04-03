import java.awt.*;
import java.awt.event.*;

class FDemo extends Frame implements ActionListener {
    Button b1;
    TextField tx1;
    Label l1;
    Label feedbackLabel;
    int r1 = (int)(Math.random() * 100) + 1;
    int attempts = 0;

    FDemo() {
        setTitle("Number Guessing Game");
        Font f = new Font("Arial", Font.BOLD, 25);
        setFont(f);
        setLayout(null);

        l1 = new Label("Guess the Number:");
        l1.setSize(350,70);
        l1.setLocation(100, 100);
        add(l1);

        tx1 = new TextField();
        tx1.setSize(500,70);
        tx1.setLocation(450, 100);
        add(tx1);

        b1 = new Button("Guess");
        b1.setSize(200, 70);
        b1.setLocation(250, 350);
        add(b1);
        b1.addActionListener(this);

        feedbackLabel = new Label("");
        feedbackLabel.setBounds(300,200,500,200);
        feedbackLabel.setAlignment(Label.LEFT);
        add(feedbackLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setSize(500, 300);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(tx1.getText());
            attempts++;
            if (guess > r1) {
                feedbackLabel.setText("Too high! Try again.");
            } else if (guess < r1) {
                feedbackLabel.setText("Too low! Try again.");
            } else {
                feedbackLabel.setText("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
}

class Demo200 {
    public static void main(String[] args) {
        FDemo f = new FDemo();
        f.setVisible(true);
        f.setLocation(200, 100);
    }
}