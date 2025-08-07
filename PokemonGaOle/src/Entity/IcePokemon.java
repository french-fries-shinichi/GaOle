package Entity;

public class IcePokemon extends Pokemon {
	public IcePokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Ice, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Ground || defenderTypes == PokemonTypes.Flying || defenderTypes == PokemonTypes.Grass || defenderTypes == PokemonTypes.Dragon)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Fire || defenderTypes == PokemonTypes.Water || defenderTypes == PokemonTypes.Ice)
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
