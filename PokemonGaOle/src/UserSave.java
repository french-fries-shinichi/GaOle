import java.util.ArrayList;

import Entity.Pokemon;

public class UserSave {
	private String userName;
	private ArrayList<Pokemon> PokemonList;
	
	// Constructors
	public UserSave(String userName) {
		
	}

	// Setters and Getters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPokemonList() {
		return PokemonList.toString();
	}
	
	// Methods
	public void addPokemon(Pokemon captured) {
		PokemonList.add(new captured);
	}
	
	public void removePokemon() {
		
	}
	
	public void getPokemon() {
		
	}
	
	// toString
	public String toString() {
		return String.format("%s [%s]", getUserName(), getPokemonList());
	}
}
