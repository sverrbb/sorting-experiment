/* QUICK SORT - Time complexity O(N^2) */

class QuickSort{


  public static void quickSort(int[] A, int low, int high){
    if (low >= high){
      return;
    }

    int p = partition(A, low, high);
    quickSort(A, low, p - 1);
    quickSort(A, p + 1, high);
  }

  public static int partition(int[] arr, int low, int high){

    int pivot = arr[high];
    int i = (low - 1);

    for(int j = low; j <= high - 1; j++){
      if (arr[j] < pivot){
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  /* Swap values i, j in A */
  public static void swap(int[] A, int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

}
