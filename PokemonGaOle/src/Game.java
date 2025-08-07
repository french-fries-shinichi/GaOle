import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

import stage.Stage;
import Entity.*;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	private Pokemon playerPokemon;
	private Stage[] stageList;
	private Pokemon[] Pokemons;
	
	// should these be local variables?
	//private Pokemon[] wildPokemons;
	
	public void Game() {
		this.battleScore = 0;
		
		Pokemon[] stageOnePokemonList = {
			new ElectricPokemon("Pikachu", 50, 7, "Thunderbolt", "Electric", 100, 9, 5, 8),
			new GrassPokemon("Bulbasaur", 72, 4, "Vine Whip", "Grass", 100, 4, 6, 5),
			new WaterPokemon("Squirtle", 64, 7, "Water Gun", "Water", 100, 6, 5, 7)
		};
		Stage pikachuStage = new Stage("Pikachu Area", stageOnePokemonList);
		
		//create second stage here
		Stage bulbasaurStage = new Stage("Bulbasaur Area", stageOnePokemonList);
		
		//create third stage here
		Stage squirtleStage = new Stage("Squirtle Area", stageOnePokemonList);
		
		//then finally, add all stages to "stageList" array variable
		stageList = new Stage[] {pikachuStage, bulbasaurStage, squirtleStage};
		
		// create a list of Pokemons
		Pokemons = new Pokemon[] {
			new FirePokemon("Charmander", 4, 5, "Ember", "Fire", 100, 10, 5, 6),
			new WaterPokemon("Squirtle", 7, 5, "Water Gun", "Water", 100, 8, 6, 7),
			new GrassPokemon("Bulbasaur", 1, 5, "Vine Whip", "Grass", 100, 9, 4, 5),
			new ElectricPokemon("Pikachu", 25, 5, "Thunderbolt", "Electric", 100, 11, 3, 8),
			new FirePokemon("Vulpix", 37, 5, "Fire Spin", "Fire", 100, 9, 4, 6),
			new WaterPokemon("Psyduck", 54, 5, "Water Pulse", "Water", 100, 7, 5, 6),
			new GrassPokemon("Oddish", 43, 5, "Razor Leaf", "Grass", 100, 8, 4, 5),
			new ElectricPokemon("Magnemite", 81, 5, "Thunder Shock", "Electric", 100, 10, 3, 7)
		};
	}
	
	public void start() {
		System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
		
		Game();
		selectStageMenu();
		
		catchTime();
		battleTime();
		concludeStage();
		// 
	}
	
	public void selectStageMenu() {
		
		System.out.println("\n\n");
    	System.out.println("Select a stage to begin!\n");
    	for (int i = 0; i < stageList.length; i++) {
        	System.out.printf("%d - %s\n", i + 1, stageList[i].getStageName());
    	}
		System.out.println();
    	Scanner scanner = new Scanner(System.in);
    	int stageChoice = scanner.nextInt() - 1; // subtract 1 to convert to 0-based index
    	selectedStage = stageList[stageChoice];
	
	}
	
	public void catchTime() {
		Pokemon[] wildPokemons = {selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon()};

		if (wildPokemons != null) {
        	for (int i = 0; i < wildPokemons.length; i++) {
            	if (wildPokemons[i] != null) {
                	System.out.printf("%d - %s", i, wildPokemons[i].getName());
            	} else {
                	System.out.println("Error: null Pokemon object");
            	}
        	}
    	}

		System.out.println("\n\ncatch time! choose a pokemon to catch:\n");
		for (int i = 0; i < wildPokemons.length; i++) {
			System.out.printf("%d - %s\n", i, wildPokemons[i].getName());
		}
		
//		for (int i = 0; i < Pokemons.length; i++) {
//			
//			System.out.println((i + 1) + " " + Pokemons[i]);
//			
//		}

//		System.out.println("GAME START");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter Number 1---2: ");
		int choice = scanner.nextInt();
		
		//salvage this maybe?
//		if (choice >= 1 && choice <= 3) {
//			System.out.println("you caught " + Pokemons[choice - 1] + "!");
//			
//		}  else {
//			System.out.println("invalid choice.No pokemon caught GAME OVER!");
//		}
		
		
	}
	
	// Executed when is time to battle pokemon
		public void battleTime() {
			/*
			 * Pokemon(String name, int collectionNumber, int pokemonPE, String pokemonType,
			 * String moveType, int healthPoints, int attack, int defense, int speed)
			 */

			// Set the stage for the two Pokemons and display their types and affinities
			Pokemon playerPokemon = new Pokemon("eevee", 2, 5, "Bite", "Normal", 100, 10, 30, 60);
			Pokemon enemyTarget = new Pokemon("Bulbasaur", 2, 5, "Vine Whip", "Grass", 100, 10, 40, 67);
			System.out.printf("Types and affinity of player's pokemon is: %s and %s", playerPokemon.getMoveType(),
					playerPokemon.getPokemonType());
			System.out.printf("Types and affinity of enemy pokemon is: %s with %s", enemyTarget.getMoveType(),
					enemyTarget.getPokemonType());

			// Player sends in the pokemon of their choice
			Scanner input = new Scanner(System.in);
			System.out.println("Which pokemon would you like to send? (Enter '0' to quit)");
			int sentPokemon;
			sentPokemon = input.nextInt();
			for (Pokemon a : Pokemons) {
				if (a.equals(sentPokemon)) {
					System.out.printf("Sending %s in...", sentPokemon);
				}
			}

			// Battle logic : as player sends pokemon...
			while (sentPokemon != 0) {
				while (enemyTarget.getHealthPoints() != 0 || playerPokemon.getHealthPoints() != 0) {
					System.out.println("What would you like to do?");
					System.out.println("Attack or Defend");
					String playerDecision = input.next();
					if (playerDecision == "Attack") {
						playerPokemon.attack(enemyTarget);
						System.out.println("It was very effective!");
					} else if (playerDecision == "Defend") {
						enemyTarget.attack(playerPokemon);
					}

					if (enemyTarget.getHealthPoints() == 0) {
						System.out.printf("%s has won!", enemyTarget);
						break;
					}

					if (playerPokemon.getHealthPoints() == 0) {
						System.out.printf("%s has won!", playerPokemon);
						break;
					}
				}
			}

			// Prompt a 50% chance for an extra battle
			Random random = new Random();
			double randomChance = random.nextDouble();
			if (randomChance >= 0.0 && randomChance <= 0.5) {
				extraBattle(); // depart for extra battle
			} else {
				concludeStage(); // 50% to conclude the stage
			}

			// Battle Time!:
			// generate two wild pokemon, then display their type and affinities
			// with the departForBattle method, then ask player which one of their
			// pokemon would they like to send.
			// (this section is handled by the departForBattle() method)

		}

		public void extraBattle() {
			// Do something here...
			concludeStage(); // will eventually do something and conclude the stage
		}
	
	public void concludeStage() {
		// calculate battle score
		System.out.println("You scored: 100 battle points!");
		
		// test if file exists
		File leaderboardFile = new File("leaderboard.txt");
		if (leaderboardFile.exists()) {
			System.out.println("Opening leaderboard file...");
		} else {
			System.out.println("Looks like file doesn't exist...");
			System.out.println("Attempting to create a leaderboard file");
		}
		
		// read from file and parse it into a 5-items long array
		
		// store in a leaderboard file
		try {
			FileWriter leaderboardWriter = new FileWriter("filename.txt");
			leaderboardWriter.write(String.format("%d", battleScore));
			leaderboardWriter.close();
		} catch (IOException e) {
			System.out.println("An error has occured related to the file!");
			e.printStackTrace();
		}
		
		// display the results
		//print the leaderboard here!
	}
}
