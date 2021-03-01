package numberguessing.console;

import java.util.Arrays;

import numberguessing.PositiveIntegerGenerator;

public final class AppModel {
    private static final String selectModeMessage = String.join(System.lineSeparator(), "1: Single player game",
            "2: Multiplayer game", "3: Exit", "Enter selection: ");

    private interface Processor {
        Processor run(String input);
    }

    private final TextOutput output;
    private final PositiveIntegerGenerator generator;
    private boolean completed;
    private Processor processor;

    public AppModel(PositiveIntegerGenerator generator) {
        output = new TextOutput(selectModeMessage);
        this.generator = generator;
        completed = false;
        processor = this::processSelection;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String flushOutput() {
        return output.flush();
    }

    public void processInput(String input) {
        processor = processor.run(input);
    }

    private Processor processSelection(String input) {
        if (input.startsWith("1")) {
            int answer = generator.generateLessThanOrEqualToHundread();
            printLines("Single player game", "I'm thinking of a number between 1 and 100.", "Enter your guess: ");
            return getSinglePlayerGameProcessor(answer, 1);
        } else if (input.startsWith("2")) {
            printLines("Multiplayer game", "Enter player names separated with commas: ");
            return getPlayerNamesProcessor();
        } else {
            completed = true;
            return null;
        }
    }

    private Processor getPlayerNamesProcessor() {
        return input -> {
            Object[] players = Arrays.stream(input.split(",")).map(String::trim).toArray();
            int answer = generator.generateLessThanOrEqualToHundread();
            printLines("I'm thinking of a number between 1 and 100.", "Enter " + players[0] + "'s guess: ");
            return getMultiplayerGameProcessor(players, answer, 1);
        };
    }

    private Processor getMultiplayerGameProcessor(Object[] players, int answer, int tries) {
        return input -> {
            int guess = Integer.parseInt(input);

            Object currentPlayer = players[(tries - 1) % players.length];
            Object nextPlayer = players[tries % players.length];

            if (guess < answer) {
                printLines(currentPlayer + "'s guess is too low.", "Enter " + nextPlayer + "'s guess: ");
                return getMultiplayerGameProcessor(players, answer, tries + 1);
            } else if (guess > answer) {
                printLines(currentPlayer + "'s guess is too high.", "Enter " + nextPlayer + "'s guess: ");
                return getMultiplayerGameProcessor(players, answer, tries + 1);
            } else {
                printLines("Correct! " + currentPlayer + " wins.", selectModeMessage);
                return this::processSelection;
            }
        };
    }

    private Processor getSinglePlayerGameProcessor(int answer, int tries) {
        return input -> {
            int guess = Integer.parseInt(input);
            if (guess < answer) {
                printLines("Your guess is too low.", "Enter your guess: ");
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else if (guess > answer) {
                printLines("Your guess is too high.", "Enter your guess: ");
                return getSinglePlayerGameProcessor(answer, tries + 1);
            } else {
                printLines("Correct! " + tries + (tries == 1 ? " guess." : " guesses."), selectModeMessage);
                return this::processSelection;
            }
        };
    }

    private void printLines(String... lines) {
        output.printLines(lines);
    }
}
