package app;

public class Cavalry extends Soldier {

	private final int MAX_HEALTH=7;
	private final int MAX_FORCE=7;
	private final double MISS=0.2;
	
	protected Cavalry() {
		super();
		setHealth(MAX_HEALTH);
		setForce(MAX_FORCE);
		setMiss(MISS);
	}
	
}
