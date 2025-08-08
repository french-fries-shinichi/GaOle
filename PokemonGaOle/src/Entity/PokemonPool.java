package Entity;

public class PokemonPool {
//	public enum PokemonSpecies {
//		BULBASAUR, IVYSAUR, VENUSAUR, CHARMANDER,
//		CHARMELEON, CHARIZARD, SQUIRTLE, WARTORTLE,
//		BLASTOISE, EEVEE, PSYDUCK, ESPEON,
//		UMBREON, MEOWTH, ELECTIVIRE, MAGMORTAR,
//		GARDEVOIR, GALLADE, MIMIKYU, RAIKOU,
//		ENTEI, SUICUNE, RHYPERIOR, MACHAMP,
//		PIKACHU, LUCARIO, DRAGONITE, TYRANITAR,
//		SNORLAX, METAGROSS, GENGAR, GYARADOS,
//		GARCHOMP, SALAMENCE, SCIZOR, KYOGRE,
//		GROUDON, LUGIA, HOOH, RAYQUAZA,
//		RESHIRAM, ZEKROM, KYUREM, DARKRAI,
//		ZYGARDE, DIALGA, PALKIA, MEW,
//		LATIAS, ARTICUNO, ZAPDOS, MOLTRES,
//		MEWTWO, ARCEUS, DIANCIE
//	}
//	public String[] pokemonSpecies = {
//			"Bulbasaur", "Ivysaur", "Venusaur", "Charmander",
//			"Charmeleon", "Charizard", "Squirtle", "Wartortle",
//	};
	private static Pokemon[] pokemonSpecies = {
			new GrassPokemon("Bulbasaur", 72, 4, 8, 4),
			new FirePokemon("Charmeleon", 10, 10, 10, 10),
			new ElectricPokemon("Pikachu", 50, 7, 3, 9),
			new WaterPokemon("Squirtle", 64, 7, 5, 6),
			new NormalPokemon("Eevee", 100, 10, 30, 60)
	};
	
	public static Pokemon copy(String specie) {
		for (Pokemon x : pokemonSpecies) {
			if (x.getName() == specie) {
				return new Pokemon(x);
			}
		}
		
		// should probably return an exception...
		return null;
	}
}
