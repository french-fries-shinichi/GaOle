package Entity;

public class ElectricPokemon extends Pokemon {
	public ElectricPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Electric, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		if (defenderTypes == PokemonTypes.Flying || defenderTypes == PokemonTypes.Water)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Ground) {
			effectiveness = 0;
		}
		else if (defenderTypes == PokemonTypes.Electric || defenderTypes == PokemonTypes.Grass || defenderTypes == PokemonTypes.Dragon)
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
