public class IntroSort {

    public static final int INSERTION_SORT_LIMIT = 16;
    private static int array[];
    private static int n;

    /**
     * @param arrayToSort
     * @return
     */
    public static int[] sort(int[] arrayToSort) {
        array = arrayToSort;
        n = array.length;
        sortData();
        return arrayToSort;
    }

    /**
     * Set the depthLimit
     * and start the sorting
     */
    private static void sortData() {
        int depthLimit = (int) (2 * Math.floor(Math.log(n) / Math.log(2)));
        sortDataUtil(0, n - 1, depthLimit);
    }

    /**
     * Main function that implements IntroSort
     *
     * @param begin      Beginning index
     * @param end        Ending index
     * @param depthLimit recursion level
     */
    private static void sortDataUtil(int begin, int end, int depthLimit) {
        if (end - begin > INSERTION_SORT_LIMIT) { //Checks for the input size so it can decide whether it should use insertion quicksort, or heapsort
            if (depthLimit == 0) { // if the input size is bigger than INSERTION_SORT_LIMIT and we already reached the depth limit we use heapsort
                heapSort(begin, end);
                return;
            }
            // otherwise we use quick sort
            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin, begin + ((end - begin) / 2) + 1, end); // we find the pivot using the median of 3 concept
            Utils.swap(array, pivot, end);

            int p = partition(begin, end); //we set p at the right position in the array

            sortDataUtil(begin, p - 1, depthLimit); //sort elements
            sortDataUtil(p + 1, end, depthLimit); //sort elements
        } else {
            // if the input size is less or equals than INSERTION_SORT_LIMIT use insertion sort
            InsertionSort.sort(array, begin, end);
        }
    }

    /**
     * Median of 3 implementation
     *
     * @param a1 first element
     * @param b1 middle element
     * @param c1 last element
     * @return the median of 3
     */
    private static int findPivot(int a1, int b1, int c1) {
        int max = Math.max(Math.max(array[a1], array[b1]), array[c1]);
        int min = Math.min(Math.min(array[a1], array[b1]), array[c1]);
        int median = max ^ min ^ array[a1] ^ array[b1] ^ array[c1];
        if (median == array[a1])
            return a1;
        if (median == array[b1])
            return b1;
        return c1;
    }

    /**
     * Takes the last element as pivot and it places it in the right position
     * places all smaller elements than the pivot to its left and greater to the right
     *
     * @param low  first index in the array
     * @param high last index in the array
     * @return
     */
    private static int partition(int low, int high) {
        int pivot = array[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {// If the current element is smaller or equal than the pivot
                i++;                 // increment index of smaller element
                Utils.swap(array, i, j);
            }
        }
        Utils.swap(array, i + 1, high);
        return (i + 1);
    }


    /**
     * To maxHeap array subtree rooted with node i which is an index in array[]. heapN is size of heap
     *
     * @param i
     * @param heapN
     * @param begin
     */
    private static void maxHeap(int i, int heapN, int begin) {
        int temp = array[begin + i - 1];
        int child;

        while (i <= heapN / 2) {
            child = 2 * i;

            if (child < heapN
                    && array[begin + child - 1] < array[begin + child])
                child++;

            if (temp >= array[begin + child - 1])
                break;

            array[begin + i - 1] = array[begin + child - 1];
            i = child;
        }
        array[begin + i - 1] = temp;
    }

    /**
     * Builds the heap (rearranging the array)
     *
     * @param begin
     * @param end
     * @param heapN
     */

    private static void heapify(int begin, int end, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }

    /**
     * heapsort
     *
     * @param begin
     * @param end
     */
    private static void heapSort(int begin, int end) {
        int heapN = end - begin;
        heapify(begin, end, heapN); // Build heap (rearrange array)

        for (int i = heapN; i >= 1; i--) { // One by one extract an element from heap
            Utils.swap(array, begin, begin + i); // Move current root to end
            maxHeap(1, i, begin); // call maxHeap() on the reduced heap
        }
    }


}



