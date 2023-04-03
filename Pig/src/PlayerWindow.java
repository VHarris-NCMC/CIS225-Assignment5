import javax.swing.*;
import java.awt.*;

public class PlayerWindow extends JFrame {

public static final Dimension DEFAULT_SIZE = new Dimension(450,300);
    private static final Dimension DEFAULT_PPANEL_SIZE = new Dimension(420, 70);

    public static void setPlayersAndClose(Player p1, Player p2)
    {
        GameWindow.setPlayer1(p1);
        GameWindow.setPlayer2(p2);
        _instance_.dispose();
        _instance_ = null;


    }
    private static PlayerWindow _instance_;
    public PlayerWindow()
    {
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

        JButton submitb = new JButton("Submit");
        submitb. addActionListener(e -> {

            if (GetNameFieldText(p1text) && GetNameFieldText(p2text))
            {
                PlayerWindow.setPlayersAndClose(new Player(p1text.getText()), new Player(p2text.getText()));

            }
        });
        add(submitb);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setSize(getPreferredSize());
        this.pack();
        this.setAlwaysOnTop(true);
        this.setVisible(true);



    }

    private static JPanel GetPlayerPanel() {
        JPanel ppan = new JPanel();
        ppan.setPreferredSize(DEFAULT_PPANEL_SIZE);
        ppan.setSize(ppan.getPreferredSize());
        ppan.setBackground(Color.gray);
        return ppan;
    }

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

    private boolean GetNameFieldText(JTextField p1text) {


        //TODO: Scrub input;
        if (p1text.getText().isEmpty())
        {
            return false;
        }
        else {
            return true;
        }

    }

}
