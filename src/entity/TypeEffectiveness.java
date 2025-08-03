package entity;

public class TypeEffectiveness {
	
	public static double getEffectiveness(PokemonTypes moveTypes, PokemonTypes enemyTypes, PokemonTypes pokemonTypes){
		double Effectiveness = 1.0;
		
		
		//STAb or Same type attack bonus
		if (pokemonTypes == moveTypes) 
		{
			Effectiveness *= 1.5;
		}
		
		
		
		
		if (moveTypes == PokemonTypes.Normal){
			if ((enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Steel))
			{
				Effectiveness *= 0.5;
			}
			else if (enemyTypes == PokemonTypes.Ghost) 
			{
				Effectiveness = 0;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Fighting) {
			if ((enemyTypes == PokemonTypes.Normal) || (enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Ice) || (enemyTypes == PokemonTypes.Dark))
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Ghost) 
			{
				Effectiveness = 0;
			}
			else if ((enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Psychic) || (enemyTypes == PokemonTypes.Fairy))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Poison) {
			if ((enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Fairy))
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Steel)
			{
				Effectiveness = 0;
			}
			else if ((enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Ground) || (enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Ghost))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Ground) {
			if ((enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Electric))
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Flying) {
				Effectiveness = 0;
			}
			else if ((enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Grass))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Flying) {
			if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Grass))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Electric))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Bug) {
			if ((enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Psychic) || (enemyTypes == PokemonTypes.Dark))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Ghost) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Fairy))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Rock) {
			if ((enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Ice))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Ground) || (enemyTypes == PokemonTypes.Steel))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Ghost) {
			if ((enemyTypes == PokemonTypes.Ghost) || (enemyTypes == PokemonTypes.Psychic)){
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Normal) {
				Effectiveness = 0;
			}
			else if (enemyTypes == PokemonTypes.Dark){
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Steel) {
			if ((enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Ice) || (enemyTypes == PokemonTypes.Fairy))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Water) || (enemyTypes == PokemonTypes.Electric))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Fire) {
			if ((enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Ice))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Water) || (enemyTypes == PokemonTypes.Dragon))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Water) {
			if ((enemyTypes == PokemonTypes.Ground) || (enemyTypes == PokemonTypes.Rock) || (enemyTypes == PokemonTypes.Fire))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Water) || (enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Dragon))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Electric) {
			if ((enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Water))
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Ground) {
				Effectiveness = 0;
			}
			else if ((enemyTypes == PokemonTypes.Electric) || (enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Dragon))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Grass) {
			if ((enemyTypes == PokemonTypes.Ground) || (enemyTypes == PokemonTypes.Water) || (enemyTypes == PokemonTypes.Rock))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Bug) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Dragon))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Ice) {
			if ((enemyTypes == PokemonTypes.Ground) || (enemyTypes == PokemonTypes.Flying) || (enemyTypes == PokemonTypes.Grass) || (enemyTypes == PokemonTypes.Dragon))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire) || (enemyTypes == PokemonTypes.Water) || (enemyTypes == PokemonTypes.Ice))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Psychic) {
			if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Poison))
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Dark) 
			{
				Effectiveness = 0;
			}
			else if ((enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Psychic))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Dragon) {
			if (enemyTypes == PokemonTypes.Dragon)
			{
				Effectiveness *= 2;
			}
			else if (enemyTypes == PokemonTypes.Fairy)
			{
				Effectiveness = 0;
			}
			else if (enemyTypes == PokemonTypes.Steel)
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Dark) {
			if ((enemyTypes == PokemonTypes.Ghost) || (enemyTypes == PokemonTypes.Psychic))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Dark) || (enemyTypes == PokemonTypes.Fairy))
			{
				Effectiveness *= 0.5;
			}
			else 
			{
				Effectiveness *= 1;
			}
		}
		
		else if (moveTypes == PokemonTypes.Fairy) {
			if ((enemyTypes == PokemonTypes.Fighting) || (enemyTypes == PokemonTypes.Dragon) || (enemyTypes == PokemonTypes.Dark))
			{
				Effectiveness *= 2;
			}
			else if ((enemyTypes == PokemonTypes.Poison) || (enemyTypes == PokemonTypes.Steel) || (enemyTypes == PokemonTypes.Fire))
			{
				Effectiveness *= 0.5;
			}
			else {
				Effectiveness *= 1;
			}
		}
		return Effectiveness;
	}
}
