package numberguessing;

public final class PositiveIntegerGeneratorStub implements PositiveIntegerGenerator {

    private final int[] numbers;
    private int index;

    public PositiveIntegerGeneratorStub(int... numbers) {
        this.numbers = numbers;
        index = 0;
    }

    @Override
    public int generateLessThanOrEqualToHundread() {
        int number = this.numbers[index];
        index = (index + 1) % numbers.length;
        return number;
    }
}
