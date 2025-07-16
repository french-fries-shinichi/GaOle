package test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Entity.Pokemon;

public class Stage { // declare attributes
	private String stageName;
	private Set<Pokemon> likelyPokemons;
	private Set<Pokemon> catchTimePokemons;
	private Pokemon capturedPokemon;
	private int battleScore;
	private int gaOleMedals;

	// Constructor stageName
	public Stage(String stageName) {
		this.stageName = stageName;
		this.likelyPokemons = generatePokemonPool();
		this.catchTimePokemons = weightedRandomSelection(new ArrayList<>(likelyPokemons), 2);
		this.battleScore = 0;
		this.gaOleMedals = 0;
	}

	// list of 10 Pokemons (it can be anyth)
	private Set<Pokemon> generatePokemonPool() {
		Set<Pokemon> pokemons = new HashSet<>();
		pokemons.add(new Pokemon("Pikachu", 2));
		pokemons.add(new Pokemon("Bulbasaur", 3));
		pokemons.add(new Pokemon("Charmander", 4));
		pokemons.add(new Pokemon("Sylveon", 3));
		pokemons.add(new Pokemon("Eevee", 1));
		pokemons.add(new Pokemon("Mewtwo", 5));
		pokemons.add(new Pokemon("Umbreon", 4));
		pokemons.add(new Pokemon("Lucario", 5));
		pokemons.add(new Pokemon("Jigglypuff", 2));
		pokemons.add(new Pokemon("Machop", 2));
		return pokemons;
	}

	// Rarer Pokemon = lower chance to appear
	private Set<Pokemon> weightedRandomSelection(List<Pokemon> pool, int count) {
		Random rand = new Random();
		List<Pokemon> weightedList = new ArrayList<>();

		for (Pokemon p : pool) {
			int weight = 6 - p.getStarRating(); // Higher stars → lower weight
			for (int i = 0; i < weight; i++) {
				weightedList.add(p);
			}
		}

		Set<Pokemon> result = new HashSet<>();
		while (result.size() < count && !weightedList.isEmpty()) {
			Pokemon selected = weightedList.get(rand.nextInt(weightedList.size()));
			result.add(selected);
		}

		return result;
	}

	public void setCapturedPokemon(Pokemon p) {
		this.capturedPokemon = p;
	}

	public Set<Pokemon> getCatchTimePokemons() {
		return catchTimePokemons;
	}

	public Pokemon getCapturedPokemon() {
		return capturedPokemon;
	}

	public void displayStageInfo() {
		System.out.println("Stage: " + stageName);
		System.out.println("Catch-Time Pokémons:");
		for (Pokemon p : catchTimePokemons) {
			System.out.println("- " + p);
		}
		System.out.println("Captured Pokémon: " + (capturedPokemon != null ? capturedPokemon : "None"));
	}
}
