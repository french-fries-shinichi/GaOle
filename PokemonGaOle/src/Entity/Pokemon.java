package Entity;

public class Pokemon {
	
	private String name;
	//private int collectionNumber;
	//private int pokemonPE;
	//private String moveType;
	private int healthPoints;
	
	private int attack;
	private int defense;
	private int speed;
	private double Effective;
	private PokemonTypes type;
	
	public enum PokemonTypes {
	    Normal, Fire, Water, Electric, Ice, Grass,
	    Fighting, Poison, Ground, Flying, Psychic,
	    Bug, Rock, Ghost, Dragon, Dark, Steel, Fairy
	}
	
	//Constructor Method
	public Pokemon(String name,
			int healthPoints, PokemonTypes type,  int attack, int defense, int speed) {
		
		this.name = name;
		//this.collectionNumber = collectionNumber;
		//this.pokemonPE = pokemonPE;
		//this.moveType = moveType;
		this.type = type;
		this.healthPoints = healthPoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	// Setters and Getters
	public String getName() {
		return name;
	}
	
	public PokemonTypes getType(){
		return type;
	}
	
	protected double getEffectiveness(PokemonTypes attackType, PokemonTypes defenderType) {
		return 1.0;
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
		double effectiveness = getEffectiveness(this.type, target.getType());
		int damage = (int)((this.attack - target.defense)*effectiveness);
		if (damage < 0) damage = 0;
		target.takeDamage(damage);
		System.out.println(this.name + " attacked " + target.name + " for " +
		damage + " damage!");
	}
}
