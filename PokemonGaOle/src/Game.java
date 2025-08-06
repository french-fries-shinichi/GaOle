import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import stage.Stage;
import Entity.*;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	private Pokemon playerPokemon;
	private Stage[] stageList;
	
	// should these be local variables?
	//private Pokemon[] wildPokemons;
	
	public void Game() {
		this.battleScore = 0;
		
		Pokemon[] stageOnePokemonList = {
			new ElectricPokemon("Pikachu", 50, 7, 3, 9),
			new GrassPokemon("Bulbasaur", 72, 4, 8, 4),
			new WaterPokemon("Squirtle", 64, 7, 5, 6)
		};
		Stage pikachuStage = new Stage("Pikachu Area", stageOnePokemonList);
		
		//create second stage here
		
		//create third stage here
		
		//then finally, add all stages to "stageList" array variable
	}
	
	public void start() {
		System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
		selectStageMenu();
		
		catchTime();
		battleTime();
		concludeStage();
		// 
	}
	
	public void selectStageMenu() {
		
		System.out.println("\n\n\n");
		System.out.println("Select a stage to begin!");
		//for (int i = 0; i<5; i++) {
		//	System.out.printf("%d - %s", i, stageName);
		//}
		System.out.println("Oh no! We will just select a stage on ur behave (LMAO)");
		selectedStage = stageList[0];
	}
	
	public void catchTime() {
		Pokemon[] wildPokemons = {selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon()};
		
		System.out.println("\n\n\ncatch time! choose a pokemon to catch:");
		for (int i = 0; i < wildPokemons.length; i++) {
			System.out.printf("%d - %s", i, wildPokemons[i].getName());
		}
		
//		for (int i = 0; i < Pokemons.length; i++) {
//			
//			System.out.println((i + 1) + " " + Pokemons[i]);
//			
//		}

//		System.out.println("GAME START");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number 1---2: ");
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
			Pokemon playerPokemon = new Pokemon("eevee", 2, 5, "Lightning", "Physical", 100, 10, 30, 60);
			Pokemon enemyTarget = new Pokemon("Bulbasaur", 2, 5, "Lightning", "Special", 100, 10, 40, 67);
			System.out.printf("Types and affinity of player's pokemon is: %s and %s", playerPokemon.PokemonTypeString(),
					playerPokemon.PokemonAffinityString());
			System.out.printf("Types and affinity of enemy pokemon is: %s with %s", enemyTarget.PokemonTypeString(),
					enemyTarget.PokemonAffinityString());

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
				while (enemyTarget.healthPoints != 0 || playerPokemon.healthPoints != 0) {
					System.out.println("What would you like to do?");
					System.out.println("Attack or Defend");
					String playerDecision = input.next();
					if (playerDecision == "Attack") {
						playerPokemon.attack(enemyTarget);
						System.out.println("It was very effective!");
					} else if (playerDecision == "Defend") {
						enemyTarget.attack(playerPokemon);
					}

					if (enemyTarget.healthPoints == 0) {
						System.out.printf("%s has won!", enemyTarget);
						break;
					}

					if (playerPokemon.healthPoints == 0) {
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
