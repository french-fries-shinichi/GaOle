package Entity;

public class ElectricPokemon extends Pokemon {
	public ElectricPokemon(String name,
			int collectionNumber, int pokemonPE, String moveType, String pokemonType, int healthPoints, int attack, int defense, int speed) {

		super(name, collectionNumber, pokemonPE, moveType, pokemonType, healthPoints, attack, defense, speed);
	}
	
	@Override public void attack(Pokemon target) {
		int damage = this.getAttack() - target.getDefense();
		if (damage < 0) damage = 0;
		target.takeDamage(damage);
		System.out.println(this.getName() + " attacked " + target.getName() + " for " +
		damage + " damage!");
		System.out.println("HELP");
	}
}
