import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JDorm2 extends JFrame implements ItemListener {
    private JTextArea messageTextArea;
    private JCheckBox privateRoomCheckBox;
    private JCheckBox internetCheckBox;
    private JCheckBox cableTvCheckBox;
    private JCheckBox microwaveCheckBox;
    private JCheckBox refrigeratorCheckBox;

    public JDorm2() {
        setTitle("Dormitory Room Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        messageTextArea = new JTextArea();
        messageTextArea.setEditable(false);
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel checkBoxPanel = new JPanel(new GridLayout(5, 1));

        privateRoomCheckBox = new JCheckBox("Private Room");
        privateRoomCheckBox.addItemListener(this);
        checkBoxPanel.add(privateRoomCheckBox);

        internetCheckBox = new JCheckBox("Internet Connection");
        internetCheckBox.addItemListener(this);
        checkBoxPanel.add(internetCheckBox);

        cableTvCheckBox = new JCheckBox("Cable TV Connection");
        cableTvCheckBox.addItemListener(this);
        checkBoxPanel.add(cableTvCheckBox);

        microwaveCheckBox = new JCheckBox("Microwave");
        microwaveCheckBox.addItemListener(this);
        checkBoxPanel.add(microwaveCheckBox);

        refrigeratorCheckBox = new JCheckBox("Refrigerator");
        refrigeratorCheckBox.addItemListener(this);
        checkBoxPanel.add(refrigeratorCheckBox);

        add(checkBoxPanel, BorderLayout.WEST);
    }

    private String getCurrentChoices() {
        StringBuilder choices = new StringBuilder("Current Choices:\n");
        if (privateRoomCheckBox.isSelected())
            choices.append("- Private Room\n");
        if (internetCheckBox.isSelected())
            choices.append("- Internet Connection\n");
        if (cableTvCheckBox.isSelected())
            choices.append("- Cable TV Connection\n");
        if (microwaveCheckBox.isSelected())
            choices.append("- Microwave\n");
        if (refrigeratorCheckBox.isSelected())
            choices.append("- Refrigerator\n");
        return choices.toString();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        messageTextArea.setText(getCurrentChoices());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JDorm2 app = new JDorm2();
            app.setVisible(true);
        });
    }
}
