package Entity;

public class RockPokemon extends Pokemon {
	public RockPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Rock, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Flying || defenderTypes == PokemonTypes.Bug || defenderTypes == PokemonTypes.Fire || defenderTypes == PokemonTypes.Ice)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Fighting || defenderTypes == PokemonTypes.Ground || defenderTypes == PokemonTypes.Steel)
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
