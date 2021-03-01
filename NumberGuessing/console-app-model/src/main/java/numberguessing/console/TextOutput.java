package numberguessing.console;

final class TextOutput {
    private final StringBuffer buffer = new StringBuffer();

    public TextOutput(String initialOutput) {
        buffer.append(initialOutput);
    }

    public void printLines(String... lines) {
        buffer.append(String.join(System.lineSeparator(), lines));
    }

    public String flush() {
        String output = buffer.toString();
        buffer.setLength(0);
        return output;
    }
}
