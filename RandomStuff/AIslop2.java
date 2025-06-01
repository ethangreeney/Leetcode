package RandomStuff;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap; // For thread-safe caching
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.LongStream;

// Using a record for better data structure (Java 14+)
// If using older Java, create a simple class with final fields and a constructor.
record PersistenceResult(int steps, long originalNumber) {
}

class Solution2Improved {

    // Cache for memoizing persistence steps.
    // Key: number, Value: steps from this number to a single digit.
    private static final ConcurrentHashMap<Long, Integer> persistenceStepsCache = new ConcurrentHashMap<>();

    // Helper to calculate the product of digits of a number
    private static long productOfDigits(long n) {
        if (n < 10) { // Single digit
            return n;
        }
        long product = 1;
        while (n > 0) {
            long digit = n % 10;
            if (digit == 0) { // Optimization: if any digit is 0, product is 0
                return 0;
            }
            product *= digit;
            n /= 10;
        }
        return product;
    }

    // Recursive helper to calculate steps with caching
    private static int getStepsRecursive(long currentNum) {
        if (currentNum < 10) {
            return 0; // Base case: single digit number has 0 more steps
        }

        // Check cache
        Integer cachedSteps = persistenceStepsCache.get(currentNum);
        if (cachedSteps != null) {
            return cachedSteps;
        }

        long product = productOfDigits(currentNum);
        int steps;

        // If product is 0 (and currentNum wasn't 0), this counts as 1 step to reach 0.
        // e.g., 10 -> 0 (1 step). productOfDigits(10) is 0.
        if (product == 0 && currentNum != 0) {
            steps = 1;
        } else {
            // Otherwise, 1 step to get to 'product', plus steps from 'product' onwards.
            steps = 1 + getStepsRecursive(product);
        }

        persistenceStepsCache.put(currentNum, steps);
        return steps;
    }

    // Calculates multiplicative persistence for a single number
    public static PersistenceResult calculatePersistence(long number) {
        // The originalNumber is 'number'. Steps are calculated by the recursive helper.
        int steps = getStepsRecursive(number);
        return new PersistenceResult(steps, number);
    }

    // Prints the persistence steps for a given number
    public static void printPersistenceSteps(long number) {
        System.out.println("Steps for " + number + ":");
        System.out.println(number);
        long currentNum = number;
        int stepsCalculated = 0; // To ensure we don't print more steps than actual persistence
        Integer totalPers = persistenceStepsCache.get(number);
        if (totalPers == null) { // Should be populated by calculatePersistence if called before
            totalPers = getStepsRecursive(number); // Calculate if not already
        }

        while (currentNum >= 10) {
            if (stepsCalculated >= totalPers && totalPers != 0) { // Avoid over-printing for numbers like 10->0
                break;
            }
            currentNum = productOfDigits(currentNum);
            System.out.println(currentNum);
            stepsCalculated++;
            if (currentNum == 0) { // Stop if product becomes 0
                break;
            }
        }
        System.out.println("-----");
    }

    // Main logic to find max persistence in a range (Sequential version)
    public static void findMaxPersistenceSequential(long repetitionCount) {
        if (repetitionCount < 1) {
            System.out.println("Repetition count must be at least 1.");
            return;
        }
        // Clear cache if running multiple searches with different characteristics,
        // though for this problem, cache is generally beneficial across runs.
        // persistenceStepsCache.clear();

        PersistenceResult maxPersistenceResult = new PersistenceResult(0, 0);

        for (long i = 1; i <= repetitionCount; i++) {
            PersistenceResult currentResult = calculatePersistence(i);
            if (currentResult.steps() > maxPersistenceResult.steps()) {
                maxPersistenceResult = currentResult;
                System.out.println("New max persistence: " + maxPersistenceResult.steps() + " for number "
                        + maxPersistenceResult.originalNumber());
            }
        }

        System.out.println("\nMaximum persistence found:");
        System.out.println("Number: " + maxPersistenceResult.originalNumber());
        System.out.println("Persistence: " + maxPersistenceResult.steps());
        printPersistenceSteps(maxPersistenceResult.originalNumber());
    }

    // Main logic to find max persistence in a range (Parallel version)
    public static void findMaxPersistenceParallel(long repetitionCount) {
        if (repetitionCount < 1) {
            System.out.println("Repetition count must be at least 1.");
            return;
        }
        // Clear cache if desired, see note in sequential version.
        // persistenceStepsCache.clear();

        System.out.println("Calculating in parallel up to " + repetitionCount + "...");
        System.out.println("Cache size at start: " + persistenceStepsCache.size());

        // Using AtomicReference to hold the best result found so far by parallel
        // threads This is mainly for illustrative "progress" printing in peek.
        // The reduce operation correctly finds the true maximum.
        AtomicReference<PersistenceResult> maxProgressRef = new AtomicReference<>(
                new PersistenceResult(-1, -1)); // Initialize with a dummy worse value

        Optional<PersistenceResult> result = LongStream.rangeClosed(1, repetitionCount)
                .parallel()
                .mapToObj(Solution2Improved::calculatePersistence) // calculatePersistence now uses caching
                .peek(res -> { // Optional: to see progress if needed
                    // Thread-safe update and check if it's a new max for progress printing
                    PersistenceResult currentMax = maxProgressRef.get();
                    if (res.steps() > currentMax.steps()) {
                        // Attempt to set it, if another thread hasn't set an even better one
                        if (maxProgressRef.accumulateAndGet(res,
                                (prev, next) -> next.steps() > prev.steps() ? next : prev) == res) {
                            // System.out.println("Progress: New potential max persistence: " + res.steps()
                            // +
                            // " for " + res.originalNumber() + " (Thread: " +
                            // Thread.currentThread().getName() + ")");
                        }
                    }
                })
                .reduce((pr1, pr2) -> pr1.steps() >= pr2.steps() ? pr1 : pr2);

        if (result.isPresent()) {
            PersistenceResult maxPersistenceResult = result.get();
            System.out.println("\nMaximum persistence found (Parallel):");
            System.out.println("Number: " + maxPersistenceResult.originalNumber());
            System.out.println("Persistence: " + maxPersistenceResult.steps());
            printPersistenceSteps(maxPersistenceResult.originalNumber());
        } else {
            System.out.println("No result found (this shouldn't happen for count >= 1).");
        }
        System.out.println("Cache size at end: " + persistenceStepsCache.size());
    }

    public static void main(String[] args) {

        long testLimit = 277777788888899l; // Reduced for quicker testing, 10^10 is very large
        // Original: 10_000_000_000L;

        // Warm-up (optional, helps JIT compilation for more consistent timing)
        // System.out.println("Warming up...");
        // findMaxPersistenceParallel(100_000);
        // persistenceStepsCache.clear(); // Clear cache after warm-up
        // System.out.println("Warm-up complete.");

        System.out.println("\n--- Parallel ---");
        long startTimeParallel = System.nanoTime();
        findMaxPersistenceParallel(testLimit);
        long endTimeParallel = System.nanoTime();
        System.out.println("Parallel Time: " + (endTimeParallel - startTimeParallel) / 1_000_000_000.0 + " seconds");

    }
}