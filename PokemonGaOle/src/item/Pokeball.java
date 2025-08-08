package item;

public class Pokeball {
	private double probabilityMultiplier;

	public Pokeball() {
		this.probabilityMultiplier = 1.0;
	}

	public double getProbabilityMultiplier() {
		return probabilityMultiplier;
	}

	protected void setProbabilityMultiplier(double probabilityMultiplier) {
		this.probabilityMultiplier = probabilityMultiplier;
	}
	
	public String toString() {
		return "Normal Pokeball";
	}
}
