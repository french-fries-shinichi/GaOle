package Entity;

public class FairyPokemon extends Pokemon {
	public FairyPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Fairy, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Fighting || defenderTypes == PokemonTypes.Dragon || defenderTypes == PokemonTypes.Dark)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Poison || defenderTypes == PokemonTypes.Steel || defenderTypes == PokemonTypes.Fire)
		{
			effectiveness *= 0.5;
		}
		else {
			effectiveness *= 1;
		}
		return effectiveness;
	}
}
