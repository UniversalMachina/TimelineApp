import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel {

    private TextEditor textEditor;
    private JPanel elementsPanel;

    public TimelinePanel(TextEditor textEditor) {
        this.textEditor = textEditor;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        // Give the panel some padding
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Set a solid light grey color and give a rounded border
        setBackground(new Color(211, 211, 211));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(120, 120, 120), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.gray, 5),
            getBorder()));

        setPreferredSize(new Dimension(500, 80)); // Reduce the width to restrict stretching

        // Panel to hold timeline elements
        elementsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); // Provide horizontal and vertical gaps
        elementsPanel.setOpaque(false); // Make it transparent
        elementsPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // Left padding

        // Panel to hold "+" button
        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10)); // Provide vertical gap
        addButtonPanel.setOpaque(false); // Make it transparent
        addButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30)); // Right padding

        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addButton.setForeground(new Color(60, 63, 65));
        addButton.setBackground(new Color(211, 211, 211));
        addButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        addButton.addActionListener(e -> addTimelineElement());
        addButtonPanel.add(addButton);

        add(elementsPanel, BorderLayout.CENTER);
        add(addButtonPanel, BorderLayout.EAST);
    }

    public void addTimelineElement() {
        TimelineElement element = new TimelineElement(textEditor, getPreferredSize().height - 20); // Deduct the vertical gaps
        elementsPanel.add(element);
        elementsPanel.revalidate();
        elementsPanel.repaint();
    }
}
