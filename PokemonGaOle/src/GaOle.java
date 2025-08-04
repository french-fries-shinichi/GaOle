import stage.Stage;

public class GaOle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Stage Select Menu:
		// give player a list of stages, what poke-mon are likely to appear in
		// each stage, then create an object for the stage they selected
		Game newGame = new Game(); // currently undefined

		// Catch Time!:
		// create a set of 3 poke-mons, which will be done by stage object's
		// constructor method upon initialization, then display the choices on
		// screen, then player catches one of the poke-mons with catchOne() method
		newGame.start();
		
		// PLACE BLOCK OF CODE

		// Battle Time!:
		// generate two wild pokemon, then display their type and affinities
		// with the departForBattle method, then ask player which one of their
		// pokemon would they like to send.
		// (this section is handled by the departForBattle() method)

		// Extra Battles!:
		// use extraBattles() method, which is similar to departForBattle() but
		// has a chance of activating, otherwise it will just do nothing and
		// move on.

		// it will be called from within departForBattle()

		// Check your Results!:
		// run displayResults() method, which will display the battle score
		// acquired during all the battles. then using the leaderboard.txt file,
		// we display the top 5 high-scores, if the acquired score beats them,
		// then overwrite and shift the list to add the new score. if the list
		// is empty (i e file hasn't been created yet), then create the file.
		// if the file has entries but less than five, then add the new score
		// and place it in the correct order, no need to overwrite anything.
		
		// Ga-Ole Medals
		// golden chip and golden sand drops randomly when pokemon s are caught
		// in battle. and then they are converted into Ga-Ole medals, which
		// accumulate somewhere?? when a certain amount of medals accumulate,
		// something cool happens
		
		// note to leader:
		// here you should de-construct the stage object, and loop back to the
		// top. so that the player can play another stage.
	}
}
