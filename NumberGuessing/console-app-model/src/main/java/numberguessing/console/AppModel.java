package numberguessing.console;

import numberguessing.PositiveIntegerGenerator;

public final class AppModel {
    private static final String selectModeMessage = String.join(System.lineSeparator(), "1: Single player game",
            "2: Multiplayer game", "3: Exit", "Enter selection: ");

    private interface Processor {
        Processor run(String input);
    }

    private final StringBuffer outputBuffer;
    private final PositiveIntegerGenerator generator;
    private boolean completed;
    private Processor processor;

    public AppModel(PositiveIntegerGenerator generator) {
        outputBuffer = new StringBuffer(selectModeMessage);
        this.generator = generator;
        completed = false;
        processor = this::processSelection;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String flushOutput() {
        String output = outputBuffer.toString();
        outputBuffer.setLength(0);
        return output;
    }

    public void processInput(String input) {
        processor = processor.run(input);
    }

    private Processor processSelection(String input) {
        if (input.startsWith("1")) {
            int answer = generator.generateLessThanOrEqualToHundread();
            println("Single player game");
            println("I'm thinking of a number between 1 and 100.");
            print("Enter your guess: ");
            return getPlayProcessor(answer, 1);
        } else {
            completed = true;
            return null;
        }
    }

    private Processor getPlayProcessor(int answer, int tries) {
        return input -> {
            int guess = Integer.parseInt(input);
            if (guess < answer) {
                println("Your guess is too low.");
                print("Enter your guess: ");
                return getPlayProcessor(answer, tries + 1);
            } else if (guess > answer) {
                println("Your guess is too high.");
                print("Enter your guess: ");
                return getPlayProcessor(answer, tries + 1);
            } else {
                println("Correct! " + tries + (tries == 1 ? " guess." : " guesses."));
                print(selectModeMessage);
                return this::processSelection;
            }
        };
    }

    private void print(String s) {
        outputBuffer.append(s);
    }

    private void println(String line) {
        outputBuffer.append(line);
        outputBuffer.append(System.lineSeparator());
    }
}
