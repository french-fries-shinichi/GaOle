package item;

public class GreatPokeball extends Pokeball {

	public GreatPokeball() {
		super();
		setProbabilityMultiplier(1.75);
	}
	
	@Override
	public String toString() {
		return "Great Pokeball";
	}
}
