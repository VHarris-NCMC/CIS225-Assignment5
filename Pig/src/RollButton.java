import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollButton extends JButton {

    public RollButton(String s) {
        super(s);
        addActionListener(e -> {

            Die.rollDice();

        });

    }
}
