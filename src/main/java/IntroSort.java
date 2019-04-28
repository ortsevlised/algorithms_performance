public class IntroSort {


    private static int array[];
    private static int n;


    // To maxHeap array subtree rooted with node i which is
    // an index in array[]. heapN is size of heap
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

    // Function to build the heap (rearranging the array)
    private static void heapify(int begin, int end, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }

    // main function to do heapsort
    private static void heapSort(int begin, int end) {
        int heapN = end - begin;

        // Build heap (rearrange array)
        heapify(begin, end, heapN);

        // One by one extract an element from heap
        for (int i = heapN; i >= 1; i--) {

            // Move current root to end
            Utils.swap(array,begin, begin + i);

            // call maxHeap() on the reduced heap
            maxHeap(1, i, begin);
        }
    }



    // Function for finding the median of the three elements
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

    // This function takes the last element as pivot, places
    // the pivot element at its correct position in sorted
    // array, and places all smaller (smaller than pivot)
    // to the left of the pivot
    // and greater elements to the right of the pivot
    private static int partition(int low, int high) {

        // pivot
        int pivot = array[high];

        // Index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            // If the current element is smaller
            // than or equal to the pivot
            if (array[j] <= pivot) {

                // increment index of smaller element
                i++;
                Utils.swap(array,i, j);
            }
        }
        Utils.swap(array,i + 1, high);
        return (i + 1);
    }

    // The main function that implements IntroSort
    // low  --> Starting index,
    // high  --> Ending index,
    // depthLimit  --> recursion level
    private static void sortDataUtil(int begin, int end, int depthLimit) {
        if (end - begin > 16) {
            if (depthLimit == 0) {

                // if the recursion limit is
                // occurred call heap sort
                heapSort(begin, end);
                return;
            }

            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,
                    begin + ((end - begin) / 2) + 1,
                    end);
            Utils.swap(array,pivot, end);

            // p is partitioning index,
            // arr[p] is now at right place
            int p = partition(begin, end);

            // Separately sort elements before
            // partition and after partition
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);
        } else {
            // if the data set is small,
            // call insertion sort
            InsertionSort.sort(array, begin, end);
        }
    }

    // A utility function to begin the
    // IntroSort module
    private static void sortData() {

        // Initialise the depthLimit
        // as 2*log(length(data))
        int depthLimit
                = (int) (2 * Math.floor(Math.log(n) /
                Math.log(2)));

        sortDataUtil(0, n - 1, depthLimit);

    }



    public static int[] sort(int[] arrayToSort)  {
        array = arrayToSort;
        n = array.length;



        sortData();
        return arrayToSort;
    }
}



