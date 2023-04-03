
// Importing required classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


// Helper class extending JFrame class
class GameWindow extends JFrame {

    public static final int NUM_OF_DICE = 2;
    public static final String GAME_WINDOW_LABEL = "Pig";
    public static final Font DEFAULT_FONT = new Font(Font.SANS_SERIF, 0, 28);
    public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 500);
    private static final String SAVE_PATH1 = "p1scores.txt";
    private static final String SAVE_PATH2 = "p2scores.txt";

    private static Player player1 = new Player("Player 1");
    private static Player player2 = new Player("Player 2");
    private static Player currentPlayer;


    static GameWindow window;
    static JButton button, button2, button3;
    static JLabel label;

    public WindowListener listener = new WindowAdapter() {

        @Override
        public void windowOpened(WindowEvent e) {
            super.windowOpened(e);
            ScoreKeeper.setScoresfromSave(GameWindow.getSavedScore(SAVE_PATH1),GameWindow.getSavedScore(SAVE_PATH2));

        }
        public void windowCloser(WindowEvent e){
            super.windowOpened(e);
            GameWindow.save(Integer.toString(player1.getScore()), SAVE_PATH1);
            GameWindow.save(Integer.toString(player1.getScore()), SAVE_PATH2);
        }
    };
    public static void save()
    {
        save(SAVE_PATH1, Integer.toString(player1.getScore()));
        save(SAVE_PATH2, Integer.toString(player2.getScore()));
    }
    public static void save(String Path, String score){


        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(Path, false));
            File file = new File(Path);
            if(!file.exists())
            {
                file.createNewFile();
            }
            writer.write(score);
            writer.close();

        }catch (IOException e){
                e.printStackTrace();
            }


    }
    private static int getSavedScore(String path)
    {
        int score = 0;
        try {
            File file = new File(path);
            if (file.exists()) {
                FileReader fr = new FileReader(file.getAbsoluteFile());
                BufferedReader br = new BufferedReader(fr);

                score = Integer.parseInt(br.readLine());

                br.close();

            }
            else{
                GetPlayers();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (score == 0)
        {
            GetPlayers();
        }
        return score;
    }

    private static void GetPlayers() {


        JFrame playerEnterWindow = new PlayerWindow();


    }

    public GameWindow(String s) {

    }

    // Main class
    public static void main(String[] args)
    {
        // Instantiate Components
        if (player1 == null || player2 == null)
        {
            PlayerWindow p = new PlayerWindow();
        }


        window = new GameWindow(GAME_WINDOW_LABEL);
        window.addWindowListener(window.listener);
        label = new JLabel();

        button = new RollButton("Roll");
        button3 = new TakePointsButton("Take Points");
        button2 = new ResetButton("Reset");

        JPanel buttonPanel = new JPanel();

        //Construct GameWindow

        buttonPanel.add(button);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(label);

        JPanel gamePanel = new JPanel();
        gamePanel.add(Box.createVerticalGlue());
        for (int i = 0; i < NUM_OF_DICE; i++)
        {
            Die d = new Die();
            gamePanel.add(d);
            d.setMaximumSize(d.getPreferredSize());

        }
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        ScoreKeeper.setScoresfromSave(getSavedScore(SAVE_PATH1), getSavedScore(SAVE_PATH2));






        buttonPanel.setBackground(Color.white);
        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());



        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(buttonPanel);
        window.getContentPane().add(gamePanel);
        window.getContentPane().add(scoreKeeper);
        window.pack();
        window.setSize(DEFAULT_WINDOW_SIZE);

        window.setVisible(true);
    }


    public static void setPlayer1(Player player1) {
        GameWindow.player1 = player1;
    }
    public static void setPlayer2(Player player2) {
        GameWindow.player2 = player2;
    }


    public static Player getPlayer1() {
        try{

            if (player1 != null) {
                return player1;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    return null;



    }
    public static Player getPlayer2() {
        try{

            if (player2 != null) {
                return player2;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void SWITCHPLAYERS() {

        if (currentPlayer == null)
        {
            currentPlayer = player1;
            return;
        }
        currentPlayer = (currentPlayer== player1) ? player2 : player1;
    }

    public static Player getCurrentPlayer() {
        if(currentPlayer == null)
        {
            currentPlayer = player1;
        }
        return currentPlayer;
    }
}