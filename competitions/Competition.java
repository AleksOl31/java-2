package ru.alexanna.lesson_1.competitions;

import ru.alexanna.lesson_1.obstaclecourse.Course;
import ru.alexanna.lesson_1.obstaclecourse.Obstacle;

public class Competition {

	private Competitor[] competitors;
	
	private Course course;

	private void overcome(Obstacle[] obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			for (int j = 0; j < competitors.length; j++) {
				if (competitors[j].isNotLoser())
					obstacles[i].overcome(competitors[j]);
			}
			System.out.println();
		}
	}
	
	public Competition(Competitor[] competitors, Course course) {
		this.competitors = competitors;
		this.course = course;
	}
	
	public void start() {
		overcome(course.getObstacles());
	}
}
