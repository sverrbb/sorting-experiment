/* BUBBLE SORT - Time complexity O(N^2) */

class BubbleSort {

  // BubbleSort method
  public static void sort(int[] A) {

    // Outer loop
    for(int i = 0; i < A.length - 1; i++) {

      // Inner loop
      for(int j = 0; j < A.length - i - 1; j++) {

        // If number is greater than the number on the following index
        if(A[j] > A[j + 1]) {

          // Swap the numbers
          swap(A, j, j + 1);

        }
      }
    }
  }

  /* Swap values i, j in A */
  public static void swap(int[] A, int i, int j){
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
  }

}
