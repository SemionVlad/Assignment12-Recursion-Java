/**
 * Ex12 - Recursive methods for Maman 12 assignment.
 * Implements three methods: digitDiffer, numWaysToClimb, and solutions.
 * 
 * @author Shimon Esterkin
 * @version 2025B
 */
public class Ex12 {

    /**
     * Compares two integers of equal length and returns
     * the number of differing digits in corresponding positions.
     * This method uses recursion and does not use loops or helper methods.
     *
     * @param a First integer
     * @param b Second integer
     * @return Number of digits that differ
     */
    public static int digitDiffer(int a, int b) {
        if (a == 0 && b == 0)
            return 0;

        // Compare last digits and add 1 if they differ
        int diff = (a % 10 != b % 10) ? 1 : 0;

        // Recurse on the rest of the digits
        return diff + digitDiffer(a / 10, b / 10);
    }

    /**
     * Calculates the number of different ways to climb a staircase
     * of n steps, taking 1 or 2 steps at a time.
     * This method is recursive and uses no loops.
     *
     * @param n Total number of steps
     * @return Number of ways to climb the staircase
     */
    public static int numWaysToClimb(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        // At each step, choose to take 1 or 2 steps
        return numWaysToClimb(n - 1) + numWaysToClimb(n - 2);
    }

    /**
     * Finds and prints all combinations of three integers (between 1 and 10)
     * that sum to the given number. Also returns the total number of such solutions.
     * Uses recursion and allows helper methods with overloading.
     *
     * @param num Target sum of three integers
     * @return Number of valid solutions
     */
    public static int solutions(int num) {
        if (num < 3 || num > 30)
            return 0;

        // Start recursion with x = 1, y = 1, z = 1
        return solutions(num, 1, 1, 1);
    }

    /**
     * Recursive helper method to evaluate all combinations of x, y, z
     * where 1 <= x,y,z <= 10 and x + y + z == num.
     *
     * @param num Target sum
     * @param x First number
     * @param y Second number
     * @param z Third number
     * @return Count of valid combinations found so far
     */
    private static int solutions(int num, int x, int y, int z) {
        if (z > 10) {
            // Move to next y value if z exceeds limit
            if (y < 10)
                return solutions(num, x, y + 1, 1);

            // Move to next x value if y also exceeds limit
            else if (x < 10)
                return solutions(num, x + 1, 1, 1);

            // All combinations have been checked
            else
                return 0;
        }

        int count = 0;

        // If valid combination found, print it and count it
        if (x + y + z == num) {
            System.out.println(x + " + " + y + " + " + z);
            count = 1;
        }

        // Recurse on next z value
        return count + solutions(num, x, y, z + 1);
    }
}
