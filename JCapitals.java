import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCapitals extends JFrame implements ActionListener {
    private String[] countries = {"USA", "UK", "France", "Germany", "Japan", "Australia", "Brazil"};
    private String[] capitals = {"Washington D.C.", "London", "Paris", "Berlin", "Tokyo", "Canberra", "Brasília"};
    private JComboBox<String> countryComboBox;

    public JCapitals() {
        setTitle("Country Capitals");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Select a country:");
        add(label);

        countryComboBox = new JComboBox<>(countries);
        countryComboBox.addActionListener(this);
        add(countryComboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countryComboBox) {
            int selectedIndex = countryComboBox.getSelectedIndex();
            String selectedCountry = countries[selectedIndex];
            String capital = capitals[selectedIndex];
            JOptionPane.showMessageDialog(this, "The capital city of " + selectedCountry + " is " + capital);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JCapitals app = new JCapitals();
            app.setVisible(true);
        });
    }
}
