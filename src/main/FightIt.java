package main;

import java.util.*;

import app.Battle;

public class FightIt {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true){
			
			System.out.println("Give a name for Army 1 : ");
			String army1name = input.nextLine();
			System.out.println("Give a name for Army 2 : ");
			String army2name = input.nextLine();
			if(army1name.isEmpty() || army2name.isEmpty()){
				System.out.println("You have entered an empty Army name");
				continue;
			}
			System.out.println("Enter Soldier Sequence for "+army1name); //Enter comma separated list of C(Cavalry), I(Infantry) and A(Artillery)
			String[] army1 = input.nextLine().split(",");
			System.out.println("Enter Soldier Sequence for "+army2name);
			String[] army2 = input.nextLine().split(",");
			
			Battle battle;
			try{
			battle = new Battle(army1,army2);
			battle.setArmyNames(army1name,army2name);
			}
			catch(InputMismatchException e){
				System.out.println(e.getMessage());
				continue;
			}
		
			battle.runBattle();
			
			System.out.println("Enter 1 to generate new battle. 0 to end");
		
			if(input.nextLine().equals("0")){
				input.close();
				return;
			}
		}
	}

}
