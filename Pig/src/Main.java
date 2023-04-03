/**

 The GameWindow class extends the JFrame class and creates the main window for the Pig game.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 /**

 The GameWindow class extends the JFrame class and creates the main window for the Pig game.
 */
class GameWindow extends JFrame {

    public static final int NUM_OF_DICE = 2;
    public static final String GAME_WINDOW_LABEL = "Pig";
    public static final Font DEFAULT_FONT = new Font(Font.SANS_SERIF, 0, 28);
    public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 500);

    private static Player player1 = new Player("Player 1");
    private static Player player2 = new Player("Player 2");
    private static Player currentPlayer;
    private static GameWindow window;
    static JButton button, button2, button3;
    static JLabel label;

    /**

     The listener to load scores when the window is opened and save them when the window is closed.
     */
    public WindowListener listener = new WindowAdapter() {

        @Override
        public void windowOpened(WindowEvent e) {
            super.windowOpened(e);
            SaveManager.LoadScores();

        }

        /**

         Save the game score when the window is closed.
         */
        public void windowCloser(WindowEvent e){
            super.windowOpened(e);
            SaveManager.save();
        }
    };
    /**

     Open the window to get the player's names.
     */
    public static void GetPlayers() {
        JFrame playerEnterWindow = new PlayerWindow();
    }
    /**

     Constructor for the GameWindow class.

     @param s The title of the window.
     */
    public GameWindow(String s) {

        window = this;
        addWindowListener(window.listener);
        JPanel buttonPanel = buildButtonPanel();

// Create Middle panel for display the game dice
        JPanel gamePanel = new JPanel();
        gamePanel.add(Box.createVerticalGlue());

// Add as many dice as needed.
        AddDice(gamePanel);

// Configure Score Keeper
        ScoreKeeper scoreKeeper = BuildScoreKeeper();

// Configure Button Panel
        ConfigureButtonPanel(buttonPanel);

        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(buttonPanel);
        window.getContentPane().add(gamePanel);
        window.getContentPane().add(scoreKeeper);
        window.pack();
        window.setSize(DEFAULT_WINDOW_SIZE);

        window.setVisible(true);
    }

    /**

     Configure the button panel.
     @param buttonPanel The button panel to configure.
     */
    private static void ConfigureButtonPanel(JPanel buttonPanel) {
        buttonPanel.setBackground(Color.white);
        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
    }
    /**

     Build the score keeper.
     @return The score keeper.
     */
    private static ScoreKeeper BuildScoreKeeper() {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        SaveManager.LoadScores();
        return scoreKeeper;
    }
    /**

     Add the dice to the game panel.

     @param gamePanel The game panel to add the dice to.
     */
    private static void AddDice(JPanel gamePanel) {
        for (int i = 0; i < NUM_OF_DICE; i++)
        {
            Die d = new Die();
            gamePanel.add(d);
            d.setMaximumSize(d.getPreferredSize());

        }
    }

    /**

     The main method to instantiate the GameWindow.
     @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        // Instantiate Main Window
        window = new GameWindow(GAME_WINDOW_LABEL);
    }
    private static JPanel buildButtonPanel() {
        // Instantiate Buttons
        button = new RollButton("Roll");
        button3 = new TakePointsButton("Take Points");
        button2 = new ResetButton("Reset");

        // Create the panel that the buttons will be added to
        JPanel buttonPanel = new JPanel();

        // Add buttons to panel
        buttonPanel.add(button);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        return buttonPanel;
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

    public static void switchCurrentPlayer() {

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