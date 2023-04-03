public class Player
{
    private String name;
    public String getName()
    {
        return name;
    }
    private int score;

    public Player(String name)
    {
        this.name = name;
    }
    void setScore(int score_)
    {
        score = score_;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int roll) {
        score+=roll;
    }


}
