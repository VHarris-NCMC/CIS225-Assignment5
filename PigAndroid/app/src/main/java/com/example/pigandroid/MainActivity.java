package com.example.pigandroid;

import android.graphics.fonts.Font;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Dimension;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.pigandroid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
	public static final int NUM_OF_DICE = 2;
	public static final String GAME_WINDOW_LABEL = "Pig";
	public static final Dimension2 DEFAULT_WINDOW_SIZE = new Dimension2(800,500);
	private static Player player1 = new Player("Player 1");
	private static Player player2 = new Player("Player 2");
	private static Player currentPlayer;
	public static MainActivity window;


	static Button button, button2, button3;
	static TextView label;

private static ContentView buildButtonPanel() {
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
private AppBarConfiguration appBarConfiguration;
private ActivityMainBinding binding;

@Override
protected void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);

	binding = ActivityMainBinding.inflate(getLayoutInflater());
	setContentView(binding.getRoot());

	setSupportActionBar(binding.toolbar);

	NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
	appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
	NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

	SaveManager.LoadScores();
	binding.fab.setOnClickListener(new View.OnClickListener()
	{
		@Override
		public void onClick(View view)
		{
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
					.setAction("Action", null).show();
		}
	});
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
}

/**
public static void GetPlayers() {
JFrame playerEnterWindow = new PlayerWindow();
}



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





private static void ConfigureButtonPanel(JPanel buttonPanel) {
	buttonPanel.setBackground(Color.white);
	buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
}


 Build the score keeper.
 @return The score keeper.

private static ScoreKeeper BuildScoreKeeper() {
	ScoreKeeper scoreKeeper = new ScoreKeeper();
	SaveManager.LoadScores();
	return scoreKeeper;
}


 Add the dice to the game panel.

 @param gamePanel The game panel to add the dice to.

private static void AddDice(JPanel gamePanel) {
	for (int i = 0; i < NUM_OF_DICE; i++)
	{
		Die d = new Die();
		gamePanel.add(d);
		d.setMaximumSize(d.getPreferredSize());

	}
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
*/