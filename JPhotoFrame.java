import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPhotoFrame extends JFrame implements ActionListener {
    private JLabel subjectLabel;
    private JLabel locationLabel;
    private JCheckBox onePersonCheckBox;
    private JCheckBox twoOrMoreCheckBox;
    private JCheckBox petCheckBox;
    private JCheckBox inStudioCheckBox;
    private JCheckBox onLocationCheckBox;
    private JButton calculateButton;
    private JLabel resultLabel;

    public JPhotoFrame() {
        setTitle("Paula's Portraits - Photography Session Price Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        subjectLabel = new JLabel("Select Portrait Subject:");
        add(subjectLabel);

        onePersonCheckBox = new JCheckBox("One Person ($40)");
        add(onePersonCheckBox);

        twoOrMoreCheckBox = new JCheckBox("Two or More Subjects ($75)");
        add(twoOrMoreCheckBox);

        petCheckBox = new JCheckBox("Pet ($95)");
        add(petCheckBox);

        locationLabel = new JLabel("Select Session Location:");
        add(locationLabel);

        inStudioCheckBox = new JCheckBox("In-Studio (Base Price)");
        add(inStudioCheckBox);

        onLocationCheckBox = new JCheckBox("On Location ($90)");
        add(onLocationCheckBox);

        calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(this);
        add(calculateButton);

        resultLabel = new JLabel("");
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int basePrice = 40;
        int additionalFee = 0;

        if (twoOrMoreCheckBox.isSelected())
            additionalFee = 75;
        else if (petCheckBox.isSelected())
            additionalFee = 95;

        if (onLocationCheckBox.isSelected())
            additionalFee += 90;

        int totalPrice = basePrice + additionalFee;
        resultLabel.setText("Total Price: $" + totalPrice);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPhotoFrame app = new JPhotoFrame();
            app.setVisible(true);
        });
    }
}
