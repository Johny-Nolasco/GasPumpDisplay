import java.util.ArrayList;

public class GasPumpDisplay {

    private ArrayList<Integer> digits;
    private final int maxDigit; // Maximum value for each digit (inclusive)
    private boolean hasMore; // Flag to indicate if there are more elements to generate

    public GasPumpDisplay(int numberOfPositions, int maxDigit) {
        this.maxDigit = maxDigit;
        this.digits = new ArrayList<>();
        for (int i = 0; i < numberOfPositions; i++) {
            digits.add(0); // Set all places/positions to 0
        }
        this.hasMore = true;
    }

    public String nextElement() {
        if (!hasMore) {
            throw new IllegalStateException("No more elements to generate.");
        }

        // Build the current element as a string
        // Printed before incrementing
        StringBuilder current = new StringBuilder();
        for (int digit : digits) {
            current.append(digit);
        }

        // Increment the digits for the next element
        incrementDigits();

        return current.toString();
    }

    public boolean hasMoreElements() {
        return hasMore;
    }

    private void incrementDigits() {
        // Start incrementing from highest index/rightmost place
        for (int i = digits.size() - 1; i >= 0; i--) {
            int newValue = digits.get(i) + 1;
            if (newValue <= maxDigit) {
                digits.set(i, newValue);
                return; // No carry over, for loop doesn't decrement
            } else {
                digits.set(i, 0); // Carry over, reset current digit to 0
            }
        }

        // If we get here, all digits were reset to 0, meaning we've generated all combinations
        hasMore = false;
    }

    public void reset() {
        // Reset all digits to 0 and allow generation to restart
        for (int i = 0; i < digits.size(); i++) {
            digits.set(i, 0);
        }
        hasMore = true;
    }
}
