package Entity;

public class PoisonPokemon extends Pokemon {
	public PoisonPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Poison, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Grass || defenderTypes == PokemonTypes.Fairy)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Steel)
		{
			effectiveness = 0;
		}
		else if (defenderTypes == PokemonTypes.Poison || defenderTypes == PokemonTypes.Ground || defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Ghost)
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
