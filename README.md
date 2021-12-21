# Sorting Experiment
This experiment implements several of the most commonly used sorting algorithms, and compares runtime and efficiency between them. The purpose of the experiment is to find the fastest sorting algorithm, and see how the relative run time increases as the input size increases. Finally, I will see how the time-complexity (big-O notation) for each of the algorithms corresponds to the actual results.

## User guide

### Compile:
 - javac * .java

### Run program:
 - java Main

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

![Results](https://github.com/sverrbb/sorting-experiment/blob/main/Results.png)


## Discussion
- Bubble Sort - O(n^2)

- Selection Sort - O(n^2)

- Insertion Sort - O(n^2)

- Heap Sort - O(n log(n))

- Merge Sort - O(n log(n))

- Quick Sort - O(n^2)

- Bucket Sort O(N + n)

- Radix Sort - O(d(N + n))

## Conclusion
The fastest sorting algorithm for
 - n = 100: Merge Sort
 - n = 1 000: Merge Sort
 - n = 10 000: Radix Sort
 - n = 100 000: Radix Sort
 - n = 1 000 000: Radix sort
