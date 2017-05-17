package app;

public class Artillery extends Soldier {

	private final int MAX_HEALTH=10;
	private final int MAX_FORCE=4;
	private final double MISS=0.3;
	
	protected Artillery() {
		super();
		setHealth(MAX_HEALTH);
		setForce(MAX_FORCE);
		setMiss(MISS);
	}
	

}
