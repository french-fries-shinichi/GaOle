package Entity;

public class WaterPokemon extends Pokemon {
	public WaterPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Water, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderType) {
		double effectiveness = 1.0;
		
		if (defenderType == PokemonTypes.Ground || defenderType == PokemonTypes.Rock || defenderType == PokemonTypes.Fire)
		{
			effectiveness *= 2;
		}
		else if (defenderType == PokemonTypes.Water || defenderType == PokemonTypes.Grass || defenderType == PokemonTypes.Dragon)
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
