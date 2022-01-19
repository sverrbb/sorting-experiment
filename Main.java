import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/*                                 SORTING EXPERIMENT                               */
/*************************************************************************************
  This experiment implements several of the most commonly used sorting algorithms,
  and compares the runtime and efficiency between them. The purpose of the experiment
  is to find the fastest sorting algorithm, and see how the relative run time
  increases as the input size increases.
 *************************************************************************************/

class Main{

  static int runs = 8;
  static int seed = 321;
  static int testSize = 100;

  public static void main(String[] args) {

    // Present menu and choose option
    Scanner input = new Scanner(System.in);
    showMenu();
    System.out.print("\nOption: ");
    int mode = input.nextInt();
    System.out.println();

    // Run chosen option
    switch (mode) {
      case 1:
        timeMeasurements();
        break;
      case 2:
        testCorrectSorting(testSize);
        break;
      default:
        System.out.println("Mode does not exist");
        break;
    }
  }



  /**
   * Menu presented when user run the program
   * Option 1: Performe the experiment for all values
   * Option 2: Checks that each algorithm performes correct sorting
   */
  public static void showMenu(){
    System.out.println("\n**** MENU ****");
    System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    System.out.println("1. Get median measurements for all values of N");
    System.out.println("2. Test program");
  }



  /**
   * Measure runtime for each algorithm with different input-sizes
   * Stores all values in time-tables and used the method
   * getMedianMeasurements() to print out the runtime for each
   * algorithm for each input size n
   */
  public static void timeMeasurements(){

  int allN[] = {100, 1000, 10000, 100000 /*1000000*/ };
    int length = allN.length;

    // Tables used to store runtimes for each value
    double[][] bubble = new double[length][runs];
    double[][] selection = new double[length][runs];
    double[][] insertion = new double[length][runs];
    double[][] heap = new double[length][runs];
    double[][] merge = new double[length][runs];
    double[][] quick = new double[length][runs];
    double[][] bucket = new double[length][runs];
    double[][] radix = new double[length][runs];

    System.out.println("Measures runtime for all values...");

    for(int i = 0; i < length; i++){
      for(int j = 0; j < runs; j++){

        // Measure runtime using Bubble Sort
        int [] array1 = randomArray(allN[i], seed);
        long startTime = System.nanoTime();
        BubbleSort.sort(array1);
        double time = (System.nanoTime() - startTime) / 1000000.0;
        bubble[i][j] = time;
        System.gc();

        // Measure runtime using Selection Sort
        int [] array2 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        SelectionSort.sort(array2);
        time = (System.nanoTime() - startTime) / 1000000.0;
        selection[i][j] = time;
        System.gc();

        // Measure runtime using Insertion Sort
        int [] array3 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        InsertionSort.sort(array3);
        time = (System.nanoTime() - startTime) / 1000000.0;
        insertion[i][j] = time;
        System.gc();

        // Measure runtime using Heap Sort
        int [] array4 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        HeapSort.sort(array4);
        time = (System.nanoTime() - startTime) / 1000000.0;
        heap[i][j] = time;
        System.gc();

        // Measure runtime using Merge Sort
        int [] array5 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        MergeSort.sort(array5, 0, array5.length-1);
        time = (System.nanoTime() - startTime) / 1000000.0;
        merge[i][j] = time;
        System.gc();

        // Measure runtime using Quick Sort
        int [] array6 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        QuickSort.quickSort(array6, 0, array6.length-1);
        time = (System.nanoTime() - startTime) / 1000000.0;
        quick[i][j] = time;
        System.gc();

        // Measure runtime using Bucket Sort
        int [] array7 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        BucketSort.sort(array7, array7.length);
        time = (System.nanoTime() - startTime) / 1000000.0;
        bucket[i][j] = time;
        System.gc();

        // Measure runtime using Radix Sort
        int [] array8 = randomArray(allN[i], seed);
        startTime = System.nanoTime();
        RadixSort.sort(array8, array8.length);
        time = (System.nanoTime() - startTime) / 1000000.0;
        radix[i][j] = time;
        System.gc();
      }
      System.out.println(" - Measurements for n = " + allN[i] + " done");
    }
    System.out.println();

    // Prints median measurements
    getMedianMeasurements(bubble,    "Bubble Sort",    allN);
    getMedianMeasurements(selection,  "Selection Sort", allN);
    getMedianMeasurements(insertion,  "Insertion Sort", allN);
    getMedianMeasurements(heap,      "Heap Sort",      allN);
    getMedianMeasurements(merge,     "Merge Sort",     allN);
    getMedianMeasurements(quick,    "Quick Sort",     allN);
    getMedianMeasurements(bucket,   "Bucket Sort",    allN);
    getMedianMeasurements(radix,     "Radix Sort",     allN);

  }



