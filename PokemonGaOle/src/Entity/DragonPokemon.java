package Entity;

public class DragonPokemon extends Pokemon {
	public DragonPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Dragon, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Dragon)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Fairy)
		{
			effectiveness = 0;
		}
		else if (defenderTypes == PokemonTypes.Steel)
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
