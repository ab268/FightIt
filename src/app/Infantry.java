package app;

public class Infantry extends Soldier {

	private final int MAX_HEALTH=8;
	private final int MAX_FORCE=5;
	private final double MISS=0;
	
	protected Infantry() {
		super();
		setHealth(MAX_HEALTH);
		setForce(MAX_FORCE);
		setMiss(MISS);
	}
	

}
