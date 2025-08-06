package Entity;

public class GrassPokemon extends Pokemon {
	public GrassPokemon(String name,
			int healthPoints, int attack, int defense, int speed) {
		
		super(name, healthPoints, attack, defense, speed);
	}
	
	@Override public void attack(Pokemon target) {
		int damage = this.attack - target.defense;
		if (damage < 0) damage = 0;
		target.takeDamage(damage);
		System.out.println(this.name + " attacked " + target.name + " for " +
		damage + " damage!");
		System.out.println("HELP");
	}
}
