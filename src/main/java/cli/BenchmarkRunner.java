package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    private enum ArrayType {
        RANDOM,
        SORTED,
        REVERSE_SORTED,
        NEARLY_SORTED
    }

    static void main(String[] args) {
        System.out.println("--- Starting performance test for ShellSort ---");

        int[] inputSizes = {100, 1000, 10000, 100000};
        ShellSort sorter = new ShellSort();
        StringBuilder csvOutput = new StringBuilder("ArrayType,Size,Sequence,Time(ms),Comparisons,Swaps\n");

        for (int size : inputSizes) {
            for (ArrayType type : ArrayType.values()) {
                System.out.printf("\n--- Testing Size: %d, Type: %s ---\n", size, type);
                int[] originalArray = generateArray(type, size);

                for (ShellSort.GapSequence sequence : ShellSort.GapSequence.values()) {
                    int[] arrayToSort = originalArray.clone();
                    PerformanceTracker tracker = new PerformanceTracker();

                    long startTime = System.nanoTime();
                    sorter.sort(arrayToSort, sequence, tracker);
                    long endTime = System.nanoTime();
                    long durationMs = (endTime - startTime) / 1_000_000;

                    System.out.printf("Sequence: %-10s | Time: %4d ms | Comparisons: %12d | Swaps: %12d\n",
                            sequence, durationMs, tracker.getComparisons(), tracker.getSwaps());

                    String csvLine = String.format("%s,%d,%s,%d,%d,%d\n",
                            type, size, sequence, durationMs, tracker.getComparisons(), tracker.getSwaps());
                    csvOutput.append(csvLine);
                }
            }
        }
        writeResultsToFile(csvOutput.toString());
    }

    private static int[] generateArray(ArrayType type, int size) {
        return switch (type) {
            case SORTED -> generateSortedArray(size);
            case REVERSE_SORTED -> generateReverseSortedArray(size);
            case NEARLY_SORTED -> generateNearlySortedArray(size);
            case RANDOM -> generateRandomArray(size);
        };
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }

    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - 1 - i;
        }
        return array;
    }

    private static int[] generateNearlySortedArray(int size) {
        int[] array = generateSortedArray(size);
        Random random = new Random();
        int swaps = (int) (size * 0.1);
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    private static void writeResultsToFile(String data) {
        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write(data);
            System.out.println("\n✅ Benchmark results successfully saved to benchmark_results.csv");
        } catch (IOException e) {
            System.err.println("Error writing results to file: " + e.getMessage());
        }
    }
}