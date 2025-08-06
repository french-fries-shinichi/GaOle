package Entity;

public class Pokemon {
	
	private String name;
	private int collectionNumber;
	private int pokemonPE;
	private String pokemonType;
	private String moveType;
	private int healthPoints;
	
	private int attack;
	private int defense;
	private int speed;
	
	//Constructor Method
	public Pokemon(String name,
			int collectionNumber, int pokemonPE, String moveType,
			String pokemonType, int healthPoints, int attack, int defense, int speed) {
		
		this.name = name;
		this.collectionNumber = collectionNumber;
		this.pokemonPE = pokemonPE;
		this.moveType = moveType;
		this.pokemonType = pokemonType;
		this.healthPoints = healthPoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	// Setters and Getters
	public String getName() {
		return name;
	}

	public int getCollectionNumber() {
		return collectionNumber;
	}

	public int getPokemonPE() {
		return pokemonPE;
	}

	public String getMoveType() {
		return moveType;
	}

	public String getPokemonType() {
		return pokemonType;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpeed() {
		return speed;
	}

	//Method to deal damage to Pokemon
	public void takeDamage(int damage) {
		healthPoints -= damage;
		if (damage < 0) healthPoints = 0;
	}
	
	/*Method used to measure the damage to
	 * inflict on other Pokemon
	 */
	public void attack(Pokemon target) {
		int damage = this.attack - target.defense;
		if (damage < 0) damage = 0;
		target.takeDamage(damage);
		System.out.println(this.name + " attacked " + target.name + " for " +
		damage + " damage!");
	}
}
