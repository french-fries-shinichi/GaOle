import java.util.ArrayList;

import Entity.Pokemon;

public class GaOle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game newGame = new Game();
		ArrayList<Pokemon> playerPokemons = new ArrayList<Pokemon>();
		
		//UserSave playerDisk = new UserSave("PlayerOne"); //delete if not gonna use
		//newGame.initiateStage();
		newGame.initiatePlayerPokemons(playerPokemons);
		newGame.start();
	}
}
