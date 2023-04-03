/**
 * The TakePointsButton class extends JButton to create a button that when clicked,
 * ends the current run in the ScoreKeeper by calling the endRun method with the
 * boolean value of true.
 */
import javax.swing.*;

public class TakePointsButton extends JButton {
    /**
     * Constructs a TakePointsButton with the given label.
     *
     * @param label the label of the button
     */
    public TakePointsButton(String label) {
        super(label);
        addActionListener(e -> {
            ScoreKeeper.endRun(true);
        });
    }
}
