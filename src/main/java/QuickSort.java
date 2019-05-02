public class QuickSort {

    public static int[] sort(int[] arrayToSort) {
        return quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    /**
     *
     * @param array
     * @param lowerIndex
     * @param higherIndex
     * @return a sorted array
     */
    private static int[] quickSort(int[] array, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration it'll identify a number from left side greater than the pivot value, and also it'll identify a number
             * from right side lesser than the pivot. Once the search is completed it exchanges both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                Utils.swap(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);

        return array;
    }
}
