package Entity;

public class BugPokemon extends Pokemon {
	public BugPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Bug, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Grass || defenderTypes == PokemonTypes.Psychic || defenderTypes == PokemonTypes.Dark)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Fighting || defenderTypes == PokemonTypes.Poison || defenderTypes == PokemonTypes.Flying || defenderTypes == PokemonTypes.Ghost || defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Fire || defenderTypes == PokemonTypes.Fairy)
		{
			effectiveness *= 0.5;
		}
		else 
		{
			effectiveness *= 1;
		}
		return effectiveness;
	}
}
