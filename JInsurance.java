import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInsurance extends JFrame implements ActionListener {
    private JCheckBox hmoCheckBox;
    private JCheckBox ppoCheckBox;
    private JCheckBox dentalCheckBox;
    private JCheckBox visionCheckBox;
    private JTextField textField;

    public JInsurance() {
        setTitle("Insurance Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        hmoCheckBox = new JCheckBox("HMO ($200/month)");
        ppoCheckBox = new JCheckBox("PPO ($600/month)");
        dentalCheckBox = new JCheckBox("Dental Coverage ($75/month)");
        visionCheckBox = new JCheckBox("Vision Care ($20/month)");

        textField = new JTextField(20);
        textField.setEditable(false);

        add(hmoCheckBox);
        add(ppoCheckBox);
        add(dentalCheckBox);
        add(visionCheckBox);
        add(textField);

        hmoCheckBox.addActionListener(this);
        ppoCheckBox.addActionListener(this);
        dentalCheckBox.addActionListener(this);
        visionCheckBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int totalCost = 0;

        if (e.getSource() == hmoCheckBox) {
            if (hmoCheckBox.isSelected())
                totalCost += 200;
        } else if (e.getSource() == ppoCheckBox) {
            if (ppoCheckBox.isSelected())
                totalCost += 600;
        } else if (e.getSource() == dentalCheckBox) {
            if (dentalCheckBox.isSelected())
                totalCost += 75;
        } else if (e.getSource() == visionCheckBox) {
            if (visionCheckBox.isSelected())
                totalCost += 20;
        }

        textField.setText("Total Monthly Cost: $" + totalCost);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JInsurance app = new JInsurance();
            app.setVisible(true);
        });
    }
}
