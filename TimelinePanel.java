import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel {

    private TextEditor textEditor;

    public TimelinePanel(TextEditor textEditor) {
        this.textEditor = textEditor;
        setLayout(new BorderLayout());
        setBackground(new Color(120, 120, 120)); // Set a solid grey color
        setPreferredSize(new Dimension(0, 50));

        // Panel to hold timeline elements
        JPanel elementsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10)); // Provide horizontal and vertical gaps
        elementsPanel.setOpaque(false); // Make it transparent
        elementsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Left padding

        // Panel to hold "+" button
        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10)); // Provide vertical gap
        addButtonPanel.setOpaque(false); // Make it transparent
        addButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20)); // Right padding

        JButton addButton = new JButton("+");
        addButton.addActionListener(e -> addTimelineElement(elementsPanel));
        addButtonPanel.add(addButton);

        add(elementsPanel, BorderLayout.CENTER);
        add(addButtonPanel, BorderLayout.EAST);
    }

    public void addTimelineElement(JPanel elementsPanel) {
        TimelineElement element = new TimelineElement(textEditor);
        elementsPanel.add(element);
        elementsPanel.revalidate();
        elementsPanel.repaint();
    }
}
