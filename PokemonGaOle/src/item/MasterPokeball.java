package item;

public class MasterPokeball extends Pokeball {

	public MasterPokeball() {
		super();
		setProbabilityMultiplier(2.5);
	}
	
	@Override
	public String toString() {
		return "Master Pokeball";
	}
}
