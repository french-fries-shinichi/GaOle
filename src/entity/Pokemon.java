package entity;

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
	public Pokemon(String name, int collectionNumber, int pokemonPE, String pokemonType, String moveType,
			int healthPoints, int attack, int defense, int speed) {
		
		this.name = name;
		this.collectionNumber = collectionNumber;
		this.pokemonPE = pokemonPE;
		this.pokemonType = pokemonType;
		this.moveType = moveType;
		this.healthPoints = healthPoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	private static final String[] types = 
		{
				"Normal", "Fire", "Water", "Electric", "Ice" ,"Grass", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"
		};
	
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