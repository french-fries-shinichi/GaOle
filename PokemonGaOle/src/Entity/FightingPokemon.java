package Entity;

public class FightingPokemon extends Pokemon {
	public FightingPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Fighting, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Normal || defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Ice || defenderTypes == PokemonTypes.Dark)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Ghost) 
		{
			effectiveness = 0;
		}
		else if (defenderTypes == PokemonTypes.Poison || defenderTypes == PokemonTypes.Flying || defenderTypes == PokemonTypes.Bug || defenderTypes == PokemonTypes.Psychic || defenderTypes == PokemonTypes.Fairy)
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
