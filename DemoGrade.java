import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StudentManagementSystem extends JFrame implements ActionListener {
    JTextField nameField, rollNoField, mathField, englishField, hindiField, physicsField, chemistryField;
    JButton calculateButton;
    JLabel totalMarksLabel, gradeLabel;

    StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(500, 400);
		setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 4));

        JLabel nameLabel = new JLabel("Enter Name:");
        nameField = new JTextField();
        JLabel rollNoLabel = new JLabel("Enter Roll No:");
        rollNoField = new JTextField();
        JLabel mathLabel = new JLabel("Maths:");
        mathField = new JTextField();
        JLabel englishLabel = new JLabel("English:");
        englishField = new JTextField();
        JLabel hindiLabel = new JLabel("Hindi:");
        hindiField = new JTextField();
        JLabel physicsLabel = new JLabel("Physics:");
        physicsField = new JTextField();
        JLabel chemistryLabel = new JLabel("Chemistry:");
        chemistryField = new JTextField();

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        totalMarksLabel = new JLabel();
        gradeLabel = new JLabel();

        add(nameLabel);
        add(nameField);
        add(rollNoLabel);
        add(rollNoField);
        add(mathLabel);
        add(mathField);
        add(englishLabel);
        add(englishField);
        add(hindiLabel);
        add(hindiField);
        add(physicsLabel);
        add(physicsField);
        add(chemistryLabel);
        add(chemistryField);
        add(calculateButton);
        add(totalMarksLabel);
        add(gradeLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String name = nameField.getText();
            String rollNo = rollNoField.getText();
            int math = Integer.parseInt(mathField.getText());
            int english = Integer.parseInt(englishField.getText());
            int hindi = Integer.parseInt(hindiField.getText());
            int physics = Integer.parseInt(physicsField.getText());
            int chemistry = Integer.parseInt(chemistryField.getText());

            float totalMarks = math + english + hindi + physics + chemistry;
            float avgPercentage = totalMarks / 500 * 100;

            String grade;
            if (avgPercentage >= 90)
                grade = "Outstanding (Grade A)";
            else if (avgPercentage >= 80)
                grade = "Very Good (Grade B)";
            else if (avgPercentage >= 70)
                grade = "Good (Grade C)";
            else if (avgPercentage >= 60)
                grade = "Satisfactory (Grade D)";
            else if (avgPercentage >= 35)
                grade = "Passed (Grade E)";
            else
                grade = "Fail (Grade F)";

            totalMarksLabel.setText("Total Marks: " + totalMarks);
            gradeLabel.setText("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
