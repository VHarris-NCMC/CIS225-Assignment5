package com.game.pigandroid2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.game.pigandroid2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
public static final int NUM_OF_DICE = 2;
public static final String GAME_WINDOW_LABEL = "Pig";
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
@Override
protected void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	saveManager.LoadScores();
	instance = this;
	binding = ActivityMainBinding.inflate(getLayoutInflater());
	setContentView(binding.getRoot());
	NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
	appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
	NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
	AddDice();
	ScoreKeeper scoreKeeper = BuildScoreKeeper();
	this.setVisible(true);
}

@Override
public boolean onCreateOptionsMenu(Menu menu)
{
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_main, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item)
{
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	//noinspection SimplifiableIfStatement
	if(id == R.id.action_settings)
	{
		return true;
	}

	return super.onOptionsItemSelected(item);
}

@Override
public boolean onSupportNavigateUp()
{
	NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
	return NavigationUI.navigateUp(navController, appBarConfiguration)
			       || super.onSupportNavigateUp();
}


// TODO: add save on close
// SaveManager.Save()
//
private static void ConfigureButtonPanel(ActionBarContainer buttonPanel) {

}

private static ScoreKeeper BuildScoreKeeper() {
	ScoreKeeper scoreKeeper = new ScoreKeeper();
	SaveManager.LoadScores();
	return scoreKeeper;
}

private static void AddDice() {
	for(int i = 0; i < 2; ++i) {
		Die d = new Die();

		// TODO: Show Dice

	}

}
public static void setPlayer1(Player player) {
	player1 = player;
}

public static void setPlayer2(Player player) {
	player2 = player;
}

public static Player getPlayer1() {
	try {
		if (player1 != null) {
			return player1;
		}
	} catch (Exception var1) {
		var1.printStackTrace();
	}

	return null;
}

public static Player getPlayer2() {
	try {
		if (player2 != null) {
			return player2;
		}
	} catch (Exception var1) {
		var1.printStackTrace();
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
public void onRollButtonClick()
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