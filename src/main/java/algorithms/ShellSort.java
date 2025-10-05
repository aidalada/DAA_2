package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {

    public enum GapSequence {
        SHELL,
        KNUTH,
        SEDGEWICK
    }

    /**
     * @param arr
     * @param sequence
     * @param tracker
     */
    public void sort(int[] arr, GapSequence sequence, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        int[] gaps;
        switch (sequence) {
            case KNUTH:
                gaps = generateKnuthGaps(n);
                break;
            case SEDGEWICK:
                gaps = generateSedgewickGaps(n);
                break;
            case SHELL:
            default:
                gaps = generateShellGaps(n);
                break;
        }

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap) {
                    tracker.incrementComparisons();
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        tracker.incrementSwaps();
                        j -= gap;
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
    }



    private int[] generateShellGaps(int n) {
        java.util.List<Integer> gaps = new java.util.ArrayList<>();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            gaps.add(gap);
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }


    private int[] generateKnuthGaps(int n) {
        java.util.List<Integer> gaps = new java.util.ArrayList<>();
        int gap = 1;
        while (gap < n / 3) {
            gaps.add(0, gap);
            gap = 3 * gap + 1;
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }

    private int[] generateSedgewickGaps(int n) {
        java.util.List<Integer> gaps = new java.util.ArrayList<>();
        int k = 1;
        while (true) {
            long gap1 = (long)Math.pow(4, k) + 3 * (long)Math.pow(2, k - 1) + 1;
            if (gap1 < n) {
                gaps.add(0, (int)gap1);
            } else {
                break;
            }
            k++;
        }
        if (gaps.isEmpty()) {
            gaps.add(1);
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }
}