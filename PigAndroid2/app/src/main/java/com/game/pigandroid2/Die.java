package com.game.pigandroid2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Die {
private static final int NUM_OF_SIDES = 6;
private static final int DEFAULT_SIZE = 200;
private static ArrayList<Die> Dice = new ArrayList();
private DieFace currentFace;
private final ArrayList<DieFace> faces = new ArrayList();
public Die() {

	Dice.add(this);

	for(int i = 0; i < 6; ++i) {
		if (this.faces != null) {
			this.faces.add(new DieFace(i));
		}
	}

	this.showFace((DieFace)this.faces.get(0));
}

public static void rollDice() {
	int rolledValueSum = 0;

	int roll;
	for(Iterator var1 = Dice.iterator(); var1.hasNext(); rolledValueSum += roll) {
		Die d = (Die)var1.next();
		roll = d.roll();
		if (roll == 1) {
			ScoreKeeper.endRun(false);
			return;
		}
	}

	ScoreKeeper.addToCurrentScore(rolledValueSum);
}

private int roll() {
	Random rand = new Random();
	int rolled = rand.nextInt(6) + 1;
	this.showFace((DieFace)this.faces.get(rolled - 1));
	return rolled;
}

private void showFace(DieFace face) {
	if (this.currentFace != null) {
		this.remove(this.currentFace);
	}

	this.currentFace = face;
	this.add(face);
	this.updateUI();
}

private void remove(DieFace currentFace)
{
	//TODO: implement
}

private void add(DieFace face)
{
	//TODO: implement

}

private void updateUI()
{
	//TODO: implement

}

private class DieFace {
	String value;

	public DieFace(int a) {
		++a;
		this.value = Integer.toString(a);

	}
}
}
