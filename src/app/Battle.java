package app;

public class Battle {
	private Army army1;
	private Army army2;
	
	
	public Battle(String[] army1, String[] army2){
		this.army1= new Army(army1);
		this.army2= new Army(army2);
	}
	
	/**
	 * runBattle method initiates and runs the battle between the two armies until either one of the Armies win, the battle is a draw
	 * or Both armies are dead.
	 * The longest standing army wins. If both armies exhaust their health, which is the attacking power of the army, then the battle
	 * is a draw.
	 * If both armies are dead, the Battle ends and there is no winner.
	 */
	public void runBattle(){
	
		Army attacker = army1;
		Army defender = army2;
		Army temp;
		while(attacker.isAlive() && defender.isAlive()){
			
			if(attacker.getHealth()==0 && defender.getHealth()==0){
				System.out.println("Both Armies have exhausted thier attacking power. This Battle is a draw");
				return;
			}
			
			if(attacker.getHealth()>0){
				attacker.attack(defender);
				System.out.println("\n\n"+attacker.getName()+ " has attacked "+defender.getName()+"\n");
				attacker.printStatus();
				defender.printStatus();
			}
			
			//swap attacker and defender
			temp=attacker;
			attacker=defender;
			defender=temp;
		}
		if(attacker.isAlive()){
			System.out.println(attacker.getName()+" has won the Battle");
		}
		else if(defender.isAlive()){
			System.out.println(defender.getName()+" has won the Battle");
		}
		else {
			System.out.println("Both Armies are dead. Battles can destroy mankind");
		}
	}

	/**
	 * Sets the names of the fighting Armies.
	 * @param army1name
	 * @param army2name
	 */
	public void setArmyNames(String army1name, String army2name) {
		army1.setName(army1name);
		army2.setName(army2name);
	}
}
