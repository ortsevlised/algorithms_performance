public class MergeSort {


    public static void merge(int arr[], int left, int middle, int right) {
        // Find sizes of sub arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temp arrays
        int tempLeft[] = new int[n1];
        int temRight[] = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            tempLeft[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            temRight[j] = arr[middle + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarray
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (tempLeft[i] <= temRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = temRight[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of tempLeft array if any
        while (i < n1) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        //Copy remaining elements of tempRight array if any
        while (j < n2) {
            arr[k] = temRight[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..right] using
    // merge()
   private static int [] sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
        return arr;
    }

    public static int [] sort(int arrayToSort[]) {
        return sort(arrayToSort, 0, arrayToSort.length - 1);
    }


}
