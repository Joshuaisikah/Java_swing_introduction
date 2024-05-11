import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDorm extends JFrame implements ItemListener {
    private JTextArea messageTextArea;
    private JCheckBox privateRoomCheckBox;
    private JCheckBox internetCheckBox;
    private JCheckBox cableTvCheckBox;
    private JCheckBox microwaveCheckBox;
    private JCheckBox refrigeratorCheckBox;

    public JDorm() {
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

        updateMessage();
    }

    private void updateMessage() {
        StringBuilder message = new StringBuilder("Options not yet selected:\n");
        if (!privateRoomCheckBox.isSelected())
            message.append("- Private Room\n");
        if (!internetCheckBox.isSelected())
            message.append("- Internet Connection\n");
        if (!cableTvCheckBox.isSelected())
            message.append("- Cable TV Connection\n");
        if (!microwaveCheckBox.isSelected())
            message.append("- Microwave\n");
        if (!refrigeratorCheckBox.isSelected())
            message.append("- Refrigerator\n");
        messageTextArea.setText(message.toString());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        updateMessage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JDorm app = new JDorm();
            app.setVisible(true);
        });
    }
}
