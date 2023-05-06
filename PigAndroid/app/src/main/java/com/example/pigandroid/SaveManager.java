package com.example.pigandroid;

import java.io.*;

public class SaveManager {
private static final String SAVE_PATH1 = "p1scores.txt";
private static final String SAVE_PATH2 = "p2scores.txt";

public SaveManager() {
}

public static void save() {
	save("p1scores.txt", Integer.toString(MainActivity.getPlayer1().getScore()));
	save("p2scores.txt", Integer.toString(MainActivity.getPlayer2().getScore()));
}

public static void save(String Path, String score) {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path, false));
		File file = new File(Path);
		if (!file.exists()) {
			file.createNewFile();
		}

		writer.write(score);
		writer.close();
	} catch (IOException var4) {
		var4.printStackTrace();
	}

}

public static int getSavedScore(String path) {
	int score = 0;

	try {
		File file = new File(path);
		if (file.exists()) {
			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);
			score = Integer.parseInt(br.readLine());
			br.close();
		} else {
			GameWindow.GetPlayers();
		}
	} catch (IOException var5) {
		var5.printStackTrace();
	}

	if (score == 0) {
		GameWindow.GetPlayers();
	}

	return score;
}

public static void LoadScores() {
	ScoreKeeper.setScoresfromSave(getSavedScore("p1scores.txt"), getSavedScore("p2scores.txt"));
}
}