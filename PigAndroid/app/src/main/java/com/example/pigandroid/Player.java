package com.example.pigandroid;

public class Player {
private String name;
private int score;

public String getName() {
	return this.name;
}

public Player(String name) {
	this.name = name;
}

void setScore(int score_) {
	this.score = score_;
}

public int getScore() {
	return this.score;
}

public void addPoints(int roll) {
	this.score += roll;
}
}