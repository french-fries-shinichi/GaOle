import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import stage.Stage;


public class Game {
	private Stage selectedStage;
	private int battleScore;
	String [] Pokemons = {"rayquaza", "jessie", "misty"};
	private Pokemon playerPokemon;
	
	public void start() {
		catchTime();
		battleTime();
		concludeStage();
		// 
	}
	
	public void selectStageMenu() {
		
		System.out.println("\n\n\n");
		System.out.println("Select a stage to begin!");
		for (int i = 0; i<5; i++) {
			System.out.printf("%d - %s", i, stageName);
		}
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
