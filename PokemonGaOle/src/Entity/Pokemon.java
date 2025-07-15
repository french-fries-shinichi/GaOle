package Entity;

public class Pokemon {
	
	private String name;
	private int collectionNumber;
	private int pokemonPE;
	private String moveType;
	private int healthPoints;
	private int attack;
	private int defense;
	private int speed;
	
	public Pokemon(String name, int collectionNumber, int pokemonPE, String moveType,
			int healthPoints, int attack, int defense, int speed) {
		
		this.name = name;
		this.collectionNumber = collectionNumber;
		this.pokemonPE = pokemonPE;
		this.moveType = moveType;
		this.healthPoints = healthPoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	public void takeDamage(int damage) {
		healthPoints -= damage;
		if (damage < 0) healthPoints = 0;
	}
	
	public void attack(Pokemon target) {
		int damage = this.attack - target.defense;
		if (damage < 0) damage = 0;
		target.takeDamage(damage);
		System.out.println(this.name + " attacked " + target.name + " for " +
		damage + " damage!");
	}
}
