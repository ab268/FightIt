package app;

import java.util.*;

public abstract class Soldier {
	/**
	 * health variable holds the points that a Soldier can use for attacking. Soldier can still be alive if their health reduces to 0
	 */
	private int health;
	/**
	 * force variable holds the points that a Soldier can use for defending. If force<=0, the soldier is dead.
	 */
	private int force;
	/**
	 * isAlive variable is true if the force>0
	 */
	private boolean isAlive;
	/**
	 * chance variable holds the chance of the soldier for a successful attack. 
	 * rndHealth variable randomly uses 50% or more of remaining health points of the soldier for an attack.
	 */
	private Random chance,rndHealth;
	/**
	 * miss variable contains the percent of times a soldier can miss the attack. The miss variable will have value between 0.0 to 1.0
	 */
	private double miss;

	protected Soldier(){
		isAlive=true;
		chance = new Random();
	}

	/*
	 * This method defines the attack this soldier will make on the target soldier. Probability of a successful attack is (1-miss).
	 * The attackpoints used will be 50% or more, at random, of the Soldier's leftover health points.
	 */
	protected void attack(Soldier soldier) {
		rndHealth=new Random();
		if(chance.nextDouble()>getMiss()){
			
			int attackPoints=rndHealth.nextInt((getHealth()/2)+(getHealth()%2))+(getHealth()/2)+(getHealth()%2);
			//update defenders force points
			soldier.setForce(soldier.getForce()-attackPoints);
			if(soldier.getForce()<=0){
				soldier.setAlive(false);
			}
			//update attackers health points
			setHealth(getHealth()-attackPoints);
		}
		
	}
	
	protected int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	protected int getForce() {
		return force;
	}

	protected void setForce(int force) {
		this.force = force;
	}

	protected boolean isAlive() {
		return isAlive;
	}

	protected void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected double getMiss() {
		return miss;
	}

	protected void setMiss(double miss) {
		this.miss = miss;
	}
	
	
	
}
