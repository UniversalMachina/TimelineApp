import javax.swing.*;
import java.util.UUID;

public class TimelineElement extends JButton {

    private String id;
    private TextEditor textEditor;

    public TimelineElement(TextEditor textEditor) {
        this.textEditor = textEditor;

        // Generate a unique ID for this element
        this.id = UUID.randomUUID().toString();
        setText(id.substring(0, 8)); // just using a part of UUID as button label for better visibility

        addActionListener(e -> {
            // Update selectedElementId when a timeline element is clicked
            textEditor.setSelectedElementId(id);

            // When this element is clicked, display its associated text
            textEditor.setText(textEditor.getText(id));
        });

        textEditor.addTimelineText(id, "");
    }
}
