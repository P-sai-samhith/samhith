import java.util.Arrays;
import java.util.Random;

public class SortingBenchmark {

    public static void main(String[] args) {
        // Display system information
        showSystemInfo();
        // Different array sizes
        int[] sizes = {5, 10, 100, 200, 300, 500, 1000, 2000};

        for (int size : sizes) {
            System.out.println("\nBenchmark for Array Size: " + size);

            // Generate an array of random elements for the current size
            int[] arr = createRandomArray(size);

            // Benchmark Bubble Sort
            long start_time_of_algo = System.nanoTime();
            performBubbleSort(arr);
            long end_time_of_algo = System.nanoTime();
            double execution_time = (end_time_of_algo - start_time_of_algo) / 1e6; // Convert to milliseconds
            System.out.println("Execution time for Bubble Sort: " + String.format("%.7f", execution_time) + " milliseconds");

            // Benchmark Insertion Sort
            start_time_of_algo = System.nanoTime();
            performInsertionSort(arr);
            end_time_of_algo = System.nanoTime();
            execution_time = (end_time_of_algo - start_time_of_algo) / 1e6; // Convert to milliseconds
            System.out.println("Execution time for Insertion Sort: " + String.format("%.7f", execution_time) + " milliseconds");

            // Benchmark Selection Sort
            start_time_of_algo = System.nanoTime();
            performSelectionSort(arr);
            end_time_of_algo = System.nanoTime();
            execution_time = (end_time_of_algo - start_time_of_algo) / 1e6; // Convert to milliseconds
            System.out.println("Execution time for Selection Sort: " + String.format("%.7f", execution_time) + " milliseconds");
        }
    }

    // Display system information
    static void showSystemInfo() {
        System.out.println("System Information:");
        System.out.println("Operating System: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("Processor: " + System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Total Memory: " + (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + " MegaBytes");
        System.out.println("Free Space: " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + " MegaBytes");
        System.out.println("Maximum Memory: " + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + " MegaBytes");
        System.out.println("-----------------------------");
    }

    // Bubble Sort
    static void performBubbleSort(int[] arr) {
        System.out.println("\nBubble Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swapping elements
                    int temporary = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporary;
                }
            }
        }
        // Display the sorted array
        //System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Insertion Sort
    static void performInsertionSort(int[] arr) {
        System.out.println("\nInsertion Sort:");
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Shift elements greater than key to the right */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        // Display the sorted array
        //System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Selection Sort
    static void performSelectionSort(int[] arr) {
        System.out.println("\nSelection Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minimumIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temporary = arr[minimumIndex];
            arr[minimumIndex] = arr[i];
            arr[i] = temporary;
        }
        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Generate an array of random elements within a specified range
    static int[] createRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2000); // Assuming random numbers between 0 and 1999
        }
        return arr;
    }
}
