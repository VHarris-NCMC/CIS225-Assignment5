import javax.swing.*;

public class ResetButton extends JButton {
    public ResetButton(String reset) {
        super(reset);
        addActionListener(e -> {
            ScoreKeeper.reset();
        });

    }
}
