import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomIntegerAnalysis {

    private List<Integer> randomIntegers;

    public RandomIntegerAnalysis(int count) {
        generateRandomIntegers(count);
    }

    private void generateRandomIntegers(int count) {
        Random random = new Random();
        randomIntegers = IntStream.range(0, count)
                .map(i -> random.nextInt(2001) - 1000) // Generates numbers between -1000 and 1000
                .boxed()
                .collect(Collectors.toList());
    }

    public void performAnalysis() {
        long positiveCount = randomIntegers.stream()
                .filter(n -> n > 0)
                .count();

        long negativeCount = randomIntegers.stream()
                .filter(n -> n < 0)
                .count();

        long twoDigitCount = randomIntegers.stream()
                .filter(n -> Math.abs(n) >= 10 && Math.abs(n) <= 99)
                .count();

        long palindromicCount = randomIntegers.stream()
                .filter(this::isPalindromic)
                .count();

        System.out.println("Total numbers generated: " + randomIntegers.size());
        System.out.println("Positive numbers: " + positiveCount);
        System.out.println("Negative numbers: " + negativeCount);
        System.out.println("Two-digit numbers: " + twoDigitCount);
        System.out.println("Palindromic numbers: " + palindromicCount);
    }

    private boolean isPalindromic(int number) {
        String numStr = String.valueOf(Math.abs(number));
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    // For testing purposes
    public static void main(String[] args) {
        RandomIntegerAnalysis analysis = new RandomIntegerAnalysis(100);
        analysis.performAnalysis();
    }
}
