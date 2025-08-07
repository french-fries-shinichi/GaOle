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
	private Pokemon[] playerPokemons = {PokemonPool.findSpecie("Charmeleon")};
	private ArrayList<Stage> stageList = new ArrayList<Stage>();
	
	// should these be local variables?
	//private Pokemon[] wildPokemons;
	
	public Game() {
		this.battleScore = 0;
		
		Pokemon[] pikachuStagePokemonList = {
			new ElectricPokemon("Pikachu", 50, 7, 3, 9),
			new GrassPokemon("Bulbasaur", 72, 4, 8, 4),
			new WaterPokemon("Squirtle", 64, 7, 5, 6)
		};
		Stage pikachuStage = new Stage("Pikachu Area", pikachuStagePokemonList);
		
		//create second stage here
		Pokemon[] eeveeStagePokemonList = {
				new ElectricPokemon("Pikachu", 50, 7, 3, 9),
				new GrassPokemon("Bulbasaur", 72, 4, 8, 4),
				new WaterPokemon("Squirtle", 64, 7, 5, 6)
			};
		Stage eeveeStage = new Stage("Eevee Area", eeveeStagePokemonList);
		
		//create third stage here
		Pokemon[] snorlaxStagePokemonList = {
				new ElectricPokemon("Pikachu", 50, 7, 3, 9),
				new GrassPokemon("Bulbasaur", 72, 4, 8, 4),
				new WaterPokemon("Squirtle", 64, 7, 5, 6)
			};
		Stage snorlaxStage = new Stage("Snorlax Area", snorlaxStagePokemonList);
		
		//then finally, add all stages to "stageList" array variable
		stageList.add(pikachuStage);
		stageList.add(eeveeStage);
		stageList.add(snorlaxStage);
		
		//this is just to test if it works
		//System.out.printf("%s", stageList.getFirst());
	}
	
	public void start() {
		//System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
		selectStageMenu();
		
		//catchTime();
		battleTime();
		//concludeStage(); 
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
					System.out.print("Would you like to proceed to catch time? (1 for YES/ 0 to QUIT): ");
					num = input.nextInt();
					System.out.println("");

					// CatchTime trigger
					while (num != 0) {
						boolean isLimit = false;
						if (num == 1) {
							start(); // Starts catch time
							break;
						} else {
							isLimit = false;
						} // end input check

						if (!isLimit) {
							System.out.print("Please enter a valid number (1 - YES, 0 - QUIT): ");
							num = input.nextInt();
							if (num == 1) {
								start(); // Starts catch time
								isLimit = false;
								break;
							}
						} // end retry variable
					} // end while num

					if (num == 0) {
						System.out.print("Are you sure you want to quit? Enter \"YES\" to proceed: ");
						proceed = input.next();
						if (proceed.equals("YES")) {
							System.out.println("Quiting game...\n");
							concludeStage();
						} else if (proceed.matches("\\d+")) { // Check if 'proceed' contains only digits (a number)
							System.out.println(
									"Error: Invalid input! You cannot enter a number. Please enter \"YES\" to proceed.");
							throw new IllegalArgumentException("");
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
		}
	
	public void selectStageMenu() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("\n\n\n");
		System.out.println("Select a stage to begin!");
		for (int i = 0; i<stageList.size(); i++) {
			System.out.printf("%d - %s\n", i + 1, stageList.get(i).getStageName());
		}
		System.out.println("Choose any of the stages from the list above:");
		int choice = s.nextInt() - 1;
		selectedStage = stageList.get(choice);
	}
	
	public void catchTime() {
		Scanner s = new Scanner(System.in);
		Pokemon[] wildPokemons = {selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon(), selectedStage.generateWildPokemon()};
		
		System.out.println("\n\n\nCatch time! A gang of wild Pokemon appears!");
		for (int i = 0; i < wildPokemons.length; i++) {
			System.out.printf("%d - %s\n", i, wildPokemons[i].getName());
		}

		System.out.println("Enter the number of the Pokemon you wanna catch: ");
		int choice = s.nextInt();
		
		//salvage this maybe?
		if (choice >= 1 && choice <= 3) {
			System.out.println("you caught " +wildPokemons[choice - 1] + "!");
		}  else {
			System.out.println("invalid choice.No pokemon caught GAME OVER!");
		}
	}
	
	// Executed when is time to battle pokemon
	public void battleTime() {
		// Set the stage for the two Pokemons and display their types and affinities
		//Pokemon playerPokemon = new Pokemon("eevee", 2, 100, 10, 30, 60);
		//Pokemon enemyTarget = new Pokemon("Bulbasaur", 100, 10, 40, 67);
		Pokemon enemyPokemonList[] = {
			selectedStage.generateWildPokemon(),
			selectedStage.generateWildPokemon()
		};
		Scanner s = new Scanner(System.in);
		
		System.out.println("\n\n\nTwo wild pokemon approach for battle! It's battle time!");
		
		while (!enemyPokemonList[0].isPokemonFainted() && !enemyPokemonList[1].isPokemonFainted()) {
			for (int i = 0; i<enemyPokemonList.length; i++) {
				System.out.printf("%d - %s: %d HP\n", i+1, enemyPokemonList[i].getName(), enemyPokemonList[i].getHealthPoints());
			}
			System.out.println("Choose which wild pokemon you want to attack?");
			int choice = s.nextInt();
			
			playerPokemons[0].attack(enemyPokemonList[choice]);
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
			FileWriter leaderboardWriter = new FileWriter("leaderboard.txt");
			leaderboardWriter.write(String.format("%d", battleScore));
			leaderboardWriter.close();
		} catch (IOException e) {
			System.out.println("An error has occured related to the file!");
			e.printStackTrace();
		}
		
		// display the results
	}
}
