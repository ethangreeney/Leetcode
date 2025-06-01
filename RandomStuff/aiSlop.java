package RandomStuff;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.LongStream;

// Using a record for better data structure (Java 14+)
// If using older Java, create a simple class with final fields and a constructor.
record PersistenceResult(int steps, long originalNumber) {
}

class Solution2Improved {

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

    // Calculates multiplicative persistence for a single number
    public static PersistenceResult calculatePersistence(long number) {
        long originalNumber = number;
        int steps = 0;
        long currentNum = number;

        while (currentNum >= 10) { // More efficient condition
            currentNum = productOfDigits(currentNum);
            steps++;
            if (currentNum == 0 && steps == 1 && originalNumber != 0) {
                // Special handling if first product is 0 for a non-zero number
                // e.g., 10 -> 0 (1 step)
                // This ensures numbers like 10, 20, etc. get persistence 1
                break;
            }
        }
        return new PersistenceResult(steps, originalNumber);
    }

    // Prints the persistence steps for a given number
    public static void printPersistenceSteps(long number) {
        System.out.println("Steps for " + number + ":");
        System.out.println(number);
        long currentNum = number;
        while (currentNum >= 10) {
            currentNum = productOfDigits(currentNum);
            System.out.println(currentNum);
            if (currentNum == 0)
                break; // Stop if product becomes 0
        }
        System.out.println("-----");
    }

    // Main logic to find max persistence in a range (Sequential version)
    public static void findMaxPersistenceSequential(long repetitionCount) {
        if (repetitionCount < 1) {
            System.out.println("Repetition count must be at least 1.");
            return;
        }

        PersistenceResult maxPersistenceResult = new PersistenceResult(0, 0); // Start with 0 persistence

        // Numbers 0-9 have persistence 0. Start from 10 if you only care about
        // multi-step persistence.
        // Or start from 1 if 0-step persistence for single digits is considered.
        // For this problem, typically we are interested in numbers > 9.
        // Let's iterate from 1 as per original code.
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

        System.out.println("Calculating in parallel up to " + repetitionCount + "...");

        // Using AtomicReference to hold the best result found so far by parallel
        // threads
        // This is a simple way to manage the max. For very high contention, other
        // strategies might be better.
        AtomicReference<PersistenceResult> maxPersistenceResultRef = new AtomicReference<>(
                new PersistenceResult(-1, -1)); // Initialize with a dummy worse value

        // LongStream.rangeClosed is inclusive
        Optional<PersistenceResult> result = LongStream.rangeClosed(1, repetitionCount)
                .parallel() // THE KEY FOR PARALLELISM
                .mapToObj(Solution2Improved::calculatePersistence)
                .peek(res -> { // Optional: to see progress if needed, can be verbose
                    if (res.steps() > maxPersistenceResultRef.get().steps()) {
                        // This is not perfectly thread-safe for printing the *absolute* latest max
                        // but good enough for indicative progress and the final reduce will get the
                        // true max.
                        // For true thread-safe update of max for printing, use accumulateAndGet or
                        // compareAndSet in a loop.
                        // However, the reduce operation below correctly finds the overall maximum.
                        // System.out.println("Thread " + Thread.currentThread().getName() + " found
                        // potential new max: " + res.steps() + " for " + res.originalNumber());
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
    }

    public static void main(String[] args) {

        long testLimit = 10000000000L;

        System.out.println("\n--- Parallel ---");
        long startTimeParallel = System.nanoTime();
        findMaxPersistenceParallel(testLimit);
        long endTimeParallel = System.nanoTime();
        System.out.println("Parallel Time: " + (endTimeParallel - startTimeParallel) / 1_000_000_000.0 + " seconds");

    }
}