  /**
   * Method prints out median runtime for each value
   * @param timeTable - unsorted table of runtime for each value
   * @param name - name of the algorithm
   * @param n - All values used for sorting
   */
  public static void getMedianMeasurements(double[][] timeTable,  String name, int n[]){

    // Sort rintimes for each value
    for(int j = 0; j < n.length; j++){
      Arrays.sort(timeTable[j]);
    }

    System.out.println("      **** " + name + " ****   ");
    System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

    // Print out median runtima for each value
    int median = runs / 2;
    for(int i = 0; i < n.length; i++){
      System.out.println("• Runtime median - " + "n = " + n[i] + ": " + timeTable[i][median] + " ms");
    }

    System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    System.out.println("\n");
  }



  /**
   * Test correct sorting result for each sorting-algorithm
   * Uses the Arrays.sort() method in Java as a comparison
   * @param n - size of array to be sorted
   */
  public static void testCorrectSorting(int n){
    System.out.println("      **** TEST PROGRAM ****   ");
    System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

    // Sorting array using Arrays.sort
    int [] array = randomArray(n, seed);
    Arrays.sort(array);

    // Sorting array using Bubble Sort
    int [] array1 = randomArray(n, seed);
    BubbleSort.sort(array1);
    boolean test1 = compareAlgorithms(array, array1, "Bubble Sort");

    // Sorting array using Selection Sort
    int [] array2 = randomArray(n, seed);
    SelectionSort.sort(array2);
    boolean test2 = compareAlgorithms(array, array2, "Selection Sort");

    // Sorting array using Insertion Sort
    int [] array3 = randomArray(n, seed);
    InsertionSort.sort(array3);
    boolean test3 = compareAlgorithms(array, array3, "Insertion Sort");

    // Sorting array using Heap Sort
    int [] array4 = randomArray(n, seed);
    HeapSort.sort(array4);
    boolean test4 = compareAlgorithms(array, array4, "Heap Sort");

    // Sorting array using Merge Sort
    int [] array5 = randomArray(n, seed);
    MergeSort.sort(array5, 0, array5.length-1);
    boolean test5 = compareAlgorithms(array, array5, "Merge Sort");

    // Sorting array using Quick Sort
    int [] array6 = randomArray(n, seed);
    QuickSort.quickSort(array6, 0, array6.length-1);
    boolean test6 = compareAlgorithms(array, array6, "Quick Sort");

    // Sorting array using Bucket Sort
    int [] array7 = randomArray(n, seed);
    BucketSort.sort(array7, array7.length);
    boolean test7 = compareAlgorithms(array, array7, "Bucket Sort");

    // Sorting array using Radix Sort
    int [] array8 = randomArray(n, seed);
    RadixSort.sort(array8, array8.length);
    boolean test8 = compareAlgorithms(array, array8, "Radix Sort");

    System.out.println();
  }



  /**
   * Compare results between towo sorting algorithms
   * @param array1 - first array to be compared
   * @param array2 - second array to be comared
   * @param name - Name of the sorting algorithm
   * @return boolean value if arrays are simular or not
   */
  public static boolean compareAlgorithms(int[] array1, int[] array2, String name){
    if(!checkIndexes(array1, array2)){
      System.out.println(" - Error: " + name);
      return false;
    }else{
      System.out.println(" - " + name + " passed");
    }
    return true;
  }



  /**
   * Compare each index between two arrays
   * @param A - first array to be compared
   * @param B - second array to be comared
   * @return boolean value if arrays are simular or not
   */
  public static boolean checkIndexes(int[] A, int[] B){
    for(int i = 0; i < A.length; i++){
      if(A[i] != B[i]){
        return false;
      }
    }
    return true;
  }



  /**
   * Method for generating random array
   * @param n - number of integers in array
   * @param seed - unique numbers in array
   * @return generated array
   */
  public static int[] randomArray(int n, int seed) {
    Random random = new Random(seed);
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = random.nextInt(n);
    }
    return a;
  }

}
