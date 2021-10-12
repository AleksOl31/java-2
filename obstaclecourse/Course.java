package ru.alexanna.lesson_1.obstaclecourse;

public class Course {
	private Obstacle[] obstacles;

	public Course(Obstacle[] obstacles) {
		this.setObstacles(obstacles);
	}

	public Obstacle[] getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

}
