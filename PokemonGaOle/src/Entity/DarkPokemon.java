package Entity;

public class DarkPokemon extends Pokemon {
	public DarkPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, PokemonTypes.Dark, attack, defense, speed);
	}
	
	//Calculates the effectiveness of a Pokemon's move 
	public double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderTypes) {
		double effectiveness = 1.0;
		
		
		if (defenderTypes == PokemonTypes.Ghost || defenderTypes == PokemonTypes.Psychic)
		{
			effectiveness *= 2;
		}
		else if (defenderTypes == PokemonTypes.Fighting || defenderTypes == PokemonTypes.Dark || defenderTypes == PokemonTypes.Fairy)
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
