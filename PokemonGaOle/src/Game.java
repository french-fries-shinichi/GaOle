import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import stage.Stage;
import Entity.*;
import item.*;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	private Random randNumGen = new Random();
	private ArrayList<Pokemon> playerPokemons = new ArrayList<Pokemon>();
	private ArrayList<Stage> stageList = new ArrayList<Stage>();
	
	// should these be local variables?
	//private Pokemon[] wildPokemons;
	
	public Game() {
		this.battleScore = 0;
		
		Pokemon[] pikachuStagePokemonList = {
			PokemonPool.copy("Pikachu"),
			PokemonPool.copy("Bulbasaur"),
			PokemonPool.copy("Squirtle"),
			PokemonPool.copy("Dialga"),
			PokemonPool.copy("Lucario")
			
		};
		Stage pikachuStage = new Stage("Pikachu Area", pikachuStagePokemonList);
		
		//create second stage here
		Pokemon[] eeveeStagePokemonList = {
				PokemonPool.copy("Eevee"),
				PokemonPool.copy("Charmeleon"),
				PokemonPool.copy("Squirtle"),
				PokemonPool.copy("Rayquaza"),
				PokemonPool.copy("Mew"),
				PokemonPool.copy("Diancie")
			};
		Stage eeveeStage = new Stage("Eevee Area", eeveeStagePokemonList);
		
		//create third stage here
		Pokemon[] snorlaxStagePokemonList = {
				PokemonPool.copy("Snorlax"),
				PokemonPool.copy("Darkrai"),
				PokemonPool.copy("Articuno"),
				PokemonPool.copy("Mimikyu"),
				PokemonPool.copy("Tyranitar")
			};
		Stage snorlaxStage = new Stage("Snorlax Area", snorlaxStagePokemonList);
		
		//then finally, add all stages to "stageList" array variable
		stageList.add(pikachuStage);
		stageList.add(eeveeStage);
		stageList.add(snorlaxStage);
		
		//this is just to test if it works
		//System.out.printf("%s", stageList.getFirst());
		
		// adding the player's initial pokemons
		playerPokemons.add(PokemonPool.copy("Charmeleon"));
	}
	
	public void start() {
		//System.out.println("Welcome to Pokemon GaOle! Please insert some coins to start the game.");
		selectStageMenu();
		
		catchTime();
		battleTime();
		concludeStage();
	}
	
	public void initiateStage() {
		// Initializes the stage start
		int num;
		int credits;
		int count = 1;
		int Continue;
		boolean startStage = true;
		boolean isPokemonStage = true;
		boolean isSatisfied = true;
		String proceed = "";

		// All logic of connecting stages will go in here
		// basically before triggering catchTime

		Scanner input = new Scanner(System.in);

		// Stage start
		while (isSatisfied) {
			while (startStage) {
				try {
					// Start the stage dialogue
					System.out.println("\n\nWelcome to Pokemon GaOle! Please insert some coins to start the game.");
					System.out.println("You will need 8 coins to start the game\n");
					System.out.print("Enter '1' to insert credits: ");
					credits = input.nextInt();

					// Entering '1' starts the game
					if (credits != 1) {
						System.out.println("You must enter '1' to insert a coin.\n");
						continue;
					}

					// Increment count for every credit inserted into the machine
					// Print back the amount of credits each time back to the player
					while (count < 9) {
						System.out.printf("You have inserted %s coins! ", count);
						System.out.println("Enter STOP to end game");
						System.out.print("Would you like to continue? (Enter '1'): ");
						Continue = input.nextInt();

						// Skips condition if exit if input is not '1'
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
						count++; // Increment the count of the credits printed
					}

					if (!startStage) {
						System.out.print("You have inserted 8 coins!\n");
						System.out.println("Thank you. Get ready for Battle and Catch, good luck!\n");
						break;
					} // end if !startStage
				} catch (InputMismatchException e) {
					System.out.println("Input does not match your intended action! Please try again.\n");
					input.nextLine();
				} catch (Exception e) {
					System.out.println("An error occured. Please try again.\n");
					input.nextLine();
				}
				break;
			} // end while

			// A while loop to run start() method and validate input
			while (isPokemonStage) {
				try {
					System.out.print("Would you like to proceed to catch time? (1 for YES/ 0 to QUIT): ");
					num = input.nextInt();
					System.out.println("");

					// Trigger to run the battle modes
					boolean isLimit = false;
					while (num != 0) {
						if (num == 1) {
							isSatisfied = false;
							break;
						} else {
							isLimit = false;
						} // end input check

						if (!isLimit) {
							System.out.print("Please enter a valid number (1 - YES, 0 - QUIT): ");
							num = input.nextInt();
							if (num == 1) {
								isSatisfied = false;
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

		if (!isSatisfied) {
			start();
		}
	}
	
//	public void initiatePlayerPokemons(ArrayList<Pokemon> playerPokemons) {
//		if (playerPokemons.size() == 0) {
//			System.out.println("Oh no, you don't have any Pokemons!");
//			System.out.println("Here, take a Bulbasaur!");
//			playerPokemons.add(PokemonPool.copy("Bulbasaur"));
//		} else {
//			this.playerPokemons = playerPokemons;
//		}
//	}
	
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
			System.out.printf("%d - %s\n", i+1, wildPokemons[i].getName());
		}

		System.out.println("Enter the number of the Pokemon you want to catch: ");
		int choice = s.nextInt() -1;
		
		if (choice >= 0 && choice <= 2) {
			// this is the "always capture" logic, in case the probability capture doesnt work
			//System.out.println("you caught " +wildPokemons[choice - 1] + "!");
			Pokeball ballFound = selectedStage.generatePokeball();
			
			if (randNumGen.nextDouble() < 0.1 * ballFound.getProbabilityMultiplier()) {
				playerPokemons.add(wildPokemons[choice]);
				System.out.println(randNumGen.nextDouble());
				System.out.println("You've captured the Pokemon successfully!");
			} else {
				System.out.println("Oh no, your attempt to capture the wild Pokemon has failed.");
			}
			// something like: if (rng <  * found.getProbabilityMultiplier())
			// actually im too sleep deprived to figure it out
		} else {
			System.out.println("DO error handling here...");
		}
	}
	
	public void battleTime() {
	    Pokemon[] enemyPokemonList = {
	        selectedStage.generateWildPokemon(),
	        selectedStage.generateWildPokemon()
	    };

	    Scanner s = new Scanner(System.in);

	    for (Pokemon p : enemyPokemonList) {
	        battleScore += p.getHealthPoints();
	    }

	    System.out.println("\n\n\nTwo wild pokemon approach for battle! It's battle time!");
	    System.out.printf("You've encountered a wild %s and %s!\n", enemyPokemonList[0].getName(), enemyPokemonList[1].getName());

	    if (playerPokemons.size() < 2) {
			System.out.println("Oh no, you don't have any Pokemons!");
			System.out.println("Here, take a Bulbasaur!");
			playerPokemons.add(PokemonPool.copy("Bulbasaur"));
			if (playerPokemons.size() < 2) {
				System.out.println("Looks like you don't have enough pokemons, here's a free second Pokemon!");
				playerPokemons.add(PokemonPool.copy("Snorlax"));
			}
		}
	    System.out.println("You have the following Pokemon:");
	    for (int i = 0; i < playerPokemons.size(); i++) {
	        System.out.printf("%d - %s: %d HP\n", i + 1, playerPokemons.get(i).getName(), playerPokemons.get(i).getHealthPoints());
	    }

	    System.out.println("Which one do you want to send?\nFor your first Pokemon:");
	    int choiceOne = s.nextInt() - 1;
	    System.out.println("For your second Pokemon:");
	    int choiceTwo = s.nextInt() - 1;

	    Pokemon[] alliedPokemonList = {
	        playerPokemons.get(choiceOne),
	        playerPokemons.get(choiceTwo)
	    };

	    while (!enemyPokemonList[0].isPokemonFainted() && !enemyPokemonList[1].isPokemonFainted()) {
	        System.out.println("\n== Player's Turn! ==\nWild Pokemon health:");
	        for (int i = 0; i < enemyPokemonList.length; i++) {
	            System.out.printf("%d - %s: %d HP\n", i + 1, enemyPokemonList[i].getName(), enemyPokemonList[i].getHealthPoints());
	        }

	        for (int i = 0; i < alliedPokemonList.length; i++) {
	            System.out.printf("Choose which wild pokemon %s should attack: ", alliedPokemonList[i].getName());
	            int target = s.nextInt() - 1;
	            alliedPokemonList[i].attack(enemyPokemonList[target]);
	        }

	        for (int i = 0; i < alliedPokemonList.length; i++) {
	            System.out.printf("%d - %s: %d HP\n", i + 1, alliedPokemonList[i].getName(), alliedPokemonList[i].getHealthPoints());
	        }

	        System.out.println("== Enemy's Turn! ==");
	        for (int i = 0; i < enemyPokemonList.length; i++) {
	            enemyPokemonList[i].attack(alliedPokemonList[i % alliedPokemonList.length]);
	        }
	    }
	}
	
	// FOR DEBUGGING PURPOSES!
//	public void setBattleScore(int x) {
//		battleScore = x;
//	}
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
				
				FileWriter leaderboardWriter = new FileWriter("leaderboard.txt");
				leaderboardWriter.write("0\n0\n0\n0\n0\n");
				leaderboardWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// read from file and parse it into a 5-items long array
		Scanner leaderboardReader;
		Integer[] scoreList = {-1,-1,-1,-1,-1};
		try {
			leaderboardReader = new Scanner(leaderboardFile);
			for (int i = 0; i<5; i++) {
				scoreList[i] = Integer.parseInt(leaderboardReader.nextLine());
			}
			
			// FOR DEBUGGING, RAWR!!
			for (int i = 0; i<5; i++) { 
				System.out.println(scoreList[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// compare the new battle-score to see if it's a highscore
		boolean overwrite = false;
		Arrays.sort(scoreList, Collections.reverseOrder());
		for (Integer x : scoreList) {
			if (battleScore > x) {
				overwrite = true;
				break;
			}
		}
		if (overwrite == true) {
			scoreList[4] = battleScore;
			Arrays.sort(scoreList, Collections.reverseOrder());
		}
		
		// store in a leaderboard file
		try {
			FileWriter leaderboardWriter = new FileWriter("leaderboard.txt");
			leaderboardWriter.close();
			// display the results
			System.out.println("Leaderboard!");
			for (int i = 0; i<scoreList.length; i++) {
				leaderboardWriter.write(String.format("%d\n", scoreList[i]));
			}
		} catch (IOException e) {
			System.out.println("An error has occured related to the file!");
			e.printStackTrace();
		}
		
		
	}
}
