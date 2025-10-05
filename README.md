# Shell Sort Performance Analysis

This project is a Java implementation of the **Shell Sort algorithm**. It was created to analyze and compare the performance of different gap sequences on various types of data.

This was built for a university assignment in a Data Structures and Algorithms course.

## Features

  * **Three Gap Sequences**: Includes three popular gap sequences for comparison:
      * `SHELL`: The original sequence (`n/2, n/4, ...`)
      * `KNUTH`: Knuth's sequence (`(3^k - 1) / 2`)
      * `SEDGEWICK`: One of Sedgewick's sequences
  * **Performance Metrics**: A `PerformanceTracker` class counts the exact number of **comparisons** and **swaps** for each sort.
  * **Full Benchmark Suite**: A `BenchmarkRunner` tests the algorithm against:
      * Different array sizes (`100`, `1,000`, `10,000`, `100,000`).
      * Four data types: **random**, **sorted**, **reverse-sorted**, and **nearly-sorted**.
  * **CSV Export**: All benchmark results are automatically saved to a `benchmark_results.csv` file, ready for plotting and analysis.

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
4.  Run the main benchmark command. This will execute all tests.
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
            │   └── ShellSort.java      # The main algorithm logic
            ├── cli
            │   └── BenchmarkRunner.java  # The app that runs the tests
            └── metrics
                └── PerformanceTracker.java # The class that counts metrics
```
