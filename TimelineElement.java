import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.UUID;

public class TimelineElement extends JButton {

    private String id;
    private TextEditor textEditor;
    private Random rand = new Random();
    private int height;

    public TimelineElement(TextEditor textEditor, int height) {
        this.textEditor = textEditor;
        this.height = height;

        // Generate a unique ID for this element
        this.id = UUID.randomUUID().toString();
        setText(id.substring(0, 8)); 

        // Generate a random pastel color for this button
        Color randomPastel = new Color(200+rand.nextInt(56), 200+rand.nextInt(56), 200+rand.nextInt(56));
        setFont(new Font("Arial", Font.PLAIN, 18)); 
        setForeground(new Color(60, 63, 65)); 
        setBackground(randomPastel);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        addActionListener(e -> {
            textEditor.setSelectedElementId(id);
            textEditor.setText(textEditor.getText(id));
        });

        textEditor.addTimelineText(id, "");
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension original = super.getPreferredSize();
        return new Dimension(original.width, height);
    }
}
