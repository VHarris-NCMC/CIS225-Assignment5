import java.io.*;

public class SaveManager {


    private static final String SAVE_PATH1 = "p1scores.txt";
    private static final String SAVE_PATH2 = "p2scores.txt";
    public static void save()
    {
        SaveManager.save(SAVE_PATH1, Integer.toString(GameWindow.getPlayer1().getScore()));
        SaveManager.save(SAVE_PATH2, Integer.toString(GameWindow.getPlayer2().getScore()));
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

    public static int getSavedScore(String path)
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
                GameWindow.GetPlayers();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (score == 0)
        {
            GameWindow.GetPlayers();
        }
        return score;
    }

    public static void LoadScores() {
        ScoreKeeper.setScoresfromSave(SaveManager.getSavedScore(SAVE_PATH1),SaveManager.getSavedScore(SAVE_PATH2));
    }
}
