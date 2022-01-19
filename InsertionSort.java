/* INSERTION SORT - Time complexity O(N^2) */

class InsertionSort{

  public static void sort(int[] A){

    // Iterate through A - n times
    for(int i = 0; i < A.length; i++){
      int j = i;

      /* Swap if A[j-1] is greather than A[j]
      Sort all elements to the left side of the array, from
      smalles to largest */
      while(j > 0 && A[j-1] > A[j]){

        // Swap the numbers
        swap(A, j, j-1);

        // Decrease j with 1 for each swap
        j -= 1;
      }
    }
  }


  public static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
}
