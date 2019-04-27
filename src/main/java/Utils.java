import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static final String COUNTING_SORT = "counting sort";
    public static final String INSERTION_SORT = "insertion sort";
    public static final String QUICK_SORT = "quick sort";

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

    public static double getExecutionTimeFor(String algorithm, int[] array, boolean printSortedArray) {
        long startTime;
        long endTime;

        switch (algorithm.toLowerCase()) {
            case INSERTION_SORT:
                startTime = System.nanoTime();
                InsertionSort.sort(array);
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
            case "":
                startTime = System.nanoTime();
                CountingSort.sort(array);
                endTime = System.nanoTime();
                break;
            case "2":
                startTime = System.nanoTime();
                CountingSort.sort(array);
                endTime = System.nanoTime();
                break;
            default:
                throw new RuntimeException("That is not a valid option");
        }

        double totalTime = endTime - startTime;
        if (printSortedArray) {
            System.out.println("Sorted array: " + Arrays.toString(array));
        }
       // System.out.println(algorithm + " took: " + totalTime);
        return totalTime;
    }

    public static double getAverageTimeFor(String algorithm, int[] array) {
        double[] arrays = new double[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = getExecutionTimeFor(algorithm, array, false);
        }
        double averageTime = Utils.getAverage(arrays);
        System.out.println("Average time for : " +algorithm +" "+ averageTime);
        return averageTime;
    }

}
