# Sorting Experiment
This experiment implements several of the most commonly used sorting algorithms, and compares runtime and efficiency between them. The purpose of the experiment is to find the fastest sorting algorithm, and see how the relative run time increases as the input size increases. Finally, I will see how the time-complexity (big-O notation) for each of the algorithms corresponds to the actual results.

## User guide

### Compile:
`javac *.java`

### Run program:
`java Main`

### Menu options
 - Option 1: Run experiment (default values = 100, 1 000, 10 000, 100 000, 1 000 000)
 - Option 2: Test correct sorting for all algorithms (default value = 100)

## Algorithms that are implemented:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Heap Sort
  - Merge Sort
  - Quick Sort
  - Bucket Sort
  - Radix Sort

## Results (in ms.)
| N / Algorithm | Bubble Sort | Selection Sort | Insertion Sort | Heap Sort | Merge Sort | Quick Sort | Bucket Sort | Radix Sort |
|---------------|-------------|----------------|----------------|-----------|------------|------------|-------------|------------|
| 100           | 0.28        | 0.17           | 0.15           | 0.028     | 0.025      | 0.07       | 0.42        | 0.04       |
| 1 000         | 1.67        | 0.99           | 0.33           | 0.21      | 0.16       | 0.19       | 0.80        | 0.46       |
| 10 000        | 210.93      | 81.17          | 27.87          | 2.37      | 1.75       | 1.13       | 1.66        | 1.11       |
| 100 000       | 13455.47    | 3191.57        | 1442           | 11.49     | 14.79      | 7.06       | 29.68       | 6.29       |
| 1 000 000     | 1641144     | 480601         | 152959         | 163.29    | 144.42     | 84.98      | 320.31      | 75.62      |

![Results](https://github.com/sverrbb/sorting-experiment/blob/main/Runtime.png).png)

The graph is displayed on a logarithmic scale to compress the scale and make the data easier to comprehend. The graph can be interpreted in such a way that the lowest lines visually show the fastest algorithms, while the highest lines represent the slowest algorithms.

## Discussion
#### **Bubble Sort:** - O(n^2)
The idea behind bubbleSort is to (1) run through each pair of subsequent elements in the array (2) swap the order of a pair if it is not arranged, and (3) go to (1) if at least one swap occurred. The time-complexity of the algorithm is O(n^2), which is far from ideal for a sorting algorithm. By the graph we can observe that Bubbler Sort is the worst performing algorithm in the experiment.

#### **Selection Sort:** - O(n^2)
Selection sort is a sorting algorithm that selects the smallest element from an unsorted list in each iteration and places that element at the beginning of the unsorted list.

#### **Insertion Sort:** - O(n^2)
Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration. Insertion sort works similarly as we sort cards in our hand in a card game.

#### **Heap Sort:** - O(n log(n))
The concept of heap sort is to eliminate the elements one by one from the heap part of the list, and then insert them into the sorted part of the list.

#### **Merge Sort:** - O(n log(n))
The MergeSort function repeatedly divides the array into two halves until we reach a stage where we try to perform MergeSort on a subarray of size 1 i.e. p == r. After that, the merge function comes into play and combines the sorted arrays into larger arrays until the whole array is merged. Merge Sort is the best performing algorithm for n = 100 and n = 1000.

#### **Quick Sort:** - O(n^2)
Quicksort partitions an array and then calls itself recursively twice to sort the two resulting subarrays. This algorithm is quite efficient for large-sized data sets as its average and worst-case complexity are O(n^2), respectively.

### **Bucket Sort:** - O(N + n)
The idea behind BucketSort is to make N buckets where each bucket corresponds to a category that is arranged. The items we are going to sort have a category, which we call the key. In BucketSort, we place each item in the correct bucket based on the key. Then we run through each bucket and place the items back in the array. The time-complexity of the algorithm is O (N + n), which makes it one of the best performing algorithms.

### **Radix Sort:** - O(d(N + n))
The idea of Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit. To generate a random array for sorting the program uses a seed = 123, which gives a maximum of three digits for the largest number. That could be a reasonable explaination of why the algorithm performes so well.

## Conclusion
The fastest sorting algorithm for
 - n = 100: Merge Sort
 - n = 1 000: Merge Sort
 - n = 10 000: Radix Sort
 - n = 100 000: Radix Sort
 - n = 1 000 000: Radix sort
