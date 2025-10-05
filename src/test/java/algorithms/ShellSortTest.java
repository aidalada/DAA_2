package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import metrics.PerformanceTracker;

class ShellSortTest {

    private ShellSort sorter;
    private PerformanceTracker tracker;

    @BeforeEach
    void setUp() {
        sorter = new ShellSort();
        tracker = new PerformanceTracker();
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        sorter.sort(arr, ShellSort.GapSequence.SHELL, tracker);
        assertArrayEquals(new int[]{}, arr, "Should handle empty array correctly");
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        sorter.sort(arr, ShellSort.GapSequence.SHELL, tracker);
        assertArrayEquals(new int[]{42}, arr, "An array with one element should remain unchanged.");
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {10, 20, 30, 40, 50};
        int[] sortedArr = {10, 20, 30, 40, 50};
        sorter.sort(arr, ShellSort.GapSequence.KNUTH, tracker);
        assertArrayEquals(sortedArr, arr, "An already sorted array should remain sorted.");
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {50, 40, 30, 20, 10};
        int[] sortedArr = {10, 20, 30, 40, 50};
        sorter.sort(arr, ShellSort.GapSequence.SEDGEWICK, tracker);
        assertArrayEquals(sortedArr, arr, "An array sorted in reverse order must be sorted correctly.");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 2, 8, 2, 9, 5, 8};
        int[] sortedArr = {2, 2, 5, 5, 8, 8, 9};
        sorter.sort(arr, ShellSort.GapSequence.SHELL, tracker);
        assertArrayEquals(sortedArr, arr, "An array with duplicates must be sorted correctly.");
    }

    @Test
    void testRandomArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedArr = {11, 12, 22, 25, 34, 64, 90};
        sorter.sort(arr, ShellSort.GapSequence.KNUTH, tracker);
        assertArrayEquals(sortedArr, arr, "An array with random elements must be sorted correctly.");
    }
}