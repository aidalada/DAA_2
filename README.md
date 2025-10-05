# Heap Sort Performance Analysis

This project is a Java implementation of the **Heap Sort** algorithm. It was built to sort arrays efficiently and to analyze its performance by tracking key metrics like swaps and comparisons.

This was created for a university assignment in a Data Structures and Algorithms course.

## Features

  * **In-place Sorting**: Sorts the array without using significant extra memory. This means it has an **O(1) space complexity**.
  * **Efficient Heap Building**: Uses a bottom-up `heapify` method to build the initial max-heap in linear time.
  * **Detailed Metrics**: A `PerformanceTracker` class counts the number of **comparisons**, **swaps**, and **array accesses** during the sort.
  * **Unit Tested**: Includes a suite of JUnit tests to ensure correctness for edge cases, including empty arrays, sorted/reversed data, and arrays with duplicates.

## Requirements

  * **Java** (JDK 11 or newer)
  * **Apache Maven**

## How to Run the Benchmark

1.  Clone this repository to your computer.
2.  Open a terminal in the project's root folder.
3.  Compile the project using Maven. This will also download any needed libraries.
    ```bash
    mvn package
    ```
4.  Run the main benchmark command to execute all tests.
    ```bash
    mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
    ```

After the run is complete, a file named **`benchmark_results.csv`** will be created in the main project folder.

## Project Structure

```
.
├── pom.xml                   # Maven project configuration
└── src
    └── main
        └── java
            ├── algorithms
            │   └── HeapSort.java       # The main algorithm logic
            ├── cli
            │   └── BenchmarkRunner.java  # Runs the performance tests
            └── metrics
                └── PerformanceTracker.java # Counts the metrics
```

## Visualization of results
<img width="1149" height="754" alt="Screenshot_20251005_230657" src="https://github.com/user-attachments/assets/35f4d120-95c1-4779-b0b7-97f130dc1535" />

<img width="1290" height="754" alt="Screenshot_20251005_230747" src="https://github.com/user-attachments/assets/f3aace22-47b3-45f8-b98e-c20a5e45033f" />

<img width="1290" height="959" alt="Screenshot_20251005_230819" src="https://github.com/user-attachments/assets/e42fff55-3a0f-4500-8c8f-e46c7e2f038f" />



