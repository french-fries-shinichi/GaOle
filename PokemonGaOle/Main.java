package test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stage stage = new Stage("Forest Zone");

        // Show catch-time Pokémons
        List<Pokemon> choices = new ArrayList<>(stage.getCatchTimePokemons());
        System.out.println("You encountered the following Pokémon:");

        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }

        // Input: player chooses 1 of the 2
        int choice = -1;
        while (choice < 1 || choice > choices.size()) {
            System.out.print("Choose 1 Pokémon to capture (enter 1 or 2): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.next(); // clear invalid input
            }
        }

        Pokemon chosenPokemon = choices.get(choice - 1);
        stage.setCapturedPokemon(chosenPokemon);

        // Display result
        System.out.println("\nYou captured: " + chosenPokemon);
        stage.displayStageInfo();

        scanner.close();
    }
}

