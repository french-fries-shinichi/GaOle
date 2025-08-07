package Entity;

public class FlyingPokemon extends Pokemon {
	public FlyingPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Flying, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Fighting || defenderTypes == PokemonTypes.Bug || defenderTypes == PokemonTypes.Grass)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Rock || defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Electric)
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
