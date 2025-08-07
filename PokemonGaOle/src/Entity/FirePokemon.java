package Entity;

public class FirePokemon extends Pokemon {
	public FirePokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Fire, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderType) {
		double effectiveness = 1.0;
		
		if (defenderType == PokemonTypes.Bug || defenderType == PokemonTypes.Steel || defenderType == PokemonTypes.Grass || defenderType == PokemonTypes.Ice)
		{
			effectiveness *= 2;
		}
		else if (defenderType == PokemonTypes.Rock || defenderType == PokemonTypes.Fire || defenderType == PokemonTypes.Water || defenderType == PokemonTypes.Dragon)
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
