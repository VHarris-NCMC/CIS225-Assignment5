import javax.swing.*;
import java.awt.*;

public class ScoreKeeper extends JPanel
{
    public static final Dimension TEXT_SIZE_DEFAULT = new Dimension(400, 55);
    public static final Dimension TEXT_PANEL_SIZE_DEFAULT = new Dimension(800, 65);
    public static String score_string;

    private static int currentTurnScore;
    private static JTextArea currentTurnText;

    /**
     *
     * @param i input used to set score of player
     */

    private static JTextArea p1text;
    private static JTextArea p2text;
    public ScoreKeeper()
    {
        super();
        JPanel tickerPanel = new JPanel();
        tickerPanel.setBackground(Color.DARK_GRAY);
        this.add(tickerPanel);
        tickerPanel.setPreferredSize(TEXT_PANEL_SIZE_DEFAULT);
        tickerPanel.setSize(getPreferredSize());

        setBackground(Color.gray);
        currentTurnScore = 0;

        p1text = new JTextArea();
        p1text.setMinimumSize(TEXT_SIZE_DEFAULT);
        p1text.setFont(GameWindow.DEFAULT_FONT);
        p1text.isVisible();
        p1text.setSize(TEXT_SIZE_DEFAULT);

        p2text = new JTextArea();
        p2text.setFont(GameWindow.DEFAULT_FONT);
        p2text.isVisible();
        p2text.setMinimumSize(TEXT_SIZE_DEFAULT);
        p2text.setSize(TEXT_SIZE_DEFAULT);

        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.white);
        this.add(scorePanel);
        scorePanel.setPreferredSize(TEXT_PANEL_SIZE_DEFAULT);
        scorePanel.setSize(getPreferredSize());
        scorePanel.add(p1text);
        scorePanel.add(p2text);

        currentTurnText = new JTextArea();
        currentTurnText.setFont(GameWindow.DEFAULT_FONT);
        currentTurnText.isVisible();
        currentTurnText.setMinimumSize(TEXT_SIZE_DEFAULT);


        tickerPanel.add(currentTurnText);
        updateScoresText();
    }

    public static void reset() {
        resetScores();
        updateScoresText();
        SaveManager.save();
        PlayerWindow p = new PlayerWindow();
    }
    private static void resetScores()
    {
        setCurrentTurnScore(0);
        GameWindow.getPlayer1().setScore(0);
        GameWindow.getPlayer2().setScore(0);

    }

    private static void updateScoresText()
    {

        if (GameWindow.getCurrentPlayer()!= null)
        {
            currentTurnText.setText("Current player: " +GameWindow.getCurrentPlayer().getName() + "       Current Turn Points: "+ currentTurnScore);

        }else
        {
            currentTurnText.setText(Integer.toString(currentTurnScore));
        }
        if (GameWindow.getPlayer1() != null) {
            p1text.setText(GameWindow.getPlayer1().getName() + ": "+ GameWindow.getPlayer1().getScore());
            if (GameWindow.getCurrentPlayer() == GameWindow.getPlayer1())
            {
                p1text.setBackground(Color.orange);
            }else {
                p1text.setBackground(Color.white);
            }
        }
        if (GameWindow.getPlayer2() != null){
            p2text.setText(GameWindow.getPlayer2().getName() + ": "+ GameWindow.getPlayer2().getScore());
            if (GameWindow.getCurrentPlayer() == GameWindow.getPlayer2())
            {
                p2text.setBackground(Color.orange);
            }else {
                p2text.setBackground(Color.white);
            }
        }
    }
    public static void setTextWithString(String s)
    {
        currentTurnText.setText(s);
    }

    public static void setCurrentTurnScore(int currentTurnScore)
    {
        ScoreKeeper.currentTurnScore = currentTurnScore;
    }

    public static void setScoresfromSave(int savedScore1, int savedScore2) {

        GameWindow.getPlayer1().setScore(savedScore1);
        GameWindow.getPlayer2().setScore(savedScore2);
        updateScoresText();
    }

    public static void addToCurrentScore(int rolledValueSum) {
        currentTurnScore+= rolledValueSum;
        updateScoresText();
    }


    public static void endRun(boolean keepPoints) {

        if (keepPoints)
        {
            Player player = GameWindow.getCurrentPlayer();

            player.addPoints(currentTurnScore);
            if(player.getScore()>=100)
            {
                reset();
                setTextWithString(player.getName() + " WINS");
            }
            currentTurnScore = 0;
            updateScoresText();
        }
        else{
            currentTurnScore = 0;
            updateScoresText();
            setTextWithString(GameWindow.getCurrentPlayer().getName() + " Rolled a 1! :( ");

        }
        SaveManager.save();
        GameWindow.switchCurrentPlayer();
    }
}
