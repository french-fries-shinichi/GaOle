package Entity;

public class GrassPokemon extends Pokemon {
	public GrassPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Grass, attack, defense, speed);
	}
	
	@Override 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderType) {
		double effectiveness = 1.0;
		
		if (defenderType == PokemonTypes.Ground || defenderType == PokemonTypes.Water || defenderType == PokemonTypes.Rock)
		{
			effectiveness *= 2;
		}
		else if (defenderType == PokemonTypes.Poison || defenderType == PokemonTypes.Flying || defenderType == PokemonTypes.Bug || defenderType == PokemonTypes.Steel || defenderType == PokemonTypes.Fire || defenderType == PokemonTypes.Grass || defenderType == PokemonTypes.Dragon) 
		{
			effectiveness = 0.5;
		}
		else 
		{
			effectiveness *= 1;
		}
		return effectiveness;
	}
}