package com.game.pig3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Die
{
private static final int NUM_OF_SIDES = 6;
private static final int DEFAULT_SIZE = 200;
private static ArrayList<Die> Dice = new ArrayList();
DieFace currentFace;
private final ArrayList<DieFace> faces = new ArrayList();
private ImageView view;
public Die(ImageView v)
{
	view = v;
	view.setVisibility(View.VISIBLE);
	Dice.add(this);
	for(int i = 0; i < 6; ++i) {
		if (this.faces != null) {
		this.faces.add(new DieFace(i));


		}
	}


	//this.setImageResource(R.drawable.die1);
	//this.showFace((DieFace)this.faces.get(0));
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


	switch(face.nValue)
	{
		case 1:
			view.setBackgroundResource(R.drawable.die1);
		break;
		case 2:
			view.setBackgroundResource(R.drawable.die2);
			break;
		case 3:
			view.setBackgroundResource(R.drawable.die3);
			break;
		case 4:
			view.setBackgroundResource(R.drawable.die4);
			break;
		case 5:
			view.setBackgroundResource(R.drawable.die5);
			break;
		case 6:
			view.setBackgroundResource(R.drawable.die6);
			break;
		default:
break;
	}



}



private class DieFace {

	String value;
	int nValue;

	public DieFace(int a)
	{
		++a;
		nValue = a;
		this.value = Integer.toString(a);
	}
}
}
