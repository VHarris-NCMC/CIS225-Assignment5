import javax.swing.*;

public class TakePointsButton extends JButton {
    public TakePointsButton(String label) {
        super(label);
        addActionListener(e -> {

            ScoreKeeper.endRun(true);

        });
    }
}
