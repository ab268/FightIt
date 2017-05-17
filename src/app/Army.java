package app;

import java.util.*;

public class Army {
	private List<Soldier> soldiers ;
	private String name;
	
	protected Army(String[] soldiers){
		this.soldiers = new LinkedList<Soldier>();
		
		for(String soldier : soldiers){
			if(soldier.equals("C")){
				this.soldiers.add(new Cavalry());
			}
			else if(soldier.equals("I")){
				this.soldiers.add(new Infantry());
			}
			else if(soldier.equals("A")){
				this.soldiers.add(new Artillery());
			}
			else{
				throw new InputMismatchException( "Your input should be comma seperated list of characters containing : C,I and/or A");
			}
		}
	}
	
	/**
	 * Method to check if the Army is alive
	 * @return Returns true if there is any alive soldier left in the Army. 
	 */
	protected boolean isAlive(){
		if(soldiers.size()>0){
			return true;
		}
		return false;
	}

	/**
	 * Method to define the attack by attacking army on the defender army. Every soldier in the attacking army's list attacks the 
	 * sequentially corresponding soldier in defending army's list. If an attacking soldier does not have positive health points, 
	 * the next sequentially available soldier would attack the defender soldier. If no soldier has health points available,
	 * the attacking army passes on the attack.
	 * @param defender
	 */
	protected void attack(Army defender) {
		Iterator<Soldier> attackerItr = soldiers.iterator();
		Iterator<Soldier> defenderItr = defender.soldiers.iterator();
		Soldier defenderTemp, attackerTemp;
		while(attackerItr.hasNext() && defenderItr.hasNext()){
			defenderTemp=defenderItr.next();
			attackerTemp=attackerItr.next();
			
			while(attackerTemp.getHealth()<=0 && attackerItr.hasNext()){
				attackerTemp=attackerItr.next();
			}
			if(attackerTemp.getHealth()>0){
				attackerTemp.attack(defenderTemp);
			}
		}
		defender.cleanup();
		
	}
	
	/**
	 * cleanup method is used to remove the dead soldiers from the active army list.
	 */
	private void cleanup(){
		Iterator<Soldier> itr = soldiers.iterator();
		while(itr.hasNext()){
			if(!itr.next().isAlive()){
				itr.remove();
			}
		}
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * printStatus method would print the sequential list of currently alive soldiers. It prints the soldier type, health and force.
	 */
	protected void printStatus() {
		System.out.print(getName()+": ");
		for(Soldier soldier : soldiers){
			System.out.print("|"+soldier.getClass().getSimpleName()+"("+soldier.getHealth()+", "+soldier.getForce()+")|");
		}
		System.out.println();
		
	}
	
	/**
	 * getHealth method counts the army's cumulative health as the sum of health of all the alive soldiers
	 * @return The cumulative health of the army
	 */
	protected int getHealth() {
		int health=0;
		for(Soldier soldier : soldiers){
			health=health+soldier.getHealth();
		}
		
		return health;
	}
	
	
}
