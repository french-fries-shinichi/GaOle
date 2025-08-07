package Entity;

public class SteelPokemon extends Pokemon {
	public SteelPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Steel, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Ice || defenderTypes == PokemonTypes.Fairy)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Fire || defenderTypes == PokemonTypes.Water || defenderTypes == PokemonTypes.Electric)
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
