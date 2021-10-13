package ru.alexanna.lesson_1;

import ru.alexanna.lesson_1.competitions.*;
import ru.alexanna.lesson_1.obstaclecourse.Course;
import ru.alexanna.lesson_1.obstaclecourse.Obstacle;
import ru.alexanna.lesson_1.obstaclecourse.RunningArea;
import ru.alexanna.lesson_1.obstaclecourse.Wall;

public class Main {

	public static void main(String[] args) {
		Competition competition = organizeCompetition();
		competition.start();
	}

	public static Competition organizeCompetition() {
		Competitor[] competitors = {new Man("Bill", 3000, 2), new Cat("Tomcat", 1000, 3), new Robot("Robot Fyodor", 700, 1)};

		Obstacle[] obstacles = {new RunningArea(500), new Wall(1), new RunningArea(1000), new Wall(2), new RunningArea(3000), new Wall(2)};
		Course course = new Course(obstacles);
		return new Competition(competitors, course);
	}

}
