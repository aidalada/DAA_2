package metrics;

public class PerformanceTracker {

    private long comparisons;
    private long swaps;

    public PerformanceTracker() {
        this.comparisons = 0;
        this.swaps = 0;
    }

    public void incrementComparisons() {
        this.comparisons++;
    }

    public void incrementSwaps() {
        this.swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public void reset() {
        this.comparisons = 0;
        this.swaps = 0;
    }

    @Override
    public String toString() {
        return "PerformanceMetrics{" +
                "comparisons=" + comparisons +
                ", swaps=" + swaps +
                '}';
    }
}