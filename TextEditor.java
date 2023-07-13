import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.HashMap;

public class TextEditor extends JPanel {

    private JTextArea textArea;
    // Map to hold text values for each timeline element
    private HashMap<String, String> timelineTexts = new HashMap<>();

    // Keep track of the currently selected timeline element
    private String selectedElementId = null;

    public TextEditor() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300)); // You can adjust the dimension as needed

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateText();
            }
            public void removeUpdate(DocumentEvent e) {
                updateText();
            }
            public void changedUpdate(DocumentEvent e) {
                updateText();
            }

            void updateText() {
                // Check if an element is selected
                if (selectedElementId != null) {
                    // Update the text for the currently selected timeline element
                    timelineTexts.put(selectedElementId, textArea.getText());
                }
            }
        });
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void addTimelineText(String id, String text) {
        timelineTexts.put(id, text);
    }

    public String getText(String id) {
        return timelineTexts.get(id);
    }

    public void setSelectedElementId(String id) {
        this.selectedElementId = id;
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
