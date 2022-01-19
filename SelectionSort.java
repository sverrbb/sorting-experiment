/* SELECTION SORT - Time complexity O(N^2) */

class SelectionSort{

  public static void sort(int[] A){
    // Outer for-loop, iterate trough array A
    for(int i = 0; i < A.length; i++){
      int k = i;

      /* Inner for-loop. Iterate throug array for all elements
         after A[i]. Check if there is a smaller element than A[k] */
      for(int j = i + 1; j < A.length; j++){
        if(A[j] < A[k]){
          k = j;
        }
      }

      // If A[k] is less than A[i]
      if(i != k){
        // Swap the numbers
        swap(A, i, k);
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
