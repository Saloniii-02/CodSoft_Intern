import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student {
    String name;
    String rollNo;
    int[] marks;

    Student(String name, String rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    float calculatePercentage() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (float) totalMarks / marks.length;
    }

    String calculateGrade() {
        float percentage = calculatePercentage();
        if (percentage >= 90)
            return "Outstanding (Grade A)";
        else if (percentage >= 80)
            return "Very Good (Grade B)";
        else if (percentage >= 70)
            return "Good (Grade C)";
        else if (percentage >= 60)
            return "Satisfactory (Grade D)";
        else if (percentage >= 35)
            return "Passed (Grade E)";
        else
            return "Fail (Grade F)";
    }
}

class StudentManagementSystem extends JFrame implements ActionListener {
    JTextField nameField, rollNoField, marksFields[];
    JLabel[] subjectLabels;
    JButton addButton, searchButton, removeButton;
    JTextArea resultArea;
    java.util.List<Student> students;

    StudentManagementSystem() {
        students = new java.util.ArrayList<>();
        setTitle("Student Management System");
        setLayout(new GridLayout(0, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField();
        rollNoField = new JTextField();
        marksFields = new JTextField[5];
        subjectLabels = new JLabel[5];
        resultArea = new JTextArea();
        addButton = new JButton("Add Student");
        searchButton = new JButton("Search");
        removeButton = new JButton("Remove");

        String[] subjects = { "Maths", "English", "Hindi", "Physics", "Chemistry" };
        for (int i = 0; i < 5; i++) {
            subjectLabels[i] = new JLabel(subjects[i]);
            marksFields[i] = new JTextField();
            add(subjectLabels[i]);
            add(marksFields[i]);
        }

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Roll No:"));
        add(rollNoField);
        add(new JLabel(""));
        add(addButton);
        add(new JLabel(""));
        add(searchButton);
        add(new JLabel(""));
        add(removeButton);
        add(new JLabel(""));
        add(new JScrollPane(resultArea));

        addButton.addActionListener(this);
        searchButton.addActionListener(this);
        removeButton.addActionListener(this);

        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String rollNo = rollNoField.getText();
            int[] marks = new int[5];
            for (int i = 0; i < 5; i++) {
                try {
                    marks[i] = Integer.parseInt(marksFields[i].getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Enter valid marks for all subjects");
                    return;
                }
            }
            students.add(new Student(name, rollNo, marks));
            JOptionPane.showMessageDialog(this, "Student added successfully");
        } else if (e.getSource() == searchButton) {
            String rollNo = rollNoField.getText();
            boolean found = false;
            for (Student student : students) {
                if (student.rollNo.equals(rollNo)) {
                    resultArea.setText("Name: " + student.name + "\nRoll No: " + student.rollNo + "\n");
                    resultArea.append("Marks:\n");
                    for (int i = 0; i < 5; i++) {
                        resultArea.append(subjectLabels[i].getText() + ": " + student.marks[i] + "\n");
                    }
                    resultArea.append("Percentage: " + student.calculatePercentage() + "\n");
                    resultArea.append("Grade: " + student.calculateGrade() + "\n");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Student not found");
            }
        } else if (e.getSource() == removeButton) {
            String rollNo = rollNoField.getText();
            for (Student student : students) {
                if (student.rollNo.equals(rollNo)) {
                    students.remove(student);
                    JOptionPane.showMessageDialog(this, "Student removed successfully");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Student not found");
        }
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
