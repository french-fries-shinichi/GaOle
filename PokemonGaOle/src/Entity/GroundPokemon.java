package Entity;

public class GroundPokemon extends Pokemon {
	public GroundPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Ground, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Poison || defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Fire || defenderTypes == PokemonTypes.Electric)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Flying) {
			effectiveness = 0;
		}
		else if (defenderTypes == PokemonTypes.Bug || defenderTypes == PokemonTypes.Grass)
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
