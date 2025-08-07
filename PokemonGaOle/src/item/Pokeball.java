package item;
import Entity.Pokemon;

// DEPRECATED, DO NOT USE!!

public class Pokeball {
	private Pokemon capturedPokemon;
	private String pokeballType;
	
	
	public Pokemon getCapturedPokemon() {
		return capturedPokemon;
	}
	public void setCapturedPokemon(Pokemon capturedPokemon) {
		this.capturedPokemon = capturedPokemon;
	}
	public String getPokeballType() {
		return pokeballType;
	}
	public void setPokeballType(String pokeballType) {
		if (pokeballType == "Normal" || pokeballType == "Master") {
			this.pokeballType = pokeballType;
		}
	}
}
