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
//		MEWTWO, ARCEUS, DIANCIEI
//	}
//	public String[] pokemonSpecies = {
//			"Bulbasaur", "Ivysaur", "Venusaur", "Charmander",
//			"Charmeleon", "Charizard", "Squirtle", "Wartortle",
//	};
	public static Pokemon[] pokemonSpecies = {
			new FirePokemon("Charmeleon", 65, 90, 60, 85),
			new WaterPokemon("Squirtle", 80, 65, 95, 50),
			new GrassPokemon("Bulbasaur", 80, 80, 75, 55),
			new ElectricPokemon("Pikachu", 60, 80, 70, 100),
			new NormalPokemon("Eevee", 70, 75, 95, 75),
			new NormalPokemon("Snorlax", 120, 70, 80, 30),
			new PsychicPokemon("Mew", 100, 100, 100, 100),
			new DarkPokemon("Darkrai", 70, 90, 90, 125),
			new SteelPokemon("Dialga", 100, 120, 120, 90),
			new GhostPokemon("Mimikyu", 55, 90, 80, 95),
			new RockPokemon("Tyranitar", 100, 135, 110, 65),
			new FightingPokemon("Lucario", 70, 110, 70, 90),
			new DragonPokemon("Rayquaza", 105, 150, 90, 95),
			new IcePokemon("Articuno", 90, 85, 100, 85),
			new FairyPokemon("Diancie", 50, 100, 150, 50)
	};
	
	public static Pokemon copy(String species) {
		for (Pokemon x : pokemonSpecies) {
			if (x.getName() == species) {
				return new Pokemon(x);
			}
		}
		
		// should probably return an exception...
		return null;
	}
}