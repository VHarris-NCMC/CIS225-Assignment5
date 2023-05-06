package com.game.pig3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.Menu;
import android.view.MenuItem;
import com.game.pig3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
public static final int NUM_OF_DICE = 2;
public static final String GAME_WINDOW_LABEL = "Pig";
private static ArrayList<ImageView> DiceViews = new ArrayList<ImageView>();
private static Player player1 = new Player("Player 1");
private static Player player2 = new Player("Player 2");
private static final SaveManager saveManager = new SaveManager();
private static Player currentPlayer;
static TextView label;
private static Activity instance;
private AppBarConfiguration appBarConfiguration;
private ActivityMainBinding binding;

public static void GetPlayers() {
	new PlayerWindow();
}

public static TextView getTicker()
{
	TextView ticker = (TextView) MainActivity.instance.findViewById(R.id.tickerPanel);
	return ticker;
}

public static TextView getP1Text()
{
	return instance.findViewById(R.id.p1Text);
}
public static TextView getP2Text()
{
	return instance.findViewById(R.id.p2Text);
}

public static TextView getCurrentTurnText()
{
	return instance.findViewById(R.id.currentTurnText);
}

@Override
protected void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	saveManager.LoadScores();
	instance = this;
	binding = ActivityMainBinding.inflate(getLayoutInflater());

	setContentView(binding.getRoot());

	ScoreKeeper scoreKeeper = BuildScoreKeeper();
	this.setVisible(true);
	findViewById(R.id.rollButton).setOnClickListener(new View.OnClickListener()
	{
		@Override
		public void onClick(View view)
		{
			onRollButtonClicked();
		}
	});
	findViewById(R.id.takePointsButton).setOnClickListener(new View.OnClickListener()
	{
		@Override
		public void onClick(View view)
		{
			onTakePointsButtonClick();
		}
	});
	findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener()
	{
		@Override
		public void onClick(View view)
		{
			onResetButtonClick();
		}
	});
	DiceViews.add(findViewById(R.id.die1));
	DiceViews.add(findViewById(R.id.die2));
	DiceViews.add(findViewById(R.id.die3));
	DiceViews.add(findViewById(R.id.die4));
	DiceViews.add(findViewById(R.id.die5));
	DiceViews.add(findViewById(R.id.die6));
	DiceViews.add(findViewById(R.id.die7));
	DiceViews.add(findViewById(R.id.die8));
	DiceViews.add(findViewById(R.id.die9));
	AddDice();
}

@Override
protected void onStop()
{
	super.onStop();
	SaveManager.save();
}
private static ScoreKeeper BuildScoreKeeper() {
	ScoreKeeper scoreKeeper = new ScoreKeeper();
	SaveManager.LoadScores();
	return scoreKeeper;
}

private static void AddDice() {
	for(int i = 0; i < 2; ++i) {
		ImageView view = (AppCompatImageView) DiceViews.get(i);
		Die d = new Die(view);


	}

}
public static void setPlayer1(Player player) {
	player1 = player;
}

public static void setPlayer2(Player player) {
	player2 = player;
}

public static Player getPlayer(int pNumber)
{
	Player player;

	switch(pNumber)
	{
		case 1:
			try {
				if (player1 != null) {
					return player1;
				}
			} catch (Exception var1) {
				var1.printStackTrace();
			}
			break;
		case 2:
			try {
				if (player2 != null) {
					return player2;
				}
			} catch (Exception var1) {
				var1.printStackTrace();
			}
			break;
		default:
			//TODO: Add Debug
			break;
	}
	return null;
}
public static void switchCurrentPlayer() {
	if (currentPlayer == null) {
		currentPlayer = player1;
	} else {
		currentPlayer = currentPlayer == player1 ? player2 : player1;
	}
}

public static Player getCurrentPlayer() {
	if (currentPlayer == null) {
		currentPlayer = player1;
	}

	return currentPlayer;
}
public void onRollButtonClicked()
{
	Die.rollDice();
}
public void onTakePointsButtonClick()
{
	ScoreKeeper.endRun(true);
}
public void onResetButtonClick()
{
	ScoreKeeper.reset();
}
}