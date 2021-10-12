package ru.alexanna.lesson_1.obstaclecourse;

import ru.alexanna.lesson_1.competitions.Competitor;

public class RunningArea implements Obstacle {
	private int length;
	
	public RunningArea(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}
	
	public boolean overcome(Competitor competitor) {
		return competitor.run(length);
	}
}
