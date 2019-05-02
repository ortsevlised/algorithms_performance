public class InsertionSort {


    /**
     * Basic insertion sort function
     * Each time we find that the key is less than an element to its left,
     * we slide that element one position to the right, since we know that the key will have
     * to go to that element's left, then [j+1] will be the new key.
     * @param arrayToSort
     * @param left minimum index value
     * @param right maximum index value
     * @return a sorted array
     */
    public static int[] sort(int[] arrayToSort, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arrayToSort[i];
            int j = i - 1;

            while (j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j + 1] = key;
        }
        return arrayToSort;

    }
}
