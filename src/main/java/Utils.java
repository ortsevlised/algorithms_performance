import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static final String INSERTION_SORT = "insertion sort";
    public static final String QUICK_SORT = "quick sort";
    public static final String COUNTING_SORT = "counting sort";
    public static final String INTRO_SORT = "intro sort";
    public static final String MERGE_SORT = "merge sort";

    /**
     *
     * @param n the size of the array
     * @return a random array of size n
     */
    public static int[] getRandomArray(int n) {
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] = new Random().nextInt(1000);
        }
        return randomArray;
    }

    /**
     * Gets the sum of the values of each index of the array
     * and it divides it by the total of elements to calculate
     * the average value
     *
     * @param array
     * @return average value
     */
    public static double getAverage(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    /**
     * Get execution time for the desired algorithm
     * @param algorithm name of the algorithm chosen
     * @param array the array to sort
     * @param printSortedArray whether to print each one of the sorted arrays
     * @return
     */
    public static double getExecutionTimeFor(String algorithm, int[] array, boolean printSortedArray) {
        long startTime;
        long endTime;

        switch (algorithm.toLowerCase()) {
            case INSERTION_SORT:
                startTime = System.nanoTime();
                InsertionSort.sort(array, 0, array.length - 1);
                endTime = System.nanoTime();
                break;
            case QUICK_SORT:
                startTime = System.nanoTime();
                QuickSort.sort(array);
                endTime = System.nanoTime();
                break;
            case COUNTING_SORT:
                startTime = System.nanoTime();
                CountingSort.sort(array);
                endTime = System.nanoTime();
                break;
            case INTRO_SORT:
                startTime = System.nanoTime();
                IntroSort.sort(array);
                endTime = System.nanoTime();
                break;
            case MERGE_SORT:
                startTime = System.nanoTime();
                MergeSort.sort(array);
                endTime = System.nanoTime();
                break;
            default:
                throw new RuntimeException("That is not a valid option");
        }

        double totalTime = (endTime - startTime) / 1000000.0;

        if (printSortedArray) {
            System.out.println("Sorted array: " + Arrays.toString(array));
        }
        return totalTime;
    }

    /**
     * Get the average execution time for an algorithm
     * @param algorithm
     * @param array
     * @return
     */
    public static double getAverageTimeFor(String algorithm, int[] array) {
        double[] arrays = new double[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = getExecutionTimeFor(algorithm, array, false);
        }
        double averageTime = Utils.getAverage(arrays);

        System.out.print(algorithm + " - input size " + String.format("%5d", array.length) + ": " + String.format("%f", averageTime) + " ms"
                + (algorithm.equalsIgnoreCase(INTRO_SORT) ? "\t|\n" : "\t| "));
        return averageTime;
    }

    /**
     * Swaps the elements for a given array
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
