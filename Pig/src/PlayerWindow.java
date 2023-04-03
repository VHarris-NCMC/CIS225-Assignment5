/**
 * The PlayerWindow class extends JFrame to create a window that allows the user to enter the names of two players.
 * Once the names have been entered and the "Submit" button is clicked, the window is closed and the players are
 * passed to the GameWindow.
 */
import javax.swing.*;
import java.awt.*;

public class PlayerWindow extends JFrame {

    /**
     * The default size of the PlayerWindow.
     */
    public static final Dimension DEFAULT_SIZE = new Dimension(450,300);

    /**
     * The default size of the player name panels.
     */
    private static final Dimension DEFAULT_PPANEL_SIZE = new Dimension(420, 70);

    /**
     * Sets the players in the GameWindow and closes the PlayerWindow.
     *
     * @param p1 the first player
     * @param p2 the second player
     */
    public static void setPlayersAndClose(Player p1, Player p2)
    {
        GameWindow.setPlayer1(p1);
        GameWindow.setPlayer2(p2);
        _instance_.dispose();
        _instance_ = null;
    }

    /**
     * The instance of the PlayerWindow.
     */
    private static PlayerWindow _instance_;

    /**
     * Constructs a new PlayerWindow.
     */
    public PlayerWindow()
    {
        // prevent multiple instances of PlayerWindow from being open at one time.
        if (_instance_!= null)
        {
            return;
        }
        else {
            _instance_ = this;
        }

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel p1Panel = GetPlayerPanel();
        JTextField p1text = getPlayerTextField("Player 1");
        p1Panel.add(p1text);

        JPanel p2Panel = GetPlayerPanel();
        JTextField p2text = getPlayerTextField("Player 2");
        p2Panel.add(p2text);

        add(p1Panel);
        add(p2Panel);

        JButton submitButton = new JButton("Submit");
        submitButton. addActionListener(e -> {

            if (checkIfInputValid(p1text) && checkIfInputValid(p2text))
            {
                PlayerWindow.setPlayersAndClose(new Player(p1text.getText()), new Player(p2text.getText()));
            }
        });
        add(submitButton);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setSize(getPreferredSize());
        this.pack();
        this.setAlwaysOnTop(true);
        this.setVisible(true);

    }

    /**
     * Returns a new JPanel with the default size and a gray background.
     *
     * @return a new JPanel
     */
    private static JPanel GetPlayerPanel() {
        JPanel ppan = new JPanel();
        ppan.setPreferredSize(DEFAULT_PPANEL_SIZE);
        ppan.setSize(ppan.getPreferredSize());
        ppan.setBackground(Color.gray);
        return ppan;
    }

    /**
     * Returns a new JTextField with the given string as the initial text and the default size, font, and color.
     *
     * @param s the initial text for the JTextField
     * @return a new JTextField
     */
    private JTextField getPlayerTextField(String s) {

        JTextField ptext = new JTextField(s);
        ptext.setBackground(Color.darkGray);
        ptext.setFont(GameWindow.DEFAULT_FONT);
        ptext.setForeground(Color.WHITE);
        ptext.setPreferredSize(new Dimension(DEFAULT_PPANEL_SIZE.width,DEFAULT_PPANEL_SIZE.height));
        ptext.setSize(getPreferredSize());
        ptext.setVisible(true);

        return ptext;
    }

    /**
     * Returns true if the JTextField contains text, false otherwise.
     *
     * @param p1text the JTextField to check
     * @return true if the JTextField contains text, false otherwise
     */
    private boolean checkIfInputValid(JTextField p1text) {

        //TODO: Scrub input;
        return !p1text.getText().isEmpty();
    }
}