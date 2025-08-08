package stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Entity.Pokemon;
import item.*;

public class Stage { // declare attributes
	private String stageName;
	private Pokemon[] likelyPokemons;
	private Pokeball[] pokeballList = {new Pokeball(), new GreatPokeball(), new UltraPokeball(), new MasterPokeball()};
	private Random rand = new Random();
	//private Set<Pokemon> catchTimePokemons;
	//private Pokemon capturedPokemon;
	//private int battleScore;
	//private int gaOleMedals;

	// Constructor stageName
	public Stage(String stageName, Pokemon[] likelyPokemons) {
		this.stageName = stageName;
		this.likelyPokemons = likelyPokemons;
		//this.likelyPokemons = generatePokemonPool();
		//this.catchTimePokemons = weightedRandomSelection(new ArrayList<>(likelyPokemons), 2);
		//this.battleScore = 0;
		//this.gaOleMedals = 0;
	}

	// Rarer Pokemon = lower chance to appear
//	private Set<Pokemon> weightedRandomSelection(List<Pokemon> pool, int count) {
//		Random rand = new Random();
//		List<Pokemon> weightedList = new ArrayList<>();
//
//		for (Pokemon p : pool) {
//			int weight = 6 - p.getStarRating(); // Higher stars → lower weight
//			for (int i = 0; i < weight; i++) {
//				weightedList.add(p);
//			}
//		}
//
//		Set<Pokemon> result = new HashSet<>();
//		while (result.size() < count && !weightedList.isEmpty()) {
//			Pokemon selected = weightedList.get(rand.nextInt(weightedList.size()));
//			result.add(selected);
//		}
//
//		return result;
//	}

//	public void setCapturedPokemon(Pokemon p) {
//		this.capturedPokemon = p;
//	}

//	public Set<Pokemon> getCatchTimePokemons() {
//		return catchTimePokemons;
//	}

//	public Pokemon getCapturedPokemon() {
//		return capturedPokemon;
//	}

//	public void displayStageInfo() {
//		System.out.println("Stage: " + stageName);
//		System.out.println("Catch-Time Pokémons:");
////		for (Pokemon p : catchTimePokemons) {
////			System.out.println("- " + p);
////		}
//		System.out.println("Captured Pokémon: " + (capturedPokemon != null ? capturedPokemon : "None"));
//	}
	
//	public void generateAllStages() {
//		allStages = {new Stage("hello")};
//	}
	
	// Getters and Setters
	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Pokemon[] getLikelyPokemons() {
		return likelyPokemons;
	}

	public void setLikelyPokemons(Pokemon[] likelyPokemons) {
		this.likelyPokemons = likelyPokemons;
	}
	
	public Pokemon generateWildPokemon() {
		int randomPokemon = rand.nextInt(getLikelyPokemons().length);
		return new Pokemon(getLikelyPokemons()[randomPokemon]);
	}
	
	public Pokeball generatePokeball() {
		System.out.println("Searching for Pokeballs...");
		// randomize the below code:
		int randomPokeball = rand.nextInt(pokeballList.length);
		System.out.printf("Yay! You've found a %s\n", pokeballList[randomPokeball]);
		return pokeballList[randomPokeball];
	}
	
	// I couldnt decide whether to use "toString" or static "displayAllStages" for my menu...
	
	public String toString() {
		return String.format("%s %s", getStageName(), getLikelyPokemons());
	}
}
