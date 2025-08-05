import java.util.Scanner;
import Entity.Pokemon;
import stage.Stage;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	String [] Pokemons = {"rayquaza", "jessie", "misty"};
	private Pokemon playerPokemon;
	
	public void start() {
		catchTime();
		
		// 
	}
	
	public void selectStageMenu() {
		//display list of stages available
		//then store selected stage in a variable
	}
	
	public void catchTime() {
		System.out.println("catch time! choose a pokemon to catch:");
		
		for (int i = 0; i < Pokemons.length; i++) {
			
			System.out.println((i + 1) + " " + Pokemons[i]);
			
		}
		System.out.println("GAME START");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number 1---3: ");
		int choice = scanner.nextInt();
		
		if (choice >= 1 && choice <= 3) {
			System.out.println("you caught " + Pokemons[choice - 1] + "!");
			
		}  else {
			System.out.println("invalid choice.No pokemon caught GAME OVER!");
		}
	}
	
	public void battleTime() {
		
	}
	
	public void concludeStage() {
		
	}
}
