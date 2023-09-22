import java.util.ArrayList;
import java.util.List;

public class FindCombinations {
    public static void main(String[] args) {
        double[] numbers = {15.60, 23.33, 23.74, 14.66, 89.23, 7.83, 28.82, 42.00, 
        		8.90, 46.06, 85.72, 53.66, 91.81, 92.55, 7.21, 18.21, 51.49, 16.03, 27.70,
        		80.57, 93.85, 41.00, 39.57, 39.20, 7.15, 19.00};
        double targetSum = 78.89;
        List<List<Double>> combinations = findCombinations(numbers, targetSum);

        for (List<Double> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Double>> findCombinations(double[] numbers, double targetSum) {
        List<List<Double>> result = new ArrayList<>();
        findCombinationsHelper(numbers, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinationsHelper(double[] numbers, double remainingSum, int startIndex,
                                               List<Double> currentCombination, List<List<Double>> result) {
        if (remainingSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingSum < 0 || startIndex >= numbers.length) {
            return;
        }

        // Include the current number in the combination
        currentCombination.add(numbers[startIndex]);
        findCombinationsHelper(numbers, remainingSum - numbers[startIndex], startIndex + 1, currentCombination, result);

        // Exclude the current number from the combination
        currentCombination.remove(currentCombination.size() - 1);
        findCombinationsHelper(numbers, remainingSum, startIndex + 1, currentCombination, result);
    }
}
