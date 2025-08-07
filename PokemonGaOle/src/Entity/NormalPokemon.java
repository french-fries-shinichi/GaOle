package Entity;

public class NormalPokemon extends Pokemon {
	public NormalPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Normal, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Steel)
		{
			effectiveness *= 0.5;
		}
		else if (defenderTypes == PokemonTypes.Ghost) 
		{
			effectiveness = 0;
		}
		else 
		{
			effectiveness *= 1;
		}
		return effectiveness;
	}
}
