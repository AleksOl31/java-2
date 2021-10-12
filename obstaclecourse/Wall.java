package ru.alexanna.lesson_1.obstaclecourse;

import ru.alexanna.lesson_1.competitions.Competitor;

public class Wall implements Obstacle {
	private int height;
	
	public Wall(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean overcome(Competitor competitor) {
		return competitor.jump(height);
	}
}
