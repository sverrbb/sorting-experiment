/* HEAP SORT - Time complexity O(n log(n)) */

class HeapSort{

    /* Performe the heap sort */
    public static void sort(int A[]){
      buildMaxHeap(A, A.length);
      for (int i = A.length - 1; i > 0; i--) {
        swap(A, 0, i);
        bubbleDown(A, i, 0);
      }
    }

    /* Builds a max heap from array */
    public static void buildMaxHeap(int[] A, int n){
      for (int i = n / 2 - 1; i >= 0; i--){
        bubbleDown(A, n, i);
      }
    }

    /* Reshaping a binary tree into a Heap data structure */
    public static void bubbleDown(int A[], int n, int i){
      int largest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;

      if (left < n && A[left] > A[largest])
        largest = left;

      if (right < n && A[right] > A[largest])
        largest = right;

      if (largest != i) {
        swap(A, i, largest);
        bubbleDown(A, n, largest);
      }
    }

    /* Swap values i, j in A */
    public static void swap(int[] A, int i, int j){
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
    }
}
