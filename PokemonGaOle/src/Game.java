import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import stage.Stage;
import Entity.*;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	private Pokemon[] playerPokemons;
	private ArrayList<Stage> stageList = new ArrayList<Stage>();
	
	// should these be local variables?
	//private Pokemon[] wildPokemons;
	
	public Game() {
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
		stageList.add(pikachuStage);
		System.out.printf("%s", stageList.getFirst());
	}
	
	public void start() {
		System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
		selectStageMenu();
		
		catchTime();
		battleTime();
		concludeStage();
		// 
	}
	
	// Initializes the stage logic and dialogue
		public void initiateStage() {
			int num;
			int credits;
			int count = 1;
			int Continue;
			boolean startStage = true;
			boolean isPokemonStage = true;
			String proceed = "";

			// All logic of connecting stages will go in here
			// basically before triggering catchTime

			Scanner input = new Scanner(System.in);

			// Stage start
			while (startStage) {
				try {
					System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
					System.out.println("You will need 8 coins to start the game\n");
					System.out.print("Enter '1' to insert credits: ");
					credits = input.nextInt();

					if (credits != 1) {
						System.out.println("You must enter '1' to insert a coin.\n");
						continue;
					}

					while (count < 9) {
						System.out.printf("You have inserted %s coins! ", count);
						System.out.println("Enter STOP to end game");
						System.out.print("Would you like to continue? (Enter '1'): ");
						Continue = input.nextInt();

						if (Continue != 1) {
							System.out.println("You must enter '1' to continue.");
							continue;
						}

						System.out.println("");
						if (Continue == 1) {
							if (count == 7) {
								startStage = false;
								break;
							}
						}
						count++;
					}

					if (!startStage) {
						System.out.print("You have inserted 8 coins!\n");
						System.out.println("Thank you. Get ready for Battle and Catch, good luck!\n");
						break;
					}

					break;

				} catch (InputMismatchException e) {
					System.out.println("Input does not match your intended action! Please try again.\n");
					input.nextLine();
				} catch (Exception e) {
					System.out.println("An error occured. Please try again.\n");
					input.nextLine();
				}
			} // end while

			// During catch time...
			while (isPokemonStage) {
				try {
					System.out.print("Would you like to proceed to catch time? (1 for YES/ 0 for NO): ");
					num = input.nextInt();
					System.out.println("");

					// CatchTime trigger
					while (num != 0) {
						boolean isLimit = false;
						if (num == 1) {
							Game initiate = new Game();
							initiate.start(); // Starts catch time
							break;
						} else {
							isLimit = false;
						} // end input check

						if (isLimit == false) {
							System.out.print("Please enter a valid number from 1-3!: ");
							num = input.nextInt();
							if (num == 1) {
								Game initiate = new Game();
								initiate.start(); // Starts catch time
								isLimit = false;
								break;
							}
						} // end retry variable
					} // end while num

					if (num == 0) {
						System.out.print("Are you sure you want to skip? Enter \"YES\" to proceed: ");
						proceed = input.next();
						if (proceed.equals("YES")) {
							System.out.println("Catch Time skipped! Proceeding to battle time...\n");
						} else if (proceed.matches("\\d+")) { // Check if 'proceed' contains only digits (a number)
							System.out.println(
									"Error: Invalid input! You cannot enter a number. Please enter \"YES\" to proceed.");
						} else {
							throw new IllegalArgumentException("");
						}
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Input does not match your intended action! Please try again.\n");
					input.nextLine();
				} catch (Exception e) {
					System.out.println("An error occured. Please try again.\n");
					input.nextLine();
				}
			} // end while

			// During battle time

			// During conclude stage
		}
	
	public void selectStageMenu() {
		
		System.out.println("\n\n\n");
		System.out.println("Select a stage to begin!");
		//for (int i = 0; i<5; i++) {
		//	System.out.printf("%d - %s", i, stageName);
		//}
		System.out.println("Oh no! We will just select a stage on ur behave (LMAO)");
		selectedStage = stageList.get(0);
	}
	
	public void catchTime() {
		Pokemon[] wildPokemons = {selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon()};
		
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
		System.out.println("Enter Number 1---3: ");
		int choice = scanner.nextInt();
		
		//salvage this maybe?
		if (choice >= 1 && choice <= 3) {
			System.out.println("you caught " +wildPokemons[choice - 1] + "!");
		}  else {
			System.out.println("invalid choice.No pokemon caught GAME OVER!");
		}
		
		
	}
	
	// Executed when is time to battle pokemon
	public void battleTime() {
		/*
		 * Pokemon(String name, int collectionNumber, int pokemonPE, String pokemonType,
		 * String moveType, int healthPoints, int attack, int defense, int speed)
		 */

		// Set the stage for the two Pokemons and display their types and affinities
		//Pokemon playerPokemon = new Pokemon("eevee", 2, 100, 10, 30, 60);
		//Pokemon enemyTarget = new Pokemon("Bulbasaur", 100, 10, 40, 67);
		Pokemon enemyPokemonOne = selectedStage.generateWildPokemon();
		Pokemon enemyPokemonTwo = selectedStage.generateWildPokemon();
		//			System.out.printf("Types and affinity of player's pokemon is: %s and %s", playerPokemon.PokemonTypeString(),
		//					playerPokemon.PokemonAffinityString());
		//			System.out.printf("Types and affinity of enemy pokemon is: %s with %s", enemyTarget.PokemonTypeString(),
		//					enemyTarget.PokemonAffinityString());

		// Player sends in the pokemon of their choice
		Scanner input = new Scanner(System.in);
		System.out.println("Which pokemon would you like to send? (Enter '0' to quit)");
		int sentPokemon;
		sentPokemon = input.nextInt();
		for (Pokemon a : playerPokemons) {
			if (a.equals(sentPokemon)) {
				System.out.printf("Sending %s in...", sentPokemon);
			}
		}

		// Battle logic : as player sends pokemon...
		//			while (sentPokemon != 0) {
		//				while (enemyTarget.healthPoints != 0 || playerPokemon.healthPoints != 0) {
		//					System.out.println("What would you like to do?");
		//					System.out.println("Attack or Defend");
		//					String playerDecision = input.next();
		//					if (playerDecision == "Attack") {
		//						playerPokemon.attack(enemyTarget);
		//						System.out.println("It was very effective!");
		//					} else if (playerDecision == "Defend") {
		//						enemyTarget.attack(playerPokemon);
		//					}
		//
		//					if (enemyTarget.healthPoints == 0) {
		//						System.out.printf("%s has won!", enemyTarget);
		//						break;
		//					}
		//
		//					if (playerPokemon.healthPoints == 0) {
		//						System.out.printf("%s has won!", playerPokemon);
		//						break;
		//					}
		//				}
		//			}

		//			Pokemon playerPokemon = new Pokemon();
		//			Pokemon enemyTarget = new Pokemon();
		//			while (sentPokemon != 0) {
		//				while (enemyTarget.healthPoints != 0 || playerPokemon.healthPoints != 0) {
		//					System.out.println("What would you like to do?");
		//					System.out.println("Attack or Defend");
		//					String playerDecision = input.next();
		//					
		//					if (playerDecision == "Attack") {
		//						playerPokemon.attack(enemyTarget);
		//						System.out.println("It was very effective!");
		//					} else if (playerDecision == "Defend") {
		//						enemyTarget.attack(playerPokemon);
		//					}
		//
		//					if (enemyTarget.healthPoints == 0) {
		//						System.out.printf("%s has won!", enemyTarget);
		//						break;
		//					}
		//
		//					if (playerPokemon.healthPoints == 0) {
		//						System.out.printf("%s has won!", playerPokemon);
		//						break;
		//					}
		//				}
		//			}

		//			boolean continueBattle = true;
		//			while (continueBattle) {
		//				for (Pokemon p : playerPokemons) {
		//					p.attack(enemyPokemonOne);
		//				}
		//				
		//				// this should ideally be a for-loop
		//				enemyPokemonOne.attack(playerPokemons[0]);
		//				enemyPokemonTwo.attack(playerPokemons[1]);
		//				
		//				// here check whether the player can continue fighting or not
		//				// hint: two different conditions to be checked...
		//			}


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
			try {
				leaderboardFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	}
}
