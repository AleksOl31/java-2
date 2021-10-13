package ru.alexanna.lesson_1.obstaclecourse;

import ru.alexanna.lesson_1.competitions.Sportsman;

public class Wall implements Obstacle {
	private int height;
	
	public Wall(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean overcome(Sportsman sportsman) {
		return sportsman.jump(height);
	}
}
