import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Die extends JPanel {

    private char character;
    private int size;
    private static final int NUM_OF_SIDES = 6;
    private static final int DEFAULT_SIZE = 200;

    /**
     * CONSTANT EXPRESSION
     * @return returns size relative itself
     *
     */
    public  int DEFAULT_FACE_SIZE(){return Math.round(getSize().height * 0.9f);}
    private static ArrayList<Die> Dice = new ArrayList<>();
    private DieFace currentFace;
    private final ArrayList<DieFace> faces = new ArrayList<>();

    public Die()
    {

        setBackground(Color.white);
        setPreferredSize(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
        setMaximumSize(getPreferredSize());
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        Dice.add(this);

        // Generate Faces

        for (int i = 0; i < NUM_OF_SIDES; i++)
        {
            if (faces != null )
            {
                faces.add(new DieFace(i, DEFAULT_FACE_SIZE()));
            }
        }
        showFace(faces.get(0));

    }

    public static void rollDice() {

        int rolledValueSum = 0;
        for (Die d : Dice)
        {
            int roll = d.roll();
            if (roll != 1) {
                rolledValueSum += roll;
            } else{
                ScoreKeeper.endRun(false);
                return;

                }
        }
        ScoreKeeper.addToCurrentScore(rolledValueSum);


    }

    private int roll()
    {
        Random rand = new Random();
        int rolled = rand.nextInt(NUM_OF_SIDES) + 1;

        showFace(faces.get(rolled-1));
        return rolled;
    }



    private void showFace(DieFace face)
    {
        if (currentFace != null)
        {
            this.remove(currentFace);


        }

        this.currentFace = face;
        this.add(face);
        updateUI();
    }





        private class DieFace  extends JTextArea {

            String value;

            public DieFace(int a, int size)
            {
                a++;
                this.value = Integer.toString(a);

                setSize(getPreferredSize());
                setBackground(Color.white);
                setFont(GameWindow.DEFAULT_FONT);
                setText(value);


            }


    }

}
