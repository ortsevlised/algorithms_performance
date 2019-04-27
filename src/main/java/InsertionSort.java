public class InsertionSort {

    /**
     * The best case input is an array that is already sorted. In this case insertion run has a linear running time (i.e., Θ(n))
     * The simplest worst case input is an array sorted in reverse order.
     * The set of all worst case inputs consists of all arrays where each element is the smallest or second-smallest of the
     * elements before it. In these cases every iteration of the inner loop will scan and shift the entire sorted subsection
     * of the array before inserting the next element. This gives insertion run a quadratic running time (i.e., O(n2)).
     * The average case is also quadratic
     */


    public static int[] sort(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int k = arrayToSort[i];
            int j = i - 1;

            while (j >= 0 && arrayToSort[j] > k) {
                arrayToSort[j + 1] = arrayToSort[j];
                j = j - 1;
            }
            arrayToSort[j + 1] = k;
        }
        return arrayToSort;
    }




}
