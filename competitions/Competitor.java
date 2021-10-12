package ru.alexanna.lesson_1.competitions;

public abstract class Competitor implements Runnable, Jumping {
	private String name;
	
	private int maxDistance;
	
	private int maxHeight;
	
	private boolean isLoser = false;
	
	public Competitor(String name, int maxDistance, int maxHeight) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.maxHeight = maxHeight;
	}
	
	@Override
	public boolean run(int length) {
		if (length <= maxDistance) {
			System.out.println(name + " ran a distance " + length);
			return true;
		} else {
			System.out.println(name + " didn't cover the distance of " + length);
			isLoser = true;
			return false;
		}
	}

	@Override
	public boolean jump(int height) {
		if (height <= maxHeight) {
			System.out.println(name + " overcame a height " + height);
			return true;
		} else {
			System.out.println(name + " didn't overcome the height of " + height);
			isLoser = true;
			return false;
		}
	}

	public boolean isNotLoser() {
		return !isLoser;
	}
}
