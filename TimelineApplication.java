import javax.swing.*;
import java.awt.*;

public class TimelineApplication extends JFrame {

    private TimelinePanel timelinePanel;
    private TextEditor textEditor;

    public TimelineApplication() {
        setTitle("Timeline Application");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        textEditor = new TextEditor();
        timelinePanel = new TimelinePanel(textEditor);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textEditor, BorderLayout.CENTER);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        wrapperPanel.add(timelinePanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
        add(wrapperPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimelineApplication().setVisible(true));
    }
}